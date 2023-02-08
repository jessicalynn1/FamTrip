//Cookie
const cookieArr = document.cookie.split("=")
const userId = cookieArr[1];

//need to validate is user has favorites

function handleLogout(){
    let c = document.cookie.split(";");
    for(let i in c){
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }
}