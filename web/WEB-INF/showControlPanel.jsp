
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Админ-панель</title>
    </head>
    <body>
        <h1>Админ-панель</h1>
        
        <div>
            <p>Изменение роли пользователя</p>
            
            <p>${info}</p>
        
        <form action="changeUserRole" method="POST">
            Список пользователей: 
            <select name="userId">
                <option value="" hidden></option>
                <c:forEach var="entry" items="${mapUsers}">
                    <option value="${entry.key.id}">
                        ${entry.key.login} с ролью ${entry.value}
                    </option>
                </c:forEach>
            </select>
            <span>  </span>
            Список ролей: 
            <select name="roleId">
                <option value="" hidden></option>
                <c:forEach var="role" items="${listRoles}">
                    <option value="${role.id}">${role.role}</option>
                </c:forEach>
            </select>
            <br>
            <input type="submit" value="Изменить">
        </form>
        
            
        </div>
        
        
        
        
    </body>
</html>
