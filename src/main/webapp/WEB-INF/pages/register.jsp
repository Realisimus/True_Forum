<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
    <head>
        <title>Register new user</title>
    </head>
    <body>
        <h2>Register new user</h2><br>
        <a href="/forum">Return to forum</a>
        <h3>${message}</h3>
        <form:form method="post" action="register">
            <p>User name<br>
            <input type="text" name="login" size="25" />
            <p>Password<br>
            <input type="password" name="password" size="25" /><br>
            <input type="password" name="password2" size="25" /><br>
            <input type="submit" value="Register"/>
        </form:form>
    </body>
</html>