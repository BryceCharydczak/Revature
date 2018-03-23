function fib(number){
    var arr = [0,1];
    for (var i = 2; i < number+1; i++){
        arr[i] = arr[i-1] + arr[i-2];
    }
    return arr[number];

}

function runFib(){
    prompt("In runFib function");
    var input = document.getElementById("fib").value;
    var display = document.getElementById("fibDisplay");

    display.innerHTML = fib(input);
}

document.getElementById("doFib").addEventListener("click", runFib);