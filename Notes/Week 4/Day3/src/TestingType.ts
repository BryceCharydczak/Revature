function log(message){
    console.log(message);
}

var message = `Hello, world`;

log(message);



function doSomething(){
    let message;
    message = 'abc';
    let endsWithC = (<string> message).endsWith('c');
    let endsWithD = (message as string).endsWith('d');
}