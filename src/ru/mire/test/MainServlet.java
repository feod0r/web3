package ru.mire.test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		/*Writer out = response.getWriter();
		out.write("<html><meta charset=\"utf-8\"><body>"
				+ "<H1>Reg</H1>"
				+ "<form action = \"MainServlet\" method=\"POST\">"
				+ "<input name=\"first_name\" type=\"text\"/> <input name=\"password\" type=\"text\"/>"
				+ "<input type=\"submit\" /></form>"
				+ "<a href=\"SecondServlet\">To login</a></body></html>");*/
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setAttribute("title", "name");
		getServletConfig().getServletContext().getRequestDispatcher("/Main.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("first_name");
		String password = request.getParameter("password");
		PrintWriter writer = new PrintWriter("BD.txt", "UTF-8");
		writer.write(" " + name + "\n" + password);
		writer.close();
		File file = new File("BD.txt");
		
		Writer out = response.getWriter();
		
		
		
		out.write(password + name + file.getAbsolutePath()); 
		//fn = fn + " " + new Date();
		//doGet(request, response);
	}

}
