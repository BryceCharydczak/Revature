var URL = "http://localhost:8082/";

function fillTable(xhr){
    ticketsArr = JSON.parse(xhr.responseText);

    table = document.getElementById("table");

    for(i in ticketsArr){
        var id = ticketsArr[i].reimbursementID;
        var amount = ticketsArr[i].amount;
        var description = ticketsArr[i].description;
        var type = ticketsArr[i].typeID;
        var submitTime = ticketsArr[i].subTime;
        var author = ticketsArr[i].author;
        var status = ticketsArr[i].status;


        Row = document.createElement("tr");
        Row.innerHTML = `
        <td>${id}</td>
        <td>${author}</td>
        <td>${amount}</td>
        <td>${description}</td>
        <td>${type}</td>
        <td>${submitTime}</td>
        <td>${status}</td>
`;
        table.appendChild(Row);
    }
}

function sendAJAX(url, func){
    let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
    xhr.onreadystatechange = function(){
        if (this.readyState == 4 && this.status == 200){
            func(this);
        }
    }
    xhr.open("GET",url);
    xhr.send();
}