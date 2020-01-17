"use strict";

import{status,json,get} from "./HttpModule.js";

document.getElementById("enter").onclick=function(){
let login = document.getElementById("login").value;
let password = document.getElementById("password").value;
let url = 'rest/loginControllerREST/loginRest';
let token = localStorage.getItem('token');
let data = [token,login,password];

let response = get(url,data);
response.then(status)
.then(json)
.catch(function(error) {

console.log('Request succeeded with JSON response', error);

})
.then(function(res) {
console.log('Request succeeded', res.token);
localStorage.setItem('token',res.token);
});



};