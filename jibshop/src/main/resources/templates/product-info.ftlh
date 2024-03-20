<!DOCTYPE html>
<html>
<head>
    <title>Twilight</title>
</head>
<body>
<h1>Twilight</h1><hr>
<h4>More about product</h4>
<#list images as img>
    <img src="/images/${img.id}" height="90px" width="90px"/><br><br>
</#list>

<b>Title: </b>${product.title}<br>
<b>desc: </b>${product.description}<br>
<b>Price: </b>${product.price}<br>
<hr>
<form action="/product/delete/${product.id}" method="post">
    <input type="submit" value="Delete product"/>
</form>
</body>
</html>