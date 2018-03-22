console.log("helloworld");

function add(x,y){
    answer = x+y;
    return answer;
}
/*
Recursive format, not optimal.

function fib(number){
    if (number <=1){
        return number;
    } else {
        return (fib(number-1)+fib(number-2));
    }
}
*/


function fib(number){
    var arr = [0,1];
    for (var i = 2; i < number+1; i++){
        arr[i] = arr[i-1] + arr[i-2];
    }
    return arr[number];

}


function palindrome(string){
    var count = 0;
    for(var i = 0; i < string.length; i++){
        if (string.charAt(i) != string.charAt(string.length-1-i)){
            count++;
        }
    }
    if (count > 0){
        return false;
    } else {
        return true;
    }
}

function isEven(number){
    var temp = number/2;
    var tempStr = temp.toString();
    if (tempStr.includes(".")){
        return false;
    } else {
        return true;
    }
}

function bubbleSort(numArray){
    for (var i = 0; i < numArray.length; i++){
        for (var j = 0; j < numArray.length-1; j++){
            if (numArray[j+1] < numArray[j]){
                var temp = numArray[j+1];
                numArray[j+1] = numArray[j];
                numArray[j] = temp;
            }
        }
    }
    return numArray;
}

function printShape(shape, height, character){
    var count = 1;
    var buildStr = character;
    if (shape == "Square"){
        for (var i = 0; i < height; i++){
            buildStr = character;
            for (var j = 0; j < height-1; j++){
                buildStr+=character;
            }
            console.log(buildStr);
        }
        
    } else if (shape == "Triangle"){
        for (var i = 0; i < height; i++){
            console.log(buildStr)
            buildStr+=character;
        }
    } else {
        var midpoint = Math.floor(height/2)+1;
        var arr = new Array(height);
        arr.fill("2");
        console.log(arr);
        
    }
    
}
function balancedBrackets(string){
    var count = 0;
    for(var i = 0; i < string.length; i++){
        if (string.charAt(i) != string.charAt(string.length-1-i)){
            count++;
        }
    }
    if (count > 0){
        return true;
    } else {
        return false;
    }
}

function arrayFilter(array){
    var answerArray = [];
    for (var i = 0; i < array.length; i++){
        if (array[i].length == 4){
            answerArray.push(array[i]);
        }
    }
    return answerArray;
}

function invest(principal, interest, tax, desired){
    var newPrin = principal;
    var count = 0;
    while (newPrin < desired){
        var gains = newPrin * interest;
        var taxLoss = gains * tax;
        newPrin += gains-taxLoss;
        count++;
    }
    return count;
}

function rotateLeft(array, number){
    var realSize = number%array.length;
    var left = array.slice(realSize, array.length);
    var right = array.slice(0,realSize);
    var answer = left.concat(right);
    return answer;
}
