<html>
<body>
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
</form>
<%@include file="footer.jsp"%>
</body>
</html>
