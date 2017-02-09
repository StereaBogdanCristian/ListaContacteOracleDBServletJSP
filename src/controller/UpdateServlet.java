package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBHelpers.UpdateQuery;
import model.Prieteni;

@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
	
	private int id;
	private static final long serialVersionUID = 1L;
       
    public UpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		id=(int)session.getAttribute("id");
		session.invalidate();
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String nume = request.getParameter("nume");
		String prenume = request.getParameter("prenume");
		String email = request.getParameter("email");
		String nrTel = request.getParameter("nrTel");
		int varsta = Integer.parseInt(request.getParameter("varsta"));
		
		Prieteni prieten = new Prieteni(id, nume, prenume, email, nrTel, varsta);
		
		UpdateQuery uq = new UpdateQuery(id);
		uq.doUpdate(prieten);
		
		String url = "/read";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	
	}

}


