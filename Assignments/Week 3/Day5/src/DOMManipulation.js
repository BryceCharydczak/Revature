var list = document.getElementsByTagName("a");
for (var i = 0; i < list.length; i++){
    switch(list[i].name){
        case "google":
            list[i].innerHTML = "Google";
            list[i].href = "https://www.google.com";
            break;
        case "twitter":
            list[i].innerHTML = "Twitter";
            list[i].href = "https://www.twitter.com";
            break;
        case "slack":
            list[i].innerHTML = "Slack";
            list[i].href = "https://www.slack.com";
            break;
        case "javadocs":
            list[i].innerHTML = "Javadocs";
            list[i].href = "https://docs.oracle.com/javase/7/docs/api/";
            break;
    }
}

document.getElementById("planet").options[3].disabled=true;



function alienText(){
    if (document.getElementsByTagName("p").style.visibility ==="hidden") {
        document.getElementsByTagName("p").removeAttribute('hidden');
    } else {
        document.getElementsByTagName("p").style.visibility = "hidden";
    }
}

//7
document.getElementById("earth_time_check").addEventListener("click", function(){
    var today = new Date();
    var answer = (today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds());
    var answerStringPM = (answer + " PM");
    var answerStringAM = (answer + " AM");
    if ( today.getHours() >= 12 && today.getMinutes() >= 0 && today.getSeconds() >= 0) {
        document.getElementById("earth_time").innerHTML = answerStringPM;
    } else {
        document.getElementById("earth_time").innerHTML = answerStringAM;
    }
});




var s0 = document.getElementById('planet');


s0.addEventListener('change', function () {
    if (this.selectedIndex === 1 | this.selectedIndex === 2) {
        var t0 = document.getElementsByTagName('p');
        for (var t1 = 0; t1 < t0.length; t1++) {
            if (t0[t1].innerHTML == 'Beep boop') {
                t0[t1].removeAttribute('hidden');
            }
        }

    }
    else {
        if (this.selectedIndex === 0) {
            var t0 = document.getElementsByTagName('p');
            for (var t1 = 0; t1 < t0.length; t1++) {
                if (t0[t1].innerHTML == 'Beep boop') {
                    t0[t1].setAttribute('hidden', 'hidden');
                }
            }
        }
    }
});


s0 = document.getElementsByTagName('details')[0];
s0.addEventListener('mouseover', function () {
    this.setAttribute('open', 'open');
});

s0.addEventListener('mouseout', function () {
    this.removeAttribute('open');
});

function concatenatedSpans() {

    var t0 = document.getElementsByTagName('span');
    var t1 = t0.length;

    var v0 = "";
    for (var t2 = 0; t2 < t1; t2++) {
        v0 += t0[t2].innerHTML;
    }
    console.log(v0);
}

concatenatedSpans();



s0 = document.getElementsByTagName('h4');

function mod() {
    var t0 = this;

    setTimeout(function () {
        var v0 = "rgb("
        v0 += Math.floor(255 - (Math.random() * 106));
        v0 += ",";
        v0 += Math.floor(255 - (Math.random() * 106));
        v0 += ",";
        v0 += Math.floor(255 - (Math.random() * 106));
        v0 += ")";
        t0.style.backgroundColor = v0;
    }, 3000);
}

for (var t0 = 0; t0 < s0.length; t0++) {
    if (s0[t0].innerHTML == 'Welcome to the Intergalactic Directory.') {
        s0[t0].addEventListener('click', mod);
    }
}


x0 = document.getElementById('n1');

x1 = document.getElementById('n2');

var x2 = document.getElementById('operation');

x0.addEventListener('keyup', performOperation);
x1.addEventListener('keyup', performOperation);
x2.addEventListener('change', performOperation);


function performOperation() {

    var t1 = document.getElementById('n1').value;
    var t2 = document.getElementById('n2').value;

    if ((isNaN(t1) == false && isNaN(t2) == false)) {
        var t0 = document.getElementById('operation').selectedIndex;
        var v0;
        switch (t0) {
            case 0:
                v0 = (t1 * 1) + (t2 * 1);
                document.getElementById('result').innerHTML = v0;
                break;
            case 1:
                v0 = (t1 * 1) - (t2 * 1);
                document.getElementById('result').innerHTML = v0;
                break;
            case 2:
                v0 = (t1 * 1) / (t2 * 1);
                document.getElementById('result').innerHTML = v0;
                break;
            case 3:
                v0 = (t1 * 1) * (t2 * 1);
                document.getElementById('result').innerHTML = v0;
                break;
            default:
                document.getElementById('result').innerHTML = '';
                break;
        }
    }
    else {
        document.getElementById('result').innerHTML = 'INVALID INPUT';
    }


}


s0 = document.getElementsByTagName('div')[0];
function recurse(a0) {
    if (a0 == undefined) {
        return;
    }

    if (a0.tagName != undefined) {
        console.log(a0.tagName);
    }

    recurse(a0.firstElementChild);
    recurse(a0.nextSibling);

}

recurse(s0);



