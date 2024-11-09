import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Mypakage"})
public class Mypakage extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String para1 = request.getParameter("p1");
            String para2 = request.getParameter("p2");
            String para3 = request.getParameter("p3");

            out.println("<html><body>");
            out.println("Parameter 1: " + para1 + "<br>");
            out.println("Parameter 2: " + para2 + "<br>");
            out.println("Parameter 3: " + para3 + "<br>");

            Enumeration<String> headers = request.getHeaderNames();
            while (headers.hasMoreElements()) {
                String headerName = headers.nextElement();
                out.println("<h1>Header Name: " + headerName + " - Value: " + request.getHeader(headerName) + "</h1>");
            }
            out.println("</body></html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
