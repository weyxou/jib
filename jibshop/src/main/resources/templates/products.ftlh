<!DOCTYPE html>
<html>
<head>
    <title>jib</title>
</head>
<body>
<h1>Twilight</h1>
<h2>Jeweleries</h2>
<form action="/" method="get">
    Поиск по названию объявления: <input type="text" name="title"><br>
    <input type="submit" value="Search"/>
</form>
<#list products as product>
    <div>
        <p><b>${product.title}</b> ${product.price} $. | <a href="/product/${product.id}">More...</a></p>
    </div>
</#list>
<hr>
<h3>New product</h3>
<form action="/product/create" method="post" enctype="multipart/form-data">
    Title: <input type="text" name="title"/><br><br>
    Desc: <input type="text" name="description"/><br><br>
    Price: <input type="number" name="price"/><br><br>
    Image1: <input type="file" name="file1"/><br><br>
    <input type="submit" value="Add product"/>
</form>


</body>
</html>
