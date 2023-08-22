package odometer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

package OdometerWeb;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Odometer.Odometer;

public class OdometerServlet extends HttpServlet {
    private Odometer odometer = new Odometer(3); // Initialize with a 3-digit odometer

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Odometer Web Interface</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Odometer Web Interface</h1>");
        out.println("<p>Current Reading: " + odometer.getReading() + "</p>");
        out.println("<form action=\"OdometerServlet\" method=\"post\">");
        out.println("<button type=\"submit\" name=\"action\" value=\"increase\">Increase</button>");
        out.println("<button type=\"submit\" name=\"action\" value=\"decrease\">Decrease</button>");
        out.println("<button type=\"submit\" name=\"action\" value=\"reset\">Reset</button>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("increase".equals(action)) {
            odometer.incrementReading();
        } else if ("decrease".equals(action)) {
            odometer.decrementReading();
        } else if ("reset".equals(action)) {
            odometer.reset();
        }
        doGet(request, response); // Show updated reading on the page
    }
}

