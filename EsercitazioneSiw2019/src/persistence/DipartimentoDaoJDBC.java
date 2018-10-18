package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.Dipartimento;
import persistence.dao.DipartimentoDao;

public class DipartimentoDaoJDBC implements DipartimentoDao{
	private DataSource dataSource;
	
	public DipartimentoDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void save(Dipartimento dipartimento) {
		// TODO Auto-generated method stu
		Connection connection = dataSource.getConnection();
		Long id = IdBroker.getId(connection);
		dipartimento.setCodice(id);
		
		String insert = "insert into dipartimento(codice, nome) "
				+ "values(?, ?)";
		try {
			PreparedStatement st = connection.prepareStatement
							(insert);
			st.setLong(1, dipartimento.getCodice());
			st.setString(2, dipartimento.getNome());
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
				

		
		
		
	}

	@Override
	public Dipartimento findByPrimaryKey(Long codice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dipartimento> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Dipartimento dipartimento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Dipartimento dipartimento) {
		// TODO Auto-generated method stub
		
	}

}
