function searchWeather(){
    var input = document.getElementById("zipcode").value;
     if(input.length !== 5 | input <0){
         document.getElementById("alert").innerHTML = "Invalid zipcode<br>";
    } else {
    document.getElementById("alert").innerHTML = "";
    fetch(baseUrl+input)
        .then(function(response){
            if(!response.ok){
                document.getElementById("alert").innerHTML = "invalid zipcode";
                throw Error("Invalid zip error");
            }
            return response.json();
         })
        .then(function (myJson) {
            displayWeather(myJson);
        })
        .catch(function (error) {
            console.log(error);
        })
    }
}


function displayWeather(xhr){
    response = xhr.response;
    weather = JSON.parse(response);
    document.getElementById("location").innerHTML = "Weather for " + weather.location.name;
    document.getElementById("icon").setAttribute("src", "http://" +weather.current.condition.icon);
    document.getElementById("icon").setAttribute("alt", weather.current.condition.text);
    document.getElementById("status").innerHTML = weather.current.condition.text;
    document.getElementById("temperature").innerHTML = weather.current.temp_f;
}