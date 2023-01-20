let tripOptions = document.getElementById(option)

const header = {
    'Content-Type':'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/users'

for (i = 0; i < tripOptions.length; i++) {
    if(tripOptions[i].checked) {
        option = tripOptions[i].value
    }
}









// this is where you would validate if the user is logged in or not
//function handleLogout(){
//    let c = document.cookie.split(";");
//    for(let i in c){
//        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
//    }
//}