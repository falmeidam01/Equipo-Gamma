package com.iescastelar;
public class Memes{
	private Integer id;
	private String texto;
	

	public Memes(Integer id, String texto){
		this.id = id;
		this.texto = texto;
	}
	public Integer getId(){
		return this.id;
	}
	public void setId(Integer id){
		this.id = id;
	}	
	public String getTexto(){
		return this.texto;
	}
	public void setTexto(String texto){
		this.texto = texto;
	}
	
	@Override
	public String toString(){
		return "ID: " + this.id + "Memes: " + this.texto;
	}
}