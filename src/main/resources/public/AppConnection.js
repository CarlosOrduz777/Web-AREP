function loadGetMsg() {
                let nameVar = document.getElementById("name").value;
                const xhttp = new XMLHttpRequest();
                xhttp.onload = function() {
                    document.getElementById("getrespmsg").innerHTML =
                    this.responseText;
                }
                xhttp.open("GET", "/hello?name="+nameVar);
                xhttp.send();
            }

function buttonsInvisible(){
    var buttons = document.getElementById('date-buttons');
    buttons.style.visibility = 'hidden';

}
buttonsInvisible();

function buttonsVisible(){
    var buttons = document.getElementById('date-buttons');
        buttons.style.visibility = 'visible';
}
function loadRequest(){
    let symbol = document.getElementById("symbol").value;
            var path = "/find?symbol="+symbol;
            const xhttp = new XMLHttpRequest();
            xhttp.onload = function(){
                if(xhttp.status === 200){
                    buttonsVisible();
                }else{
                    buttonsInvisible();
                }
                document.getElementById("getrespmsg").innerHTML = this.responseText;
            }
            xhttp.open("GET",path);
            xhttp.send();

}
function loadPolyonRequest(){
    let symbol = document.getElementById("symbol").value;
                var path = "/search?symbol="+symbol;
                const xhttp = new XMLHttpRequest();
                xhttp.onload = function(){
                    document.getElementById("getrespmsg").innerHTML = this.responseText;
                }
                xhttp.open("GET",path);
                xhttp.send();

}
     function loadRequestWithDate(date){
        let symbol = document.getElementById("symbol").value;
        var path = "/find?symbol="+symbol+"&date="+date;
        const xhttp = new XMLHttpRequest();
        xhttp.onload = function(){
            if(xhttp.status === 200){
            }
            document.getElementById("getrespmsg").innerHTML = this.responseText;
        }
        xhttp.open("GET",path);
        xhttp.send();
     }






