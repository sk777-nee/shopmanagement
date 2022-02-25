package com.example.myapplication;


public class Customer {

    private String Name;

    private String Product;
    private String Price;
    private  String mobile;



    public Customer() {

    }

    public Customer(String Name, String Product, String Price ,String mobile) {

        this.Name = Name;
        this.Product = Product;
        this.Price = Price;
        this.mobile = mobile;


    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getProduct() {
        return Product;
    }

    public void setProduct(String product) {
        Product = product;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}