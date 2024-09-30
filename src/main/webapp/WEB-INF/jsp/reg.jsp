<%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 30.08.2024
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}../css/form.css"/>
</head>
<body>
<div class="main">
    <h1>HorseNB</h1>
    <h3>Enter your login credentials</h3>

    <%--Error massage block--%>
    <h2 style="color: #ff385c">${msg}</h2>
    <c:if test="${cause != null}">
        <details>
            <summary>Error Details</summary>
            <c:out value="${cause}"/>
            <details>
                <summary>Stack Trace</summary>
                <c:out value="${stack-trace}"/>
            </details>
        </details>
    </c:if>


    <form action="reg" method="post">

        <label for="email">
            Email:
        </label>
        <input type="text"
               id="email"
               name="email"
               placeholder="Enter your Email" required>

        <label for="psw">
            Password:
        </label>
        <input type="password"
               id="psw"
               name="psw"
               placeholder="Enter your Password" required>

        <div class="wrap">
            <button type="submit">
                Reg me
            </button>
        </div>
    </form>


</div>


</body>
</html>
