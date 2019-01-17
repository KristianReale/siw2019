package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CorsoDiLaurea;
import model.Dipartimento;
import persistence.DatabaseManager;
import persistence.dao.DipartimentoDao;

public class PopolaCorsiDiLaurea extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("SI");
		String dipS = req.getParameter("idDipartimento");
		DipartimentoDao dipDao = DatabaseManager.getInstance().getDaoFactory().getDipartimentoDAO();
		Dipartimento dip = dipDao.findByPrimaryKey(Long.parseLong(dipS));
		List<CorsoDiLaurea> laureas = dipDao.getCorsiDiLaurea(dip);
		for (CorsoDiLaurea c : laureas) {
			resp.getOutputStream().println("<option value=\"" + c.getCodice() +"\">" + c.getNome() + "</option>");
		}
		
	}
}
