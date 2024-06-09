<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
 <%
        int[] david = {1, 2, 3, 4};
        out.print("<h1>List of items</h1>");
        for (int num: david){
            out.println(num);
            out.print("<br/>");
        }

        out.print(name);
 %>
</body>
</html>