var capturing = true;
var bubbling = false;



document.getElementById('inner').addEventListener("click", function(e){
    alert("Inner!");
}, bubbling);

document.getElementById('middle').addEventListener("click", function(e){
    alert("Middle!");
}, bubbling);

document.getElementById('outer').addEventListener("click", function(e){
    alert("Outer!");
}, bubbling);