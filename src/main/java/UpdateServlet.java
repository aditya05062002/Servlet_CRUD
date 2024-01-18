

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		int rn= Integer.parseInt(request.getParameter("id"));
		String nm = request.getParameter("id");
		int mk = Integer.parseInt(request.getParameter("id"));
		String ct = request.getParameter("id");
		
		out.println("<form action='Update1' method='post'>");
		out.println("RollNo: <input type='text' name='t1' value='" + rn + "' style='padding: 5px; margin-bottom: 10px;' /><br>");
		out.println("Name: <input type='text' name='t2' style='padding: 5px; margin-bottom: 10px;' /><br>");
		out.println("Marks: <input type='text' name='t3' style='padding: 5px; margin-bottom: 10px;' /><br>");
		out.println("City: <input type='text' name='t4' style='padding: 5px; margin-bottom: 10px;' /><br>");
		out.println("<input type='submit' value='Update' style='background-color: #4caf50; color: #fff; padding: 10px; border: none; border-radius: 4px; cursor: pointer;' />");
		out.println("</form>");
		out.close();

	}

}
