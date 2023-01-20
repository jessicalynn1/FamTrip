//Cookie
const cookieArr = document.cookie.split("=")
const userId = cookieArr[1];

let registerForm = document.getElementById('register-form')
let registerUsername = document.getElementById('register-username')
let registerPassword = document.getElementById('register-password')

const header = {
    'Content-Type':'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/users'

const handleSubmit = async (e) => {
    e.preventDefault()

    let bodyObj = {
        userName: registerUsername.value,
        password: registerPassword.value
    }

    const response = await fetch(`${baseUrl}/register`, {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: header
    })
        .catch(err => console.error(err.message))

    const responseArr = await response.json()

    if (response.status === 200) {
        window.location.replace(responseArr[0])
    }
}

registerForm.addEventListener("submit", handleSubmit)