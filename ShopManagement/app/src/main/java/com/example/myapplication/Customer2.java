package com.example.myapplication;


public class Customer2 {

    private String Name1;

    private String Product1;
    private String Price1;
    private  String mobile1;



    public Customer2() {

    }

    public Customer2(String Name, String Product, String Price , String mobile1) {

        this.Name1 = Name1;
        this.Product1 = Product1;
        this.Price1 = Price1;
        this.mobile1=mobile1;


    }

    public String getName1() {
        return Name1;
    }

    public void setName1(String name) {
        Name1 = name;
    }

    public String getProduct1() {
        return Product1;
    }

    public void setProduct1(String product) {
        Product1 = product;
    }

    public String getPrice1() {
        return Price1;
    }

    public void setPrice1(String price) {
        Price1 = price;
    }

    public String getMobile1() {
        return mobile1;
    }

    public void setMobile1(String mobile1) {
        this.mobile1 = mobile1;
    }
}