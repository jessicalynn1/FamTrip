//Cookie
const cookieArr = document.cookie.split("=")
const userId = cookieArr[1];

const favoritesBody = document.getElementById("favorites-container")
sessionStorage.setItem("userId", userId)
const hideFaves = document.getElementById("trip-name")
const noFaves = document.getElementById("no-faves")

const headers = {
    'Content-Type': 'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/users'

/* If user has no favorites print, "You have no saved favorites" */


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
    } else {
        noFaves.style.display = 'inline'
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
            Trip Name: ${obj.tripDetailsDto.tripName}
            <br>
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


getFavorites(userId)

function handleLogout(){
    let c = document.cookie.split(";");
    for(let i in c){
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }
}
