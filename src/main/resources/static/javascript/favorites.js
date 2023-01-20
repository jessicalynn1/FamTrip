//const cookieArr = document.cookie.split("=")
//const userId = cookieArr[1];

const favoritesBody = document.getElementById("favorites-body")

const headers = {
    'Content-Type': 'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/users'

/*
If user has no favorites print, "You have no saved favorites"
*/

//Don't need an event listener just display all favorites


//const handleSubmit = async (e) => {
//    e.preventDefault()
//
//       let favoritesList = document.getElementsByName("favorites-body")
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
//        }
//
//.addEventListener("submit", handleSubmit)
//no submit button so how do i get this to run?
