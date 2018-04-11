$('#add').on('click', function(){
   var text = $('#newItem').val();

   if(text != ''){
       var temp = document.createElement('li');
       temp.innerHTML = text;
       $('#toBuy').append(temp);
       $('newItem').val('');
   }
});
$('#toBuy').on('click', 'li', function () {
    $('#bought').append(this);
});

$('#bought').on('click', 'li', function(){
   $('#toBuy').append(this);
});

$('#toBuy').on('click','li',function () {

});