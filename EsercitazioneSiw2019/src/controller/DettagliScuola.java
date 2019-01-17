package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import model.Scuola;
import model.Studente;
import persistence.DatabaseManager;
import persistence.dao.StudenteDao;

public class DettagliScuola extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String jsonReceived = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String line = reader.readLine();
		while (line != null) {
			jsonReceived = jsonReceived + line + "\n";
			line = reader.readLine();
		}
		System.out.println(jsonReceived);
		try {
			JSONObject json = new JSONObject(jsonReceived);
			Studente studente = new Studente();
			studente.setMatricola(json.getString("matricola"));
			studente.setNome(json.getString("nome"));
			studente.setCognome(json.getString("cognome"));
			
			StudenteDao sDao = DatabaseManager.getInstance().getDaoFactory().getStudenteDAO();
			Studente dbStudente = sDao.findByPrimaryKey(studente.getMatricola());
			Scuola scuola = dbStudente.getScuolaDiDiploma();
			
			JSONObject jsonScuola = new JSONObject(scuola);
		
			System.out.println(jsonScuola.toString());
			resp.getWriter().println(jsonScuola.toString());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
