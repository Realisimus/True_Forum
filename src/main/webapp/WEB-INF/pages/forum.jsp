<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
    <head>
        <title>True Forum</title>
    </head>
    <body>
        <a href="/logout">${user} logout</a><br><br>
        <a href="/addTopic">Add new Topic</a><br>
        <a href="/register">Add new User</a><br>

        <form method="post" action="searchPosts">
            <input type="text" name="search" size="50" />
            <input type="submit" value="Search"/><br>
        </form>

        <c:forEach var="topic" items="${topics}">
            <form method="post" action="viewTopic"><br>
                <input type="hidden" name="topic" value="${topic}" />
                <h3>${topic}</h3>
                <input type="submit" value="View"/>
            </form>
            ------------------------------------------------------------------------------------------------------------------
        </c:forEach>
    </body>
</html>
