//Cookie
const cookieArr = document.cookie.split("=")
const userId = cookieArr[1];

const homeContainer = document.getElementById("home-container")
const noUser = document.getElementById("no-user")

async function getUser(userId) {
    console.log("User id inside function: " + userId)
    if (userId) {
        homeContainer.style.display = 'inline'
        noUser.style.display = 'none'
    } else {
        noUser.style.display = 'inline'
        homeContainer.style.display = 'none'
    }
}

function handleLogout(){
    let c = document.cookie.split(";");
    for(let i in c){
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }
}

getUser(userId)