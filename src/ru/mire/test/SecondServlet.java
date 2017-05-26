package ru.mire.test;

import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("title", "name");
		getServletConfig().getServletContext().getRequestDispatcher("/test.jsp").forward(request, response);
		
		/*		Writer out = response.getWriter();
				out.write("<html><head>"
						+ "<meta charset=\"utf-8\">"
						+ "</head><body>"
						+ "<H1>Log</H1>"
						+ "<form action = \"SecondServlet\" method=\"POST\">"
						+ "<input name=\"first_name\" type=\"text\" id=\"inputName\"/> <input name=\"password\" type=\"text\"/>"
						+ "<input type=\"submit\" /></form>"
						+ "<a href=\"MainServlet\">To register</a></body>"
						+ "<script>"
						+ "var inputName=document.getElementById(\"inputName\");"
						+ "alert(inputName);"
						+ "console.log(inputName.html)"
						+ "</script>"
						+ "</html>");
				//response.getWriter().append("Served at: ").append(request.getContextPath());*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		Writer out = response.getWriter();
		String name = request.getParameter("first_name");
		String password = request.getParameter("password");
		FileReader reader = new FileReader("BD.txt");
		reader.read();
		String BDname = "";
		String BDpasswd = "";
		int c;
		boolean f = false;
        while((c=reader.read())!=-1){
             if ((c == 10) &&(!f)){
            	f = true;
             } else if(!f){
            	 BDname +=(char)c;
             } else {
            	 BDpasswd +=(char)c;
             }
        	
        }
        //out.write(BDname + "<br>" + BDpasswd);
        out.write("<html>");
        if(name.equals(BDname)){
        	out.write("login: correct<br>");
        }else{
        	out.write("login: incorrect<br>");
        }
        if(password.equals(BDpasswd)){
        	out.write("password: correct<br>");
        }else{
        	out.write("password: incorrect<br>");
        }
        if(name.equals(BDname)&&password.equals(BDpasswd)){
        	out.write("access granted<br>");
        }else{
        	out.write("access denied<br>");
        }
        out.write("</html>");
	}

}
