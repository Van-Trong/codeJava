/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class Motocycles implements Serializable {

    private String image;
    private String ID;

    private String name;
    private String brand;
    private int quantity;
    private int displacement;
    private float price;
    private int yearOfRelease;

    public Motocycles() {
        this.image = "";
        this.ID = "";
        this.name = "";
        this.brand = "";
        this.quantity = 0;
        this.displacement = 0;
        this.price = 0.0f;
        this.yearOfRelease = 0;

    }

    public Motocycles(String image, String ID, String name, String type, int quantity, int massFraction, float price, int yearOfRelease) {
        this.image = image;
        this.ID = ID;
        this.name = name;
        this.brand = type;
        this.quantity = quantity;
        this.displacement = massFraction;
        this.price = price;
        this.yearOfRelease = yearOfRelease;
    }

    public String getImage() {
        return image;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getInfoAsString() {
        String str = this.getID();
        str += "," + this.getID();
        str += "," + this.getName();
        str += "," + this.getBrand();
        str += "," + this.getQuantity();
        str += "," + this.getDisplacement();
        str += "," + this.getPrice();
        str += "," + this.getYearOfRelease();
        return str;
    }

}
