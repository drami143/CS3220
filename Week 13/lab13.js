// Desiree Ramirez

console.log();
loopState([8, 12, 52, -32, 10, 111, 65, 89]);

console.log();
forEach([0, 92, 52, 39, 10, 75, 84, 9]);

console.log();
reduction([43, 21, 90, 54, 2, -12, -999, 5, 200]);

console.log();
console.log("Count the number of times the words are present in the following array: " + "['hi', 'hi', 'hello', 'world', 'hello', 'hi', 'greetings', 'World']");
countingWords(['hi', 'hi', 'hello', 'world', 'hello', 'hi', 'greetings', 'World']);

console.log();
console.log("Sum all the numbers in the array: " + "[5, 2, 'a', 4, '7', true, 'b', 'c', 7, '8', false]");
getTotalSumArray([5, 2, 'a', 4, '7', true, 'b', 'c', 7, '8', false]);


function loopState(largest) {
    maxVal = largest[0];
    for (let i = 1; i < largest.length; i++) {
        if (largest[i] > maxVal) {
            maxVal = largest[i];
        }
    }
    console.log("Largest number using a loop statement: " + maxVal);
}

function forEach(largest) {
    maxVal = Number.MIN_VALUE;
    largest.forEach(function(el) {
        if (el > maxVal) {
            maxVal = el;
        }
    });
    console.log("Largest number using forEach() method: " + maxVal);
}

function reduction(largest) {
    const getMax = (a, b) => Math.max(a, b);
    console.log("Largest number using reduce() method: " + largest.reduce(getMax, Number.MIN_VALUE));
}

// d) (10pt) Write a function called countingWords(ignore case) which 
// takes an array as a parameter and it counts the number of times they 
// are present in the following array:
//                 ['hi', 'hi', 'hello', 'world', 'hello', 'hi', 'greetings', 'World']
function countingWords(words){
    var count = [];
    for(let i = 0; i < words.length; i++){
        let arr = words[i].toLowerCase();
        if(arr in count){
            count[arr] += 1;
        }
        else{
            count[arr.toLowerCase()] = 1;
        }
    }
    console.log(count);
}

// Write a function called getTotalSumArray which takes an array
//  as a parameter and sums all the numbers in the following array: 
// [5, 2, 'a', 4, '7', true, 'b', 'c', 7, '8', false]
function getTotalSumArray(sum){
    let array = [5, 2, 'a', 4, '7', true, 'b', 'c', 7, '8', false];
    let numbers = [];
    let letters = [];
    let total = 0;

    for(let i = 0; i < sum.length; i++){
        if(isNaN(sum[i])){
            letters.push(sum[i]);
        } else{
            numbers.push(sum[i]);
        }
    }
    numbers = numbers.reduce((a, b) => a + b, 0);
    letters = letters.toString().split("");
    letters.forEach( i =>{
        array.forEach(j =>{
            if( i === j){
                total += array.indexOf(i) + 1;
            }
        })
    })
    console.log(total);
}
