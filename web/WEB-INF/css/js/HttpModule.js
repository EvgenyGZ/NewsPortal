"use strict";



function get(url,data){
let response = fetch(url, {
method: 'POST',
headers: {
'Content-Type': 'application/json;charset=utf-8'
},
body: JSON.stringify(data)
});
response.then(status)
.then(json)
.catch(function(error){
console.log('Request failed', error);
});


}
function status(response) {
if (response.status >= 200 && response.status < 300) {
return Promise.resolve(response)
} else {
return Promise.reject(new Error(response.statusText))
}
}


function json(response){
return response.json();
}

