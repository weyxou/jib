<!DOCTYPE html>
<html>
<head>
    <title>Twilight</title>
    <meta name="_csrf" content="<Your_CSRF_Token_Here>">
</head>
<body>
<h1>Twilight</h1><hr>
<h4>Registration</h4>

<!-- Добавлено место для отображения ошибки -->
<div id="errorMessage" style="color: red"></div>

<form id="registrationForm" action="/registration" method="post">
    Username: <input type="text" name="name"><br><br>
    Email: <input type="email" name="email"><br><br>
    Number phone: <input type="text" name="numberPhone"><br><br>
    Password: <input type="password" name="password"><br><br>
    <input type="hidden" name="_csrf" id="csrfToken">
    <input type="submit" value="Вход"/>
</form>

<script>
    // Функция для проверки ошибок и отображения сообщения
    function displayError(message) {
        var errorMessage = document.getElementById('errorMessage');
        errorMessage.textContent = message;
    }

    // Функция для получения CSRF токена из метатега
    function getCsrfToken() {
        return document.querySelector('meta[name="_csrf"]').getAttribute('content');
    }

    // Установка CSRF токена в скрытое поле формы
    document.getElementById('csrfToken').value = getCsrfToken();
</script>

</body>
</html>
