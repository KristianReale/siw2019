package persistence.dao;

import java.util.List;

import model.CorsoDiLaurea;
import model.Dipartimento;

public interface DipartimentoDao {
	public void save(Dipartimento dipartimento);  // Create
	public Dipartimento findByPrimaryKey(Long codice);     // Retrieve
	public List<Dipartimento> findAll();       
	public void update(Dipartimento dipartimento); //Update
	public void delete(Dipartimento dipartimento); //Delete	
	
	public List<CorsoDiLaurea> getCorsiDiLaurea(Dipartimento dipartimento);
}
