package com.example.myapplication;


public class model
{
    String name,quantity,totalprice,purl;
    model()
    {

    }
    public model(String name, String quantity, String totalprice, String purl) {
        this.name = name;
        this.quantity = quantity;
        this.totalprice = totalprice;
        this.purl = purl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(String totalprice) {
        this.totalprice = totalprice;
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }
}

