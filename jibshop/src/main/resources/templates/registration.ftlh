<!DOCTYPE html>
<html>
<head>
    <title>Twilight</title>
</head>
<body>
<h1>Twilight</h1><hr>
<h4>Registration</h4>
<form action="/registration" method="post">
    Usernamr: <input type="text" name="name"><br><br>
    Email: <input type="email" name="email"><br><br>
    Number phone: <input type="text" name="numberPhone"><br><br>
    Password: <input type="password" name="password"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Вход"/>
</form>

</body>
</html>