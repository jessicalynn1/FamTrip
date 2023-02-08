//Cookie
const cookieArr = document.cookie.split("=")
const userId = cookieArr[1];

let businessList = JSON.parse(sessionStorage.getItem("yelpResult"))
const businessContainer = document.getElementById("trip-details-container")
let favoritesForm = document.getElementById("favorites-form")

const header = {
    'Content-Type':'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/users'

const populateBusinessList = (list) => {
    businessContainer.innerHTML = ''

    list.forEach((obj, index) => {
       let row = document.createElement("div")
       row.classList.add("m-4")
       row.innerHTML = `
       <div id="trip-details">
       <p class="text"> Name: ${obj.name} <br>
        Address: ${obj.address} <br>
        Phone number: ${obj.displayPhone} <br>
        Category: ${obj.categories} <br>
        <a href="${obj.website}"> Website </a>
        <br>
        </p>

       <br>
       <input type="checkbox" id="favorites-form-${index}" name="option">
       <label for="option" id="option-label">
       </label> <br>
       </div>
       `

       businessContainer.append(row);
    }
    )
}

populateBusinessList(businessList)

const handleSubmit = async (e) => {
    e.preventDefault()

    let selectedFavorites = []
    let elements = document.querySelectorAll("input[type=checkbox]:checked")
    elements.forEach(element => {
        let num = element.id.split("-")[2]
        let numInt = parseInt(num)
        selectedFavorites.push(businessList[numInt])
        }
    )

    const response = await fetch(`${baseUrl}/favorites/addFavorites`, {
        method: "POST",
        body: JSON.stringify(selectedFavorites),
        headers: header
    })
        .catch(err => console.error(err.message))


    if (response.status === 200) {
        window.location.replace("http://localhost:8080/favorites.html")
    }
}

favoritesForm.addEventListener("submit", handleSubmit)

function handleLogout(){
    let c = document.cookie.split(";");
    for(let i in c){
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }
}