//Cookie
const cookieArr = document.cookie.split("=")
const userId = cookieArr[1];

const favoritesBody = document.getElementById("favorites-container")
sessionStorage.setItem("userId", userId)
//need to figure out how to get favoritesId to pass into getfavorites function

const headers = {
    'Content-Type': 'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/users'

/* If user has no favorites print, "You have no saved favorites" */

async function getFavorites(userId) {
    await fetch('${baseUrl}favorites/${favoritesId}', {
        method: "GET",
        headers: headers
    })
        .then(response => response.json())
        .then(data => populateFavoritesList(data))
        .catch(err => console.error(err))
}

const populateFavoritesList = (list) => {
    favoritesBody.innerHTML = ''

    console.log(list)
    list.forEach(obj => {
        let row = document.createElement("div")
        row.classList.add("m-4")
        row.innerHTML = `
        <div id="favorites-container">
        <p class="text">
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
