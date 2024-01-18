
import java.util.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		List <Stud> l = StudDao.showStud();
		out.println("<h1 style='text-align: center; color: #3498db; margin-top: 20px;'>Student Information</h1>");
		out.println("<h2>");
		out.println("<table border='1' width='60%' style='border-collapse: collapse; margin-top: 20px; margin-left: auto; margin-right: auto;'>");
		out.println("<tr><td style='padding: 10px;'>RollNo:</td><td style='padding: 10px;'>Name:</td><td style='padding: 10px;'>Marks:</td><td style='padding: 10px;'>City:</td><td colspan='2' style='padding: 10px;'>Actions:</td></tr>");

		for (Stud s : l) {
		    out.print("<tr>");
		    out.print("<td style='padding: 10px;'>" + s.getRollno() + "</td>");
		    out.print("<td style='padding: 10px;'>" + s.getName() + "</td>");
		    out.print("<td style='padding: 10px;'>" + s.getMarks() + "</td>");
		    out.print("<td style='padding: 10px;'>" + s.getCity() + "</td>");
		    out.print("<td style='padding: 10px;'><a href='UpdateServlet?id=" + s.getRollno() + "' style='text-decoration: none; color: #3498db;'>Update</a></td>");
		    out.print("<td style='padding: 10px;'><a href='DeleteServlet?id=" + s.getRollno() + "' style='text-decoration: none; color: #e74c3c;'>Delete</a></td>");
		    out.print("</tr>");
		}

		out.print("</table>");
		out.close();
	}

}
