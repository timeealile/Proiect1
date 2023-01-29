package com.example.proiecttimeea;

public class Produs {
    private String name;
    private int price;
    private int cantitate;
    private String id;

    public Produs(String name, int price, String i,int cantitate) {
        this.name = name;
        this.price = price;
        this.id = id;
        this.cantitate = cantitate;
    }

    public Produs(){}



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCantitate(){return cantitate;}

    public void setCantitate(int cantitate){this.cantitate = cantitate;}
}
