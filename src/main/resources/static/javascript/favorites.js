//Cookie
const cookieArr = document.cookie.split("=")
const userId = cookieArr[1];

const favoritesBody = document.getElementById("favorites-container")
sessionStorage.setItem("userId", userId)
const hideFaves = document.getElementById("trip-name")
const noFaves = document.getElementById("no-faves")
const noUser = document.getElementById("no-user")


const headers = {
    'Content-Type': 'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/users'

async function getUser(userId) {
    console.log("User id inside function: " + userId)
    if (userId) {
        noFaves.style.display = 'inline'
        noUser.style.display = 'none'
    } else {
        noUser.style.display = 'inline'
        noFaves.style.display = 'inline'
        hideFaves.style.display = 'none'
    }
}

async function getFavorites(userId) {
    await fetch(`${baseUrl}/favorites/${userId}`, {
        method: "GET",
        headers: headers
    })
        .then(response => response.json())
        .then(data => populateFavoritesList(data))
        .catch(err => console.error(err))
}


const populateFavoritesList = (list) => {

    if (list.length != 0) {
        hideFaves.style.display = 'inline'
        noFaves.style.display = 'none'
    } else {
        noFaves.style.display = 'inline'
        hideFaves.style.display = 'none'
    }

    favoritesBody.innerHTML = ''
    console.log(list)
    let tripName = ""

    list.forEach(obj => {

        if (obj.tripDetailsDto.tripName != tripName) {
            let titleRow = document.createElement("div")
            titleRow.classList.add("m-4")
            titleRow.innerHTML = `
            <div id="trip-name">
            <h3> Trip Name: ${obj.tripDetailsDto.tripName} </h3>
            </div>
            `
            favoritesBody.append(titleRow)
            tripName = obj.tripDetailsDto.tripName
        }

        let row = document.createElement("div")
        row.classList.add("m-4")
        row.innerHTML = `

        <div id="favorites-container">
        <p class="text">
        Name: ${obj.name} <br>
        Address: ${obj.address} <br>
        <a href="${obj.displayPhone}"> Phone number </a> <br>
        <a href="${obj.website}"> Website </a> <br>
        <br>
        </p>
        </div>
        `
    favoritesBody.append(row);
    }
    )
}

function handleLogout(){
    let c = document.cookie.split(";");
    for(let i in c){
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }
}

getFavorites(userId)
getUser(userId)