package com.example.terea2_3.Modelos;

public class Company {
    private int id ;
    private String name ;
    private int partner_id ;
    private int currency_id ;

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

    public void setIdSocio(int partner_id) {
        this.partner_id = partner_id;
    }
    public int getIdSocio() {
        return partner_id;
    }

    public void setIdMoneda(int currency_id) {
        this.currency_id = currency_id;
    }
    public int getIdMoneda() {
        return currency_id;
    }
}
