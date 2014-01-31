import csv
from collections import defaultdict
import heapq

class MetroPop:
    # used defaultdict for stateMap since I need to keep appending to the keys value
    stateMap = defaultdict(list)
    cityMap = {}

    # cities algorithm #
    rateQueue = []
    # states algorithm #
    stateRateQueue = []

    # used for cumulative growth rate for each state #
    cumulativeState = {}

    population_in_USA_2012 = 315091138.0

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

            # makes sure that I don't divide anything by zero #
            if pop2010 > 0 and pop2011 > 0 and pop2012 > 0:
                rateFrom2010_11 = self.__findRate(pop2011, pop2010)
                rateFrom2011_12 = self.__findRate(pop2012, pop2011)
                rateFrom2010_12 = self.__findRate(pop2012, pop2010)
                weightedRate = pop2012/self.population_in_USA_2012*rateFrom2010_12
                
                # using a map to track states cumulative growth rate from 2010 to 2012 (weighted)
                # the try/except block will run 51 times, for each 51 state, but after they are in the map
                # the else clause will run everytime after for each city.
                try:
                    self.cumulativeState[split[1]]
                except KeyError:
                    self.cumulativeState[split[1]] = weightedRate
                else:
                    temp = self.cumulativeState[split[1]]
                    self.cumulativeState[split[1]] = weightedRate + temp


                popList = [
                            #the reason why i take the population of the city and divide it by the entire population
                            #of the USA, is that I need to see who's growth rate has more weight depending on their
                            #population size in aspect of the entire nation. because if a city of population 100
                            #grew to 400 their rate would be 300%, but in aspect to the USA, the popuplation
                            #growth rate does not weigh heavily against a population of 30,000 and a rate of 10% growth.
                            weightedRate, 
                            split[0],
                            rateFrom2010_12, 
                            rateFrom2010_11, 
                            rateFrom2011_12
                            ]

                #makes sure that these populations are 50k or over
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


        self._pushStateRateToHeap()


    def __findRate(self, pop1, pop2):
        return (pop1 - pop2) / (pop2) * 100

    def _pushStateRateToHeap(self):
        for state in self.cumulativeState:
            val = self.cumulativeState[state]
            heapq.heappush(self.stateRateQueue, (val, state))
        #print len(switchDict) -- made sure new dict had 51 items

    def getCityMap(self):
        return self.cityMap

    def getStateMap(self):
        return self.stateMap

    def getStateRateQueue(self):
        return self.stateRateQueue

    def getRateQueue(self):
        return self.rateQueue

    def getCumulative(self):
        return self.cumulativeState

mp = MetroPop();
count=1;

print "0 --> Weighted Population Rate of 2010-12 with entire U.S. Population"
print "1 --> City "
print "2 --> Population Rate From 2010 to 2012"
print "3 --> Population Rate From 2010 to 2011"
print "4 --> Population Rate From 2011 to 2012"
print "\n"

print "Top 5 Cities to Target\n"
for top5 in heapq.nlargest(5, mp.getRateQueue()):
    print "Top " + str(count)
    print('\n'.join('{}: {}'.format(*k) for k in enumerate(top5)))
    print "\n"
    count+=1

print "\n"
count=1

print "Top 5 Cities to Avoid\n"
for least5 in heapq.nsmallest(5, mp.getRateQueue()):
    print "Top " + str(count)
    print('\n'.join('{}: {}'.format(*k) for k in enumerate(least5)))
    print "\n"
    count+=1

print "\n"
count=1

print "0 --> Cumulative State Rate"
print "1 --> City "
print "\n"

print "Top 5 States to Target\n"
for top5 in heapq.nlargest(5, mp.getStateRateQueue()):
    print "Top " + str(count)
    print('\n'.join('{}: {}'.format(*k) for k in enumerate(top5)))
    print "\n"
    count+=1


