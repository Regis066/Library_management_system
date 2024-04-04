package lib.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lib.models.Book;
import lib.services.BookDao;

/**
 * Servlet implementation class AddBookServlet
 */
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddBookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		String publisher = request.getParameter("publisher");
		String publicationDate = request.getParameter("publication_date");
		String subject = request.getParameter("subject");

		// Create a new Book object
		Book book = new Book();
		book.setName(name);
		book.setAuthor(author);
		book.setPublisher(publisher);
		// Convert publication date string to java.util.Date
//		java.util.Date utilDate = java.sql.Date.valueOf(publicationDate);
		book.setPublicationDate(java.sql.Date.valueOf(publicationDate));
		book.setSubject(subject);

		// Add the book to the database
		BookDao bookDao = new BookDao();
		bookDao.addBook(book);

		// Redirect back to the add book page with a success message
		response.sendRedirect("search.jsp");
	}

}
