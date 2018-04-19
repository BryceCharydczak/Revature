interface Point{
    x: number,
    y: number
}


var drawPoint_1 = function(x,y){

};

var drawPoint_2 = function(point){
    console.log(`x: ${point.x}, y: ${point.y}`)
};

drawPoint_2({
    x:1,
    y:2
});

var drawPoint_3 = function(point:Point){
    console.log(`x: ${point.x}, y: ${point.y}`)
};

drawPoint_3({
   x:5,
   y:6
});

class Point{
    
}