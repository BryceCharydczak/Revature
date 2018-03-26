


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

var everything = document.getElementsByTagName('*');
    for (var i = 0; i < everything.length; i++){
        if(everything[i].getAttribute("id") == "one"){
            console.log("got it");
        }
    }

