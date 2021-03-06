package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dipartimento;
import model.Studente;
import persistence.DatabaseManager;
import persistence.dao.DipartimentoDao;

public class IscriviStudente extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		String matricola = req.getParameter("matricola");
		String nome = req.getParameter("matricola");
		String cognome = req.getParameter("matricola");
		String dataNascita = req.getParameter("dataNascita");
		
		DateFormat format = new SimpleDateFormat(
							"yyyy-mm-dd", Locale.ITALIAN);
		
		try {
			Date date = format.parse(dataNascita);
			Studente s = new Studente(matricola, nome, cognome, date);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		Studente s = new Studente(matricola, nome, cognome, dataNascita);
		resp.getWriter().println(matricola);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DipartimentoDao dipDao = DatabaseManager.getInstance().getDaoFactory().getDipartimentoDAO();
		List<Dipartimento> dipartimenti = dipDao.findAll();
		req.setAttribute("dipartimenti", dipartimenti);
		
		RequestDispatcher rd = req.getRequestDispatcher("iscriviStudenti.jsp");
		rd.forward(req, resp);
	}
}
