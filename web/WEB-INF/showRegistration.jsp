<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="row">

    <div class="col-6 col-md-4"></div>
    <div class="col-6 col-md-4">
        <div class="loginWrap">
            <h1>Регистрация на Портале</h1>

            <p>${info}</p>

            <form action="registration" onsubmit="false" method="POST">
                <div class="form-group">
                    <div class="form-group">
                    <label for="nickname">Nickname:</label>
                    <input type="text" class="form-control" id="nickname" name="nickname" aria-describedby="Nickname" placeholder="Enter nickname" value="${nickname}">
                </div>
                <div class="form-group">
                    <label for="password1">Password: </label>
                    <input type="password" class="form-control" id="password" name="password1" aria-describedby="password1" placeholder="Enter password" value="${password1}">
                </div>
                <div class="form-group">
                    <label for="password2">Repeat password: </label>
                    <input type="password" class="form-control" id="password2" name="password2" aria-describedby="password2" placeholder="Repeat password" value="${password2}">
                </div>
                <hr>
                    <label for="firstname">Name:</label>
                    <input type="text" class="form-control" id="firstname" name="firstname" aria-describedby="Name" placeholder="Enter your name" value="${firstname}">
                </div>
                <div class="form-group">
                    <label for="lastname">Surname:</label>
                    <input type="text" class="form-control" id="lastname" name="lastname" aria-describedby="Name" placeholder="Enter your surname" value="${lastname}">
                </div>
                <div class="form-group">
                    <label for="login">Email:</label>
                    <input type="email" class="form-control" id="email" name="login" aria-describedby="email" placeholder="Enter your email(login)" value="${login}">
                </div>
                

                <button type="submit" id="enter" class="btn btn-primary">Зарегистрироваться</button>
            </form>
        </div>

    </div>
    <div class="col-6 col-md-4"></div>
</div>
<hr>
<a href="index">Назад</a>