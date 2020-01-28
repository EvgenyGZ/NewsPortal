
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Админ-панель</title>
    </head>
    <body>
        <h1>Админ-панель</h1>
        <hr>
        <div>
            <p><h3>Изменение роли пользователя</h3></p>
        <p>${info}</p>
        <form action="changeUserRole" method="POST">
            <div class="row" style="max-width: 60%">
                <h5>Список пользователей:</h5>
                <select name="userId">
                    <option value="" hidden></option>
                    <c:forEach var="entry" items="${mapUsers}">
                        <option value="${entry.key.id}">
                            ${entry.key.login} с ролью ${entry.value}
                        </option>
                    </c:forEach>
                </select>
                <h5>Список ролей: </h5>
                <select name="roleId">
                    <option value="" hidden></option>
                    <c:forEach var="role" items="${listRoles}">
                        <option value="${role.id}">${role.role}</option>
                    </c:forEach>
                </select>
            </div>
            <br>
            <div class="form-col" >
                <input type="submit" value="Изменить">
            </div>
        </form>
    </div>
    <hr>
    <div>
        <p><h3>Добавление категорий новостей</h3></p>
    <div class="row" style="max-width: 60%">
        <h5>Список категорий:</h5>
        <select name="categoryId">
            <option value="" hidden></option>
            <c:forEach var="category" items="${listCategory}">
                <option value="${category.id}">
                    ${category.category}
                </option>
                   </c:forEach>
                
        </select>
        <c:forEach var="category" items="${listCategory}">
                    ${category.category}
               
            </c:forEach>
       
    </div>      
    <form action="addCategory" method="POST">
        <div class="form-col  ">
            <label for="Category">Название новой категории:</label>
            <input type="text" name="Category" value="${Category}" placeholder="название">
            <br>
        </div>   
        <br>
        <div class="form-col">
            <input type="submit" value="Добавить новую категорию">
        </div>
        </form>
    <hr>
    
    
    
    
    
    
    
    
</div>



</body>
</html>
