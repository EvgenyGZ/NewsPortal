<%-- 
    Document   : showProfile
    Created on : Jan 27, 2020, 10:27:11 AM
    Author     : pupil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
        <body>

    
      
        <div class="d-flex justify-content-center"><h1>Профиль пользователя ${user.login}</h1></div>
        
       
      <div class="d-flex justify-content-center row profileWrap">
        <form action="changePerson" method="POST">
          <div class="form-group">
            <label for="name">Имя читателя</label>
            <input type="text" class="form-control"  value="${user.person.firstName}" name="name" id="name" placeholder="Имя пользователя">
          </div>
          <div class="form-group">
            <label for="lastname">Фамилия читателя</label>
            <input type="text" class="form-control" name="lastname" value="${user.person.lastName}" id="lastname" placeholder="Фамилия пользователя">
          </div>
          
          <div class="form-group">
            <label for="login">Логин</label>
            <input type="text" class="form-control" id="login" name="login" aria-describedby="emailHelp" placeholder="Enter email">
          </div>
          <div class="form-group">
            <label for="password1">Пароль</label>
            <input type="password" class="form-control" id="password1" name="password1" placeholder="Password">
          </div>  
          <div class="form-group">
            <label for="password2">Повторить пароль</label>
            <input type="password" class="form-control" id="password2" name="password2" placeholder="Password repeat">
          </div>  
          <button type="submit" class="btn btn-primary">Внести изменения</button>
        <br>
          <br>
        </form>
          
      </div> 
         
    </body>
</html>
