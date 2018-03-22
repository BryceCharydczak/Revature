function getUSA(){
    var temp = document.getElementsByTagName("span");
    var answer = temp[2].innerHTML;
    console.log(answer);
}

function getPeopleInSales(){
    var temp = document.getElementsByTagName("td");
    for (var i = 0; i < temp.length; i++){
        if(temp[i].innerHTML == "Sales"){
            console.log(temp[i-1].innerHTML);
        }
    }
}

function getAnchorChildren(){
    var temp = document.getElementsByTagName('span');
    for (var i = 0; i < temp.length; i++){
        console.log(temp[i].innerHTML);
    }

function getHobbies(){
    var temp = document.getElementsByTagName('*');
    for (var i = 0; i < temp.length; i++){
        if(temp[i].getAttribute('name') == 'skills'){
            var blah = temp[i].childNodes;
            for (var j = 0; j < blah.length; j++){
                if(blah[j].getAttribute('selected') == 'selected'){
                    console.log(blah[j].innerHTML);
                }
            }
        }
    }

}

function getCustomAttribute(){
    var val = $("[data-customAttr]");
    for ( var i = 0; i < val.length; i++){
        console.log(val[i]);
        console.log(val[i].innerHTML);
    }
}

//6
document.getElementById('num1').addEventListener('input',sumEvent);
document.getElementById('num2').addEventListener('input',sumEvent);

function sumEvent(){
   var num1 = Number(document.getElementById('num1').value);
   var num2 = Number(document.getElementById('num2').value);
   var sumNums = num1 + num2;

   document.getElementById('sum').innerHTML = sumNums;
   
}

//7
var skills = document.getElementsByTagName('*');
    for( var i = 0; i < skills.length; i++){
        if(skills[i].getAttribute('name') == 'skills'){
            skills[i].addEventListener('click', pingAlert);
        }
    }
function pingAlert(){
    pingStr = "Are you sure " + this.getAttribute('value') + " is one of your skills?";
    alert(pingStr);
}


//8
var everything = document.getElementsByTagName('*');
    for (var i = 0; i < everything.length; i++){
        if(everything[i].getAttribute("name") == "favoriteColor"){
            everything[i].addEventListener("click", colorChange);
        }
    }

    var lastclick = "none";

function colorChange(){
    if(lastclick != this.getAttribute('value') && lastclick != "none"){
    var alertStr = "So you like " 
    alertStr+= this.getAttribute("value")
    alertStr+="more than "
    alertStr+= lastClick
    alertStr+=" now?"; 
    alert(alertStr);
    }
    lastClick = this.getAttribute('value');
}

//9
var x = document.getElementsByClassName('empName');
for (var i = 0; i < x.length; i++){
    x[i].addEventListener('mouseover', hideEmployees);
}
function hideEmployees() {    
    if (this.style.visibility == 'hidden') {

        this.style.visibility = 'visible';
    } else {
        this.style.visibility = 'hidden';
    }

}

//10
setInterval(function(){
    var x = new Date();
    var y = x.toLocaleTimeString();
    document.getElementById('currentTime').innerHTML = y;
}, 1000);





//11
document.getElementById('helloWorld').addEventListener('click',delay);
function delay(){

    setTimeout(function(){
    var finalAnswer = "rgb(";
    finalAnswer+= Math.floor(Math.random()*255);
    finalAnswer+= ",";
    finalAnswer+= Math.floor(Math.random()*255);
    finalAnswer+= ",";
    finalAnswer+= Math.floor(Math.random()*255);
    finalAnswer+=")";
    document.getElementById('helloWorld').style.color = finalAnswer;},3000);
}
