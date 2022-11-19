package storeDao;

import java.util.HashSet;
import java.util.Scanner;

import storeEntity.Brand;

import java.util.*;

public abstract class Product {
    static HashSet<Brand> brands=new HashSet<>();
    protected Scanner scanner=new Scanner(System.in);
    private int id;
    private String name;
    private double price;
    private int discountRate;
    private int amount;
    private Brand brand;
    private double screenSize;
    private int ram;
    private int memory;

    public abstract void menu();
    public abstract void addItem();
    public abstract void getProducts();
    public abstract void deleteItem();

    public Product(int id,String name,double price,int discountRate,int amount,
                   Brand brand, double screenSize, int ram,int memory){
        this.id=id;
        this.name=name;
        this.price=price;
        this.discountRate=discountRate;
        this.amount=amount;
        this.brand=brand;
        this.screenSize=screenSize;
        this.ram=ram;
        this.memory=memory;
    }

    public Product(){

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

}