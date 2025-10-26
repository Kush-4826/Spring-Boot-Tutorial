<%@page language="java" %>

<html>
<head>
    <link rel="stylesheet" href="./views/style.css">
</head>
<body>
    <h1>Hello, World..!</h1>

    <form action="addAlien">
        <label for="id">ID: </label><br>
        <input type="text" id="id" name="id"><br>
        <label for="name">Name: </label>
        <input type="text" id="name" name="name"><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>