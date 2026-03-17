package com.iescastelar;
public class Realidades{
    private Integer id;
    private String texto;

    public Realidades(Integer id, String texto){
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
    public String toString() {
        return "ID: " + id + "\n" + " " + "ARGUMENTO: " + texto + "\n" + "----------------------" + "\n";
    }
}