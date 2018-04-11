window.onload = function(){
    var quizDiv = document.createElement('div');

    //dynamically create HTML elements
    $('body').prepend('<div id="quiz"></div>');
    $('body').append('<button id="Submit"></button>').setAttribute('id','submit');


    buildQuiz();

    submitButton.addEventListener('click', showResults);


}


var quizContainer = document.getElementById('quiz');
var resultsContainer = document.getElementById('results');
var submitButton = document.getElementById('submit');

function buildQuiz(){

    var output = [];

    myQuestions.forEach((currentQuestion, questionNumber) => {
    var answers =[];
    for (letter in currentQuestion.answers){
    answers.push(`
    <label>
    <input type="radio" name="question${questionNumber}" value="${letter}">
    ${letter} : ${currentQuestion.answers[letter]};
</label>`);
}
output.push('<div class="question">${currentQuestion.question}</div>
    <div class="answers">${answers.join('')
);
});



}

const myQuestions = [
    {
    question: '7 + 7 + "7" = ?',
    answers:{
    a: '"777"',
        b: '"147"',
        c: 21
}, correctAnswer: 'b'
]