package cat.itacademy.barcelonactiva.rue.xavier.s04.t01.n01.S04T01N01.controllers;

public class Greeting {
	private long id;
	private String texto;
	
	
	public Greeting(long id, String texto) {
		this.id = id;
		this.texto = texto;
	}
	
	public long getId() {
		return id;
	}
	
	public String getTexto() {
		return texto;
	}
	
	

}
