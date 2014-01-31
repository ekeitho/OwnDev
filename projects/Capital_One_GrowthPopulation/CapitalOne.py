# author : Keith Abdulla
# school : Cal Poly San Luis Obispo
# contact : email@ekeitho.com

import csv
from collections import defaultdict
import heapq


class MetroPop:
    # used defaultdict for stateMap since I need to keep appending to the keys
    # value
    stateMap = defaultdict(list)
    cityMap = {}

    # cities sort algorithm #
    rateQueue = []
    # states sort algorithm #
    stateRateQueue = []

    # used for cumulative growth rate for each state #
    cumulativeState = {}

    population_of_USA_2012 = 315091138.0

    def __init__(self):
        metroDict = csv.DictReader(
            open("metro.csv"),
            delimiter=',',
            quotechar='"')

        for row in metroDict:

            # for instance ['San Luis Obispo', 'California']
            split = row['Geography'].split(", ")

            # split the populations accordingly #
            pop2010 = float(row['2010 Population'])
            pop2011 = float(row['2011 Population'])
            pop2012 = float(row['2012 Population'])

            # makes sure that I don't divide floats by zero #
            if pop2010 > 0 and pop2011 > 0 and pop2012 > 0:
                rateFrom2010_11 = self.__findRate(pop2011, pop2010)
                rateFrom2011_12 = self.__findRate(pop2012, pop2011)
                rateFrom2010_12 = self.__findRate(pop2012, pop2010)

                # the reason why i take the population of the city and divide it by the entire population
                # of the USA, is that I need to see who's growth rate has more weight depending on their
                # population size in aspect of the entire nation. because if a city of population 100
                # grew to 400 their rate would be 300%, but in aspect to the USA, the popuplation
                # growth rate does not weigh heavily against a population of
                # 30,000 and a rate of 10% growth.
                weightedRate = pop2012 / \
                    self.population_of_USA_2012 * rateFrom2010_12

                # using a map to track states cumulative growth rate from 2010 to 2012
                # the try/except block will run 51 times, for each 51 state, but after they are in the map
                # the else clause will run everytime after for each city.
                # to see output of the program with rate from 2010-2012 and not weighted rate
                # change variable 'weightedRate' with 'rateFrom2010_12'
                try:
                    self.cumulativeState[split[1]]
                except KeyError:
                    self.cumulativeState[split[1]] = rateFrom2010_12
                else:
                    temp = self.cumulativeState[split[1]]
                    self.cumulativeState[split[1]] = rateFrom2010_12 + temp

                popList = [
                    # weightedRate, could be used as the sorts deciding rate to get
                    #cities with largest Numperic Population Increase
                    rateFrom2010_12,
                    split[0],
                    split[1],
                    rateFrom2010_11,
                    rateFrom2011_12,
                    weightedRate
                ]

                # makes sure that these populations are 50k or over
                if pop2011 and pop2010 and pop2012 > 49999:
                    heapq.heappush(self.rateQueue, popList)

            # adds a '.' if there are multiple cities with same name.
            # i chose to use a dictionary even though it doesn't allow duplicates
            # since I need to get access them quickly by name
            while split[0] in self.cityMap:
                split[0] += '.'

            # creates a dictionary of cities with their rates #
            self.cityMap[split[0]] = popList

            # creates a dictionary of states with their cities #
            self.stateMap[split[1]].append(split[0])

        # once everything is completed, it's now okay to put state cumulative
        # rates into the heap
        self._pushStateRateToHeap()

    def __findRate(self, pop1, pop2):
        return (pop1 - pop2) / (pop2) * 100

    def _pushStateRateToHeap(self):
        for state in self.cumulativeState:
            val = self.cumulativeState[state]
            heapq.heappush(self.stateRateQueue, (val, state))
        # print len(switchDict) -- made sure new dict had 51 items

    def getCityMap(self):
        return self.cityMap

    def getStateMap(self):
        return self.stateMap

    def getStateRateQueue(self):
        return self.stateRateQueue

    def getRateQueue(self):
        return self.rateQueue

##### wrote ouput in same file for the challenge ####
mp = MetroPop()
count = 1


print "Top 5 Cities to Target Based on Population Growth Rate\n"
for top5 in heapq.nlargest(5, mp.getRateQueue()):
    print "%1.f. " % count + top5[1] + ", " + top5[2]
    print "      : " + "%.3f" % top5[0] + "%"
    count += 1


count = 1
print "\n"
print "Top 5 Cities to Avoid Based on Population Growth Rate\n"
for least5 in heapq.nsmallest(5, mp.getRateQueue()):
    print "%1.f. " % count + least5[1] + ", " + least5[2]
    print "      : " + "%.3f" % least5[0] + "%"
    count += 1


count = 1
print "\n"
print "Top 5 States to Target (cumulative percentage)\n"
for top5 in heapq.nlargest(5, mp.getStateRateQueue()):
    print "%1.f. " % count + top5[1]
    print "      : " + "%.2f" % top5[0] + "%"
    count += 1
