'use strict';
window.addEventListener('load', function () {

    const user = fetch("http://localhost:8080/demo/getUser");
    console.log(user);

    const saveButton = document.getElementById("save-candidate");
    saveButton.addEventListener("click", function() {
        const candidateForm = document.getElementById("form");
        let data = new FormData(candidateForm);

        fetch("http://localhost:8080/post", {
            method: 'POST',
            body: data
        }).then(r => r.json()).then(data => {window.location.href = "http://localhost:8080/"});
    });

});
// HW59 task1
function toggleHurt(){
    document.getElementById('heart').classList.toggle("redColor");
}

// task2
const doubleClick = document.querySelector("img");
doubleClick.ondblclick=function(){
    console.log("here double click");
    toggleHurt();
}

// task3
function togglePost(){
    document.getElementById('publ').classList.toggle("mark");

}
//
function showForm() {
    document.getElementById("comm").hidden = false;
    document.getElementById("link").hidden = true;
}

function toggleComment(){
    document.getElementById('cmn').classList.toggle(showForm());

}
//task 2
function createCommentElement(comment){
    comment=document.querySelector('[name=text]').value;
    let elem= document.createElement('p')
    let name= document.createElement('href')
    elem.innerHTML=comment;
    name.innerHTML="Someone newUser";
    name.style.fontWeight='bold';
    document.getElementsByTagName('div')[0].append(name, elem);

}
