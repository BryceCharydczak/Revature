var count = 0;
var sides, jsonOBJ;
var currentSlideInterval = 1;

//logic for input comparison to json object
//if (AccountsObject[0].username == )


function clickedButton(){
    var AccountsObject = JSON.parse(Accounts);
    var user = document.getElementById('user').value;
    var pass = document.getElementById('pass').value;

    if(AccountsObject[0].username != user && AccountsObject[0].password != pass){
        alert("Both the Username and Password are incorrect!");
    } else if (AccountsObject[0].username != user){
        alert("Username is incorrect!");
        if (AccountsObject[0].password != pass){
            alert("Password is incorrect!");
        }
    } else{
    window.open("Flashcards.html","_self");
    }
    
}

var buttonele = document.getElementsByTagName('button');
    for ( var i = 0; i < buttonele.length; i++){
        if(buttonele[i].getAttribute('id') == 'primary'){
            buttonele[i].addEventListener('click', redirectTen);
        }
        if(buttonele[i].getAttribute('id') == 'secondary'){
            buttonele[i].addEventListener('click', redirectSingle)
        }
        if(buttonele[i].getAttribute('id') == 'back'){
            buttonele[i].addEventListener('click', backCard)
        }
        if(buttonele[i].getAttribute('id') == 'next'){
            buttonele[i].addEventListener('click', nextCard)
        }
    }

function backCard(){
    sides = document.getElementsByClassName('side');
    jsonOBJ = JSON.parse(Translations);

    if (count == 0){
        alert("You have reached the front of the list");
    } else {
    count--;
    
    for ( var i = count*2; i < count*2+2; i++){
        if (i % 2 == 0){
            sides[i].innerHTML = jsonOBJ[count].definition;

        } else {
            sides[i].innerHTML = jsonOBJ[count].word;
        }
    }
}


}

function nextCard(){
    sides = document.getElementsByClassName('side');
    jsonOBJ = JSON.parse(Translations);

    if (count == 9){
        alert("You have reached the end of the list");
    } else {
    count++;
    
    for ( var i = count*2; i < count*2+2; i++){
        if (i % 2 == 0){
            sides[i].innerHTML = jsonOBJ[count].definition;

        } else {
            sides[i].innerHTML = jsonOBJ[count].word;
        }
    }
}

}

function redirectSingle(){
    window.open("FlashcardsSingle.html","_self");
}
function redirectTen(){
    window.open("Flashcards.html","_self");
}
function start1(){
    sides = document.getElementsByClassName('side');
    jsonOBJ = JSON.parse(Translations);

    console.log(count);
    sides[0].innerHTML = jsonOBJ[count].definition;
    sides[1].innerHTML = jsonOBJ[count].word;

    }


//https://stackoverflow.com/questions/37872561/html-add-elements-dynamically-using-js
function start10(){
    sides = document.getElementsByClassName('side');
    jsonOBJ = JSON.parse(Translations);

    counter = Object.keys(jsonOBJ).length;

    
    console.log(counter);

    for (var i = 0 ; i < counter; i++){
        for (var j = i*2; j < i*2+2; j++){
            if (j%2 == 0){
                sides[j].innerHTML = jsonOBJ[i].definition;
            } else {
                sides[j].innerHTML = jsonOBJ[i].word;

            }
        }

    }

}

