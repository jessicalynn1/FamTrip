let tripForm = document.getElementById('trip-form')
let tripName = document.getElementById('trip-name')
let city = document.getElementById('city')
let children = document.getElementById('children')

const header = {
    'Content-Type':'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/users'

const handleSubmit = async (e) => {
    e.preventDefault()

   let types = document.getElementsByName('type')
   let type = null;
   for (i = 0; i <types.length; i++) {
        if(types[i].checked) {
            type = types[i].value
            console.log(type)
        }
   }

    let bodyObj = {
        tripName: tripName.value,
        city: city.value,
        children: children.value,
        type: type
    }

        const response = await fetch(`${baseUrl}/tripdetails/yelpcall`, {
            method: "POST",
            body: JSON.stringify(bodyObj),
            headers: header
        })

        .catch(err => console.error(err.message))

    const responseArr = await response.json()

    if (response.status === 200) {
        window.location.replace(responseArr[0])
    }
    }


tripForm.addEventListener("submit", handleSubmit)