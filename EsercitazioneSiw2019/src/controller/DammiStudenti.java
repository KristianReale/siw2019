package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Studente;
import persistence.DatabaseManager;
import persistence.dao.StudenteDao;

public class DammiStudenti extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		StudenteDao sDao = DatabaseManager.getInstance().getDaoFactory().getStudenteDAO();
		List<Studente> studs = sDao.findAll();
		
		req.setAttribute("studenti", studs);
		
		RequestDispatcher rd = req.getRequestDispatcher
				("gestioneStudenti/studenti.jsp");
		rd.forward(req, resp);
		
	}
}
