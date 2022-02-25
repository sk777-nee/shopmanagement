package com.example.myapplication;

public class Model2 {

    private String imageUrl , wname , mobile , address,age,upi;
    int sal;
    public Model2(){

    }

    public Model2(String imageUrl, String wname, String mobile, String address, String age , int sal , String upi) {
        this.imageUrl = imageUrl;
        this.wname = wname;
        this.mobile = mobile;
        this.address = address;
        this.age = age;
        this.sal = sal;
        this.upi = upi;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public String getUpi() {
        return upi;
    }

    public void setUpi(String upi) {
        this.upi = upi;
    }
}
