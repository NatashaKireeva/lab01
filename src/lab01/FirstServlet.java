package lab01;

/**
 * Created by Natasha on 05.04.2016.
 */
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import javax.servlet.ServletException;
import java.io.IOException;

@WebServlet("/servlettest")
public class FirstServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException, ServletException
    {
        response.setContentType("text/html");
        response.getWriter().print("This is " + this.getClass().getName() + ", using the GET method \n");
        response.getWriter().print("Servlet config " + this.getServletConfig() + ", using the GET method \n");
    }


}
