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
            <p>Login<br>
            <input type="text" name="login" value="${login}" size="50" /><br>
            <p>Password<br>
            <input type="password" name="password" value="${password}" size="50" /><br>
            <input type="submit" name="submit" value="Login"/><br>
        </form>
    </body>
</html>
