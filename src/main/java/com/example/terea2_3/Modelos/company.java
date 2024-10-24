package com.example.terea2_3.Modelos;

public class company {
    private int id ;
    private String name ;
    private int idSocio ;
    private int idMoneda ;
    private int idArticulo ;
    private int uidCreador ;

    //GETTER & SETTERS

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }
    public int getIdSocio() {
        return idSocio;
    }

    public void setIdMoneda(int idMoneda) {
        this.idMoneda = idMoneda;
    }
    public int getIdMoneda() {
        return idMoneda;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }
    public int getIdArticulo() {
        return idArticulo;
    }

    public void setUidCreador(int uidCreador) {
        this.uidCreador = uidCreador;
    }
    public int getUidCreador() {
        return uidCreador;
    }

}
