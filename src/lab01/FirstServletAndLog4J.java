package lab01;

/**
 * Created by Natasha on 05.04.2016.
 */

import javax.servlet.Servlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
@WebServlet(
        name = "servlettestname", urlPatterns = {"/servlettest-log4j"}
        ,initParams = {
        @WebInitParam(name= "log4j-init-file", value="WEB-INF/classes/log4j.properties")
}
)
//@WebServlet("/servlettest-log4j")
public class FirstServletAndLog4J extends HttpServlet implements Servlet
{
    static Logger logger = Logger.getLogger(FirstServletAndLog4J.class);

    public FirstServletAndLog4J() {
        super();
    }

//    public void init() throws ServletException {
//        BasicConfigurator.configure();
//    }

    public void init() {
        String prefix =  getServletContext().getRealPath("/");
        String file = getInitParameter("log4j-init-file");
        // if the log4j-init-file is not set, then no point in trying
        if(file != null) {
            PropertyConfigurator.configure(prefix+file);
        }
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException, ServletException
    {
       // BasicConfigurator.configure();

        response.setContentType("text/html");
        response.getWriter().print("This is " + this.getClass().getName() + ", using the GET method <br>");
        response.getWriter().print("Servlet config: " + this.getServletConfig() + ", using the GET method <br>");
        response.getWriter().print("Your IP adress is: " + request.getRemoteAddr() + "<br>");
        
        response.sendRedirect("https://getbootstrap.com/2.3.2/examples/carousel.html");
        //response.sendRedirect("index.jsp");

        logger.info("Hello from Log4j!!!");
        logger.info("Connection was established with " + request.getRemoteAddr());
        logger.info ("Servlet Path: " + request.getServletPath());
        logger.debug("- Debug level message");
        logger.warn("- Warn level message");
        logger.error("- Error level message");
        logger.fatal("- Fatal level message");
        logger.info("Wow! I'm configured!");
// This is the ending of the piece of code!!!
    }
}
