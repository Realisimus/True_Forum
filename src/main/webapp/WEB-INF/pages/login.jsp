<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
    <head>
        <title>True Forum</title>
    </head>
    <body>
        <a href="/register">Add new User</a><br>
        <h3>${message}</h3>
        <form method="post" action="login">
            <input type="text" name="login" value="${login}" size="50" /><br>
            <input type="password" name="password" value="${password}" size="50" /><br>
            <input type="submit" value="Login"/><br>
        </form>
    </body>
</html>
