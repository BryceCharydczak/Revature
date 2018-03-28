window.onload = function(){
    $('#submit').on('click', getInfo);
}

var jedi;

function getInfo(){
    var id = $('#id').val();
/*
    fetch(`https://swapi.co/api/people/${id}`).then(function(response) {
        response.jsonthen(function(jedi){
            $('#name').html(jedi.name);

        }).catch($('#name').html("invalid character id"));
    });
*/
    //4 steps of AJAX
    //create xhr object
    var xhr = new XMLHttpRequest();
    //open xhr call
    xhr.open("GET", `https://swapi.co/api/people/${id}`, true);
    //send xhr
    xhr.send();
    //xhr callback function - function to handle the response once it is processed
    xhr.onreadystatechange = function() {
        console.log(xhr.readyState);
        if(xhr.readyState == 4 && xhr.status == 200){
            jedi = JSON.parse(xhr.responseText);
            console.log(jedi);


            //manipulate the DOM
            $('#name').html(jedi.name);
        }
    }
    
    
}