//let tripOptions = document.getElementById(option)
let businessList = JSON.parse(sessionStorage.getItem("yelpResult"))
const businessContainer = document.getElementById("trip-details-container")

const header = {
    'Content-Type':'application/json'
}

console.log(businessList)

const baseUrl = 'http://localhost:8080/api/v1/users'
const populateBusinessList = (list) => {
    businessContainer.innerHTML = ''
    list.forEach(obj => {
       let row = document.createElement("div")
       row.classList.add("m-4")
       row.innerHTML = `
       <div id="trip-details">
       <p class="text"> Name: ${obj.name} <br>
        Category: ${obj.categories} <br>
        Website: ${obj.website} <br>
        Address: ${obj.address} <br>
        Phone number: ${obj.displayPhone} <br>
        </p>

                   <br>
                   <input type="checkbox" id="option" name="option">
                   <label for="option" id="option-label">
                   </label> <br>
           </div>
       `
       businessContainer.append(row);
    }
    )
}

populateBusinessList(businessList)

//for (i = 0; i < businessList.length; i++) {
//
//
//    if(tripOptions[i].checked) {
//        option = tripOptions[i].value
//    }
//}








// this is where you would validate if the user is logged in or not
//function handleLogout(){
//    let c = document.cookie.split(";");
//    for(let i in c){
//        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
//    }
//}