package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Studente;
import persistence.DatabaseManager;
import persistence.dao.StudenteDao;

public class Home extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = (String) req.getSession().getAttribute("username");
		
		if (username != null) {
			StudenteDao studenteD = DatabaseManager.getInstance().getDaoFactory().getStudenteDAO();
			Studente s = studenteD.findByPrimaryKey(username);
//			req.setAttribute("nome", s.getNome());
//			req.setAttribute("cognome", s.getCognome());
			req.setAttribute("studente", s);
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
		rd.forward(req, resp);
	}
}
