<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
    <head>
        <title>Adding new topic</title>
    </head>
    <body>
        <h2>Adding new topic</h2><br>
        <a href="/">Return to forum</a>
        <form:form method="post" action="addTopic">
            <p>Title<br>
            <input type="text" name="topicName" value="${post.topicName}" size="25" />
            <p>Text<br>
            <textarea name="text" cols="32" rows="4" >${post.text}</textarea><br>
            <input type="submit" value="Add topic"/>
            <input type="reset" value="Cancel"/>
        </form:form>
    </body>
</html>