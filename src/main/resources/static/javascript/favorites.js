//Just getting a base code in, need to update

//Cookie
const cookieArr = document.cookie.split("=")
const userId = cookieArr[1];

//DOM Elements
const submitForm = document.getElementById("note-form")  //Need to update the DOM Elements
const noteContainer = document.getElementById("note-container")

//Modal Elements
let noteBody = document.getElementById('note-body')  //Need to update these elements too
let updateNoteBtn = document.getElementById('update-note-button')

const headers = {
    'Content-Type': 'application/json'
}

const baseUrl = "http://localhost:8080/"
