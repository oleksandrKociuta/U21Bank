package servlets;

import javax.servlet.ServletException;              // defines a general exception a servlet can throw when it encounters difficulty
import javax.servlet.http.HttpServlet;              // provides an abstract class to be subclassed to create an HTTP servlet suitable for a Web site
import javax.servlet.http.HttpServletRequest;       // extends the ServletRequest interface to provide request information for HTTP servlets
import javax.servlet.http.HttpServletResponse;      // extends the ServletResponse interface to provide HTTP-specific functionality in sending a response.
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Саша on 22.03.2017.
 */
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        out.print("<h1>Hello Servlet</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        super.doPost(req, resp);
    }


}
