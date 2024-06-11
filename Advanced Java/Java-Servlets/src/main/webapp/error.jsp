<html>
<body>
<%@include file="header.jsp"%>
<%@page isErrorPage="true" %>
    <h1>Error</h1>
    <%= exception.getMessage(); %>
<%@include file="footer.jsp"%>
</body>
</html>
