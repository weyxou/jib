<!DOCTYPE html>
<html>
<head>
    <title>Twilight</title>
</head>
<body>
<h1>Twilight</h1>
<hr>
<h4>Admin-Panel</h4>
<table>
    <tr>
        <th>Email</th>
        <th>Activity</th>
        <th>Edit</th>
        <th>More information</th>
    </tr>
    <#list users as user>
        <tr>
            <th>${user.email}</th>
            <th><#if user.active>true<#else>false</#if></th>
            <th><a href="/admin/user/edit/${user.id}">Edit</a></th>
            <th><a href="/user/${user.id}">More information</a></th>
        </tr>
    <#else>
        <h3>No users</h3>
    </#list>
</table>
</body>
</html>