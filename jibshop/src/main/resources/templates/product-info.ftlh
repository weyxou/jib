<!DOCTYPE html>
<html>
<head>
    <title>Twilight</title>
</head>
<body>
<h1>Twilight</h1><hr>
<h4>More information</h4>
<#list images as img>
    <img src="/images/${img.id}" height="60px"/><br><br>
</#list>
<b>Title: </b>${product.title}<br>
<b>Desc: </b>${product.description}<br>
<b>Price: </b>${product.price}<br>

<hr>
<form action="/product/delete/${product.id}" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Delete"/>
</form>
</body>
</html>