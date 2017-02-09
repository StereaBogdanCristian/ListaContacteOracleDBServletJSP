package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelpers.AddQuery;
import model.Prieteni;

@WebServlet("/Adauga")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nume = request.getParameter("nume");
		String prenume = request.getParameter("prenume");
		String email = request.getParameter("email");
		String nrTel = request.getParameter("nrTel");
		int varsta = Integer.parseInt(request.getParameter("varsta"));
		
		Prieteni prieten = new Prieteni(0, nume, prenume, email, nrTel, varsta);
		
		AddQuery aq = new AddQuery();
		aq.doAdd(prieten);
		
		String url = "/read";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
