<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
    <head>
        <title>True Forum</title>
    </head>
    <body>
        <a href="/">Forum</a><br>

        <form method="post" action="searchPosts">
            <input type="text" name="search" size="50" />
            <input type="submit" value="Search"/><br>
        </form>
        <form method="get" action="addPost">
             <input type="hidden" name="topicName" value="${posts[0].topicName}" />
             <input type="submit" value="Add post"/><br>
        </form>
        <form method="post" action="editTopicName">
                <input type="text" name="topicName" value="${posts[0].topicName}" />
                <input type="hidden" name="oldTopicName" value="${posts[0].topicName}" />
                <input type="submit" value="Change name of topic"/><br>
        </form>
        <c:forEach var="post" items="${posts}">
            <form method="post" action="editPost"><br>
                <input type="hidden" name="topicName" value="${post.topicName}" />
                <input type="hidden" name="id" value="${post.id}" />
                <textarea name="text" cols="32" rows="3" >${post.text}</textarea><br>
                <h6>Created ${post.createdDate}</h6>
                <h6>Modified ${post.modifiedDate}</h6>
                <input type="submit" name="button" value="Save post"/>
                <input type="submit" name="button" value="Delete post"/><br>
            </form>
            ------------------------------------------------------------------------------------------------------------------
        </c:forEach>
    </body>
</html>
