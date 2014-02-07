var Anagram = require('./anagram');


var detector = new Anagram("ant");
    var matches = detector.match(['tan', 'stand', 'at']);

console.log(matches);