package com.servlet.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Encrypt
 */
@WebServlet("/encrypt")
public class Encrypt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Encrypt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get first and last name from the request
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		
		// get items from ServletContext (application scope)
		ServletContext context = getServletContext();
		String dbConnection = (String) context.getAttribute("dbConnection");
		
		// Combine and reverse the string
		String combinedName = new StringBuilder(firstName + " " + lastName).reverse().toString();
		System.out.println("reversed Name: " + combinedName);
		
		// replace the vowels with random ASCII characters between 35-95
		String encryptedName = encryptName(combinedName);
		System.out.println("encrypted Name :" + encryptedName);
		
		// write "Developer Starter Page" with the encrypted value
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("<h2>Developer Starter Page</h2>");
		out.print("<p>Encrypted Name: " + encryptedName + "</p>");
		out.print("<p>Database Connection is " + dbConnection + "</p>");
		out.print("</body></html>");
		
	}

	private String encryptName(String name) {
		// replace vowels with random ASCII characters between 35-95
		Random random = new Random();
		char[] encryptedChars = name.toCharArray();
		for (int i = 0; i < encryptedChars.length; i++) {
			char currentChar = encryptedChars[i];
			if (isVowel(currentChar)) {
				// replace vowel with random ASCII character
				encryptedChars[i] = (char) (random.nextInt(95 - 35) + 35);
			}
		}
		
		return new String(encryptedChars);
	}

	private boolean isVowel(char c) {
		return "aeiouAEIOU".indexOf(c) != -1;
	}

}
