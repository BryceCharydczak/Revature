
var baseUrl = "http://api.apixu.com/v1/current.json?key=8fe4facb7e58442e967153813181204&q=";

function searchWeather(){
    var input = document.getElementById("zipcode").value;
    // if(input.length !== 5 | input <0){
    //     document.getElementById("alert").innerHTML = "Invalid zipcode<br>";
    // } else {
    document.getElementById("alert").innerHTML = "";
    sendAjaxCall(baseUrl + input, displayWeather);

    //}
}

function sendAjaxCall(url,func){
    document.getElementById("alert").innerHTML = "";
    var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
    xhr.onreadystatechange = function(){
        if(this.readyState == 4 && this.status == 200){
            func(this);
        }
    }
    xhr.open("GET", url);
    xhr.send();
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