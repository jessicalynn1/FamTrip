//Cookie
const cookieArr = document.cookie.split("=")
const userId = cookieArr[1];

const favoritesBody = document.getElementById("favorites-container")
const database = new Datastore('favorites.db');
database.loadDatabase();

const headers = {
    'Content-Type': 'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/users'

/*
If user has no favorites print, "You have no saved favorites"
*/

app.post('/getData', (request, response) => {
    const data = request.body;
    response.json(data);
}
)

//getData();
//const response = await fetch('/api');
//const data = await response.json();

//async function getData() {
//    const response = await fetch('/api');
//    const data = await response.json();
//}

    const populateFavoritesList = (list) => {
        data.innerHTML = ''

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
//}
const handleSubmit = async (e) => {
    e.preventDefault()

    let bodyObj = {
        business: businessList.value,
    }

    const response = await fetch(`${baseUrl}/favorites/addFavorites`, {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: header
    })
        .catch(err => console.error(err.message))

    const responseArr = await response.json()

    if (response.status === 200) {
        document.cookie = `userId=${responseArr[1]}`
        window.location.replace("http://localhost:8080/favoritesdetail.html")
    }
}

favoritesForm.addEventListener("submit", handleSubmit)


function handleLogout(){
    let c = document.cookie.split(";");
    for(let i in c){
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }
}

//
//
//       let favoritesList = document.getElementsByName("favorites-container")
//        for (i = 0; i < favoritesList.length; i++) {
//            System.out.println(favoritesList[i].value)
//        }
//
//    let bodyObj = {
//            favoriteList: favorites-body
//        }
//
//    const response = await fetch(`${baseUrl}/favorites`, {
//                method: "GET",
//                body: JSON.stringify(bodyObj),
//                headers: header
//            })
//
//            .catch(err => console.error(err.message))
//
//        const responseArr = await response.json()
//
//        if (response.status === 200) {
//            window.location.replace(responseArr[0])
//        }

