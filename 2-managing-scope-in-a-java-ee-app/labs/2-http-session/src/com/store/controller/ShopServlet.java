package com.store.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShopServlet
 */
@WebServlet("/shop")
public class ShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShopServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// obtain the HttpSession
		HttpSession session = request.getSession();

		// get the selected item from the form
		String item = request.getParameter("item");

		// add the selected item to the session with a lowercase key
		session.setAttribute(item.toLowerCase(), item);

		// set the response content type to html
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// StringBuilder to build t he HTML response
		StringBuilder strOut = new StringBuilder(200);

		// start building the HTML response
		strOut.append("<html><body><div id='cart'><h3> Shopping Cart </h3><ul>");

		// retrieve all attribute names from the session
		Enumeration<String> items = request.getSession().getAttributeNames();

		// loop through the items in the session and add them to the HTML response
		while (items.hasMoreElements()) {
			String anItem = (String) items.nextElement();
			strOut.append("<li>");
			strOut.append(request.getSession().getAttribute(anItem));
			strOut.append("</li>");
		}
		
		// add a link to shop more in the HTML response
		strOut.append("</br><a href='shop.html'>Yum, I Want To Shop Some More</a></br>");
		
		// complete the HTML response 
		strOut.append("</ul></div></body></html>");

		// print the HTML response
		out.print(strOut.toString());

		// close the 
		out.close();
	}
	
	/*
	 * This will allow to add similar item *
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // obtain the HttpSession
        HttpSession session = request.getSession();

        // get the selected item from the form
        String item = request.getParameter("item");

        // retrieve the list of items from the session
        List<String> cartItems = (List<String>) session.getAttribute("cartItems");

        // if the list doesn't exist, create it
        if (cartItems == null) {
            cartItems = new ArrayList<>();
        }

        // add the selected item to the list
        cartItems.add(item);

        // store the updated list back in the session
        session.setAttribute("cartItems", cartItems);

        // set the response content type to html
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // StringBuilder to build the HTML response
        StringBuilder strOut = new StringBuilder(200);

        // start building the HTML response
        strOut.append("<html><body><div id='cart'><h3> Shopping Cart </h3><ul>");

        // retrieve all items from the list in the session
        for (String cartItem : cartItems) {
            strOut.append("<li>");
            strOut.append(cartItem);
            strOut.append("</li>");
        }

        // add a link to shop more in the HTML response
        strOut.append("</br><a href='shop.html'>Yum, I Want To Shop Some More</a></br>");

        // complete the HTML response 
        strOut.append("</ul></div></body></html>");

        // print the HTML response
        out.print(strOut.toString());

        // close the PrintWriter
        out.close();
    } 
    */

}
