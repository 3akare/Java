<html lang="en-us">
<body>
<<<<<<< HEAD
<%@include file="header.jsp"%>

<form action="hello" method="post">
    <%@page import="com.example.servlet.Circle"%>
    <%@page import="com.example.servlet.Square"%>
    <%@page errorPage="error.jsp"%>

    <!-- declarative tag -->

    <%!
        int i = 123;
        String name = "David Bakare";
        String typeCast = 1224 + "";
    %>

    <!-- Inside the service method -->
    <%
    int k = 9/0;
    %>
=======
<h2>Hello World!</h2>
<form action="hello.jsp" method="post">
    <label>
        <input type="text" name="num1" placeholder="num1">
    </label>
    <label>
        <input type="text" name="num2" placeholder="num3">
    </label>
    <button>send</button>
    <a href="/hello.jsp">Bitches</a>
>>>>>>> 4e4258c8d559b5ba1d7a6ab44f397cd8003dedb9
</form>
<%@include file="footer.jsp"%>
</body>
</html>
