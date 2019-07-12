<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>用户信息</title>
    <link rel="stylesheet" type="text/css" href="../css/my.css">
</head>
<body>
    <form action="/user/userSave" method="post">
        <input type="hidden" name="id" value='<c:out value="${user.id}" />'>
        <table>
            <tr>
                <td>用户名 :</td>
                <td><input type="text" name="name" value='<c:out value="${user.userName}" />'></td>
            </tr>
            <tr>
                <td>密码 :</td>
                <td><input type="password" name="password" value='<c:out value="${user.password}" />'></td>
            </tr>
            <tr>
                <td>真实姓名 :</td>
                <td><input type="text" name="age" value='<c:out value="${user.realName}" />'></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="保存"/>
                </td>
            </tr>
        </table>

    </form>
</body>
</html>