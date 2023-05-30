
	import java.io.IOException;
	import java.io.PrintWriter;
	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	public class La_14 {

	public class WelcomeServlet extends HttpServlet {
	    private static final long serialVersionUID = 1L;

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        // Read the input data from the request parameter
	        String name = request.getParameter("name");

	        // Set the content type of the response
	        response.setContentType("text/html");

	        // Get the PrintWriter object to write the response
	        PrintWriter out = response.getWriter();

	        // Generate the HTML response
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<title>Welcome</title>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<h1>Welcome, " + name + "!</h1>");
	        out.println("</body>");
	        out.println("</html>");
	    }
	}

}
