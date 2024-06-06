import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class AddServlet extends HttpServlet{
   public void service(HttpServletRequest request, HttpServletResponse response){
    int i = Integer.parseInt(request.getParameter("num1"));
    System.out.println(request.getMethod());
   }
}