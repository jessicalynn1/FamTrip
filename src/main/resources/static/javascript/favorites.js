//Cookie
const cookieArr = document.cookie.split("=")
const userId = cookieArr[1];

const favoritesBody = document.getElementById("favorites-container")
let favoritesForm = document.getElementById("favorites-list-form")
sessionStorage.setItem("userId", userId)
//const database = new Datastore('favorites.db');
//database.loadDatabase();
let favoritesList = getAllFavoritesByUserId(userId)
console.log(favoritesList)

const headers = {
    'Content-Type': 'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/users'

/*
If user has no favorites print, "You have no saved favorites"
*/


    const populateFavoritesList = (list) => {
        favoritesBody.innerHTML = ''
//        String tempUser = sessionStorage(userId)

        list.forEach(obj => {
            let row = document.createElement("div")
            row.classList.add("m-4")
            row.innerHTML = `
            <div id="favorites-list">
            <p class="text">
            <br>
            </p>
            </div>
            `
        favoritesBody.append(row);
        }
        )
    }

populateFavoritesList(favoritesList)


function handleLogout(){
    let c = document.cookie.split(";");
    for(let i in c){
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }
}

//
//const handleSubmit = async (e) => {
//    e.preventDefault()
//
//    let bodyObj = {
//        business: businessList.value,
//    }
//
//    const response = await fetch(`${baseUrl}/favorites/addFavorites`, {
//        method: "POST",
//        body: JSON.stringify(bodyObj),
//        headers: header
//    })
//        .catch(err => console.error(err.message))

//    const responseArr = await response.json()
//
//    if (response.status === 200) {
//        document.cookie = `userId=${responseArr[1]}`
//        window.location.replace("http://localhost:8080/favoritesdetail.html")
//    }
//}