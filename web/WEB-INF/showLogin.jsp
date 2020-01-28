<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="d-flex justify-content-center"><h1>Вход в систему</h1></div>


<!--<div class="row">-->
  <div class="d-flex justify-content-center row profileWrap">
    <!--<h1>Вход в систему</h1>-->
    <form action="login" onsubmit="false" method="POST">
      <div class="form-group">
        <label for="login">Логин:</label>
        <input type="text" class="form-control" id="login" name="login" aria-describedby="emailHelp" placeholder="Enter email">
      </div>
      <div class="form-group">
        <label for="password">Password</label>
        <input type="password" class="form-control" id="password" name="password" placeholder="Password">
      </div>
        <div class="d-flex justify-content-center row profileWrap">
        <button type="submit" id="enter" class="btn btn-primary">Войти</button>
        </div>
    </form>
    </div>
<br>
    <div class="d-flex justify-content-center">
        <h4>У вас нет логина?</h4>
        </div>
     
        <div class="d-flex justify-content-center">
        <h4> <a href="showRegistration">Зарегистрируйтесь</a></h4>
    </div>
     <hr>
    <div class="d-flex justify-content-center"> <a href="index">Вернуться назад</a>
    <br></div>
  
 
    
    
    
   
   
  </div>
<!--</div>-->
