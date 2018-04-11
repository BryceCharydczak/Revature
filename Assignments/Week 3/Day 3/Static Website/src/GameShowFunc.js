
var students = ['Alex Pich',
    'Dimitrei Nazi',
    'Angelique Elkins',
    'Bryce Charydczak',
    'Byron Hall',
    'Pedro De los Reyes',
    'Quinn Wong',
    'William Strauss',
    'Philip Escobedo',
    'Dennis Park',
    'Noah Dering',
    'Myles Casanas',
    'Brandon Semba',
    'Zachary Vaughn',
    'Danny Chhun',
    'Karl Cavanaugh',
    'Joanel Vasquez',
    'Richard Vo',
    'Alexia Doramus',
    'Antonio Marrero Bonilla',
    'Joseph Edward Gonzales',
    'Cameryn Holstick',
    'Michael Ade'];

function shuffleNames() {
    var selectedStudent;
   for (var i = 0; i < students.length; i++){
       selectedStudent = Math.floor(Math.random()*students.length);

       var tempstu = students[selectedStudent];
       var currSru = students[i];
       students[i] = tempstu;
       students[selectedStudent] = currSru;

   }
   console.log(students);
}


$('#addQuestion').live('onload', addQuestion);

function addRecords(){
    shuffleNames();
    for (var i = 0; i < students.length; i++){

    }
}