<!DOCTYPE html>
<html>
<head>
    <title>Twilight</title>
</head>
<body>
<h1>Twilight
<br>
    <a href="/login">Login</a></h1><hr>
<h4>Jewelleries</h4>
<form action="/" method="get">
    Search: <input type="text" name="title"><br>
    <input type="submit" value="Search"/>
</form>
<#list products as product>
    <div>
        <p><b>${product.title}</b> ${product.price} $ | <a href="/product/${product.id}">More...</a></p>
    </div>
<#else>
    <h3>No jewelleries</h3>
</#list>
<hr>
<h3>Add new product</h3>
<form action="/product/create" method="post" enctype="multipart/form-data">
    Title: <input type="text" name="title"/><br><br>
    Desc: <input type="text" name="description"/><br><br>
    Price: <input type="number" name="price"/><br><br>

    Image: <input type="file" name="file1"/><br><br>

    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Add product"/>
</form>
</body>
</html>