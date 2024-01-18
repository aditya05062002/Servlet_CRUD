import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Update1")
public class Update1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String s1 = request.getParameter("t1");
        String s2 = request.getParameter("t2");
        String s3 = request.getParameter("t3");
        String s4 = request.getParameter("t4");

        Stud s = new Stud();

        s.setRollno(Integer.parseInt(s1));
        s.setName(s2);
        s.setMarks(Integer.parseInt(s3));
        s.setCity(s4);

        int status = StudDao.update(s);
        if (status > 0) {
            response.sendRedirect("ViewServlet");
        } else {
            out.println("Unable to update");
        }
        out.close();
    }
}
