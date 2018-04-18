/* 1. Leap Year */

function leapYear(date){
    var answer = false;
    if ((date % 4 === 0)){
        answer = true;
    }
    if (date % 100 ===0 && !(date % 400 === 0)){
        answer = false;
    }
    return answer;
}

/* 2. Email Validation */

function isEmail(string){
    var answer = false;
    if (string.contains("@") && (string.contains(".com")||(string.contains(".edu")||(string.contains(".org"))))){
        answer = true;
    }
    return answer;
}

/* 3. Remove Character */

function removeChar(string, position){
    var answer = "";
    answer += string.substring(0, position);
    answer += string.substring(position+1, string.length);
    return answer;
}

/* 4. Remove "Script" */

function removeScript(string){
    var answer = "";
    if (string.contains("Script")){
        var start = string.indexOf("Script");
        answer += string.substring(0,start);
        answer += string.substring(start+6, string.length);
        return answer;

    } else {
        return string;
    }
}

/* 5. Letter Shift */

function letterShift(string){
    var answer = "";
    for (var i =0; i < string.length; i++){
        if (string[i].charCodeAt(0) === 122){
            answer += "a";
        } else {
            answer += String.fromCharCode(string[i].charCodeAt(0) + 1);
        }
    }
    return answer;
}

/* 6. Vowel Count */

function vowelCount(string){
    var answer = 0;
    var vowels = ["a","e","i","o","u"];
    for (var i = 0; i < string.length; i++){
        if (vowels.contains(string[i])){
            answer++;
        }
    }
    return answer;
}

/* 7. Reverse Array */

function reverseArr(array){
    var answer = "";
    for(var i = array.length-1; i > -1; i--){
        answer += array[i];
    }
    return answer;
}

/* 8. Add Array */

function addArr(array, array2){
    var arrayLength = 0;
    var answer = [];
    if (array.length > array2.length){
        arrayLength = array.length;
    } else {
        arrayLength = array2.length;
    }
    for (var i = 0; i < arrayLength; i++){
        if ((array[i] && array2[i]) != null){
            answer.push(array[i] + array2[i]);
        } else if (array[i] === null) {
            answer.push(array2[i]);
        } else {
            answer.push(array[i]);
        }
    }
    return answer;
}

/* 9. Longest String */

function longestStr(array){
    var currentMaxLength = "";
    console.log("Not done implementing");
    for (var i = 0; i < array.length; i++){
        if (array[i].length > currentMaxLength.length){
            currentMaxLength = array[i];
        }
    }
    return currentMaxLength;
}

/* 10. Area of a Triangle */

function area(number1, number2, number3){
    
}

/* 11. Similar Polygons */

function areSimilar(array1, array2){

}

/* 12. Equivalent Arrays */

function equvArr(array1, array2){
    var firstBiggest;
    (array1.length === array2.length)? firstBiggest=true : firstBiggest=false;
    // my attempt at making the most disgusting nested ternary operation to fit this whole function on 1 line
    // gave up because Byron thought I was losing my mind and I think for loops can not be used in ternarys
  //  firstBiggest ? for(var i in array1){if(!array2.contains(i)){return false;}} else{return true;} : return false;

    if (firstBiggest === false){
        return false;
    } else {
        for (var i = 0; i < array1.length; i++){
            if (!array2.contains(array1[i])){
                return false;
            }
        }
        return true;
    }
}

/* 13. Tic Tac Toe */

function tictactoe(array) {
    var oCount = 0;
    var xCount = 0;
    var xWins = 0;
    var oWins = 0;
    var notDone = false;

    //Checking if there are less than 9 inputs
    for (var i = 0; i < array.length; i++) {
        for (var j = 0; j < array[i].length; j++) {
            if (array[j][i] === "O") {
                oCount++;
            } else if (array[j][i] === "X") {
                xCount++;
            }
        }
    }
    if (oCount + xCount !== 9) {
        notDone = true;
    }
    //Horizontal scan
    for (var i = 0; i < array.length; i++){
        if (!array[i].contains("O")){
            xWins++;
        } else if (!array[i].contains("X")){
            oWins++;
        }
    }
    //Vertical Scan
    for (var i = 0; i < array.length; i++){
        var temp = [];
        for (var j = 0; j< array.length; j++){
            temp.push(array[j][i]);
        }
        if (!temp.contains("O")){
            temp = [];
            xWins++;
        } else if (!temp.contains("X")){
            temp = [];
            oWins++;
        }
    }

    //Diagonal scan
    var tempDia = [];
    var tempDia2 = [];
    for (var i = 0; i < array.length; i++){
        tempDia.push(array[i][i]);
        tempDia2.push(array[i][array.length-1-i]);
    }
    if (!tempDia.contains("O") || !tempDia2.contains("O")){
        xWins++;
    } else if (!tempDia.contains("X") || tempDia2.contains("X")){
        oWins++;
    }

    //Determining the result of the game
    if (oWins > 0 && xWins === 0){
        return "O is the winner";
    } else if (xWins > 0 && oWins ===0){
        return "X is the winner";
    } else if (xWins ===0 && oWins ===0 && !notDone){
        return "No winner yet";
    } else if (xWins ===0 && oWins ===0 && notDone) {
        return "Tie Game";
    } else{
        return "Invalid result";
    }
}



//instantiation of the contains functionality used for all functions checking arrays.
Array.prototype.contains = function(elem)
{
    for (var i in this)
    {
        if (this[i] == elem) return true;
    }
    return false;
}