//Cookie
const cookieArr = document.cookie.split("=")
const userId = cookieArr[1];

let tripForm = document.getElementById('trip-form')
let tripName = document.getElementById('trip-name')
let city = document.getElementById('city')
let children = document.getElementById('children')
sessionStorage.setItem("userId", userId)
const noUser = document.getElementById("no-user")
const formContainer = document.getElementById("form-container")
//const formContainer2 = document.getElementById("column2")

const header = {
    'Content-Type':'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/users'

async function getUser(userId) {
    console.log("User id inside function: " + userId)
    if (userId) {
        formContainer.style.display = 'inline'
        noUser.style.display = 'none'
    } else {
        noUser.style.display = 'inline'
        formContainer.style.display = 'none'
    }
}

const handleSubmit = async (e) => {
    e.preventDefault()

   let types = document.getElementsByName('type')
   let type = null;
   for (i = 0; i <types.length; i++) {
        if(types[i].checked) {
            type = types[i].value
        }
   }

    let bodyObj = {
        tripName: tripName.value,
        city: city.value,
        children: children.value,
        type: type,
        userId: userId
    }

        const response = await fetch(`${baseUrl}/tripdetails/yelpcall`, {
            method: "POST",
            body: JSON.stringify(bodyObj),
            headers: header
        })

        .catch(err => console.error(err.message))

    const responseArr = await response.json()

    if (response.status === 200) {
        sessionStorage.setItem("yelpResult", JSON.stringify(responseArr))
        window.location.replace("http://localhost:8080/tripdetails.html")
    }
}

tripForm.addEventListener("submit", handleSubmit)

function handleLogout(){
    let c = document.cookie.split(";");
    for(let i in c){
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }
}

getUser(userId)