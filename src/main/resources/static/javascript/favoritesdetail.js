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

function handleLogout(){
    let c = document.cookie.split(";");
    for(let i in c){
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }
}
