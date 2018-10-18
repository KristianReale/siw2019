package model;

import java.util.List;

public class CorsoDiLaurea {
	private int codice;
	private String nome;
	private Dipartimento dipartimento;
	List<Corso> corsi;
	
	
	public int getCodice() {
		return codice;
	}
	
	public void setCodice(int codice) {
		this.codice = codice;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
