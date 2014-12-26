<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
    <head>
        <title>Adding new post</title>
    </head>
    <body>
        <h2>Adding new post</h2><br>
        <a href="/">Return to forum</a>
        <form:form method="post" action="addPost">
            <p>Title<br>
            <input type="text" name="topicName" value="${post.topicName}" size="25" readonly/>
            <p>Text<br>
            <textarea name="text" cols="32" rows="4" >${post.text}</textarea><br>
            <input type="submit" value="Add post"/>
            <input type="reset" value="Cancel"/>
        </form:form>
    </body>
</html>