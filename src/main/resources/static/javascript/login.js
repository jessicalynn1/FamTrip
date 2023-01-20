//Cookie
const cookieArr = document.cookie.split("=")
const userId = cookieArr[1];

let loginForm = document.getElementById('login-form')
let loginUsername = document.getElementById('login-username')
let loginPassword = document.getElementById('login-password')

const header = {
    'Content-Type':'application/json'
}

const baseUrl = "http://localhost:8080/api/v1/users"

const handleSubmit = async (e) => {
    e.preventDefault()

    let bodyObj = {
        userName: loginUsername.value,
        password: loginPassword.value
    }

    const response = await fetch(`${baseUrl}/login`, {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: header
    })
        .catch(err => console.error(err.message))

    const responseArr = await response.json()

    if (response.status === 200) {
        document.cookie = `userId=${responseArr[1]}`
        window.location.replace(responseArr[0])
    }
}

//function handleLogout(){
//    let c = document.cookie.split(";");
//    for(let i in c){
//        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
//    }
//}

loginForm.addEventListener("submit", handleSubmit)