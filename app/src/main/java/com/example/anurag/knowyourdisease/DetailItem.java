package com.example.anurag.knowyourdisease;

/**
 * Created by anurag on 10/4/16.
 */
public class DetailItem {
    private String name;
    private String weight;
    private String height;
    private String age;
    private double bmi;

    public DetailItem(){
        super();
    }
    public String getName() {
        return name;
    }
    public String getWeight() {
        return weight;
    }
    public String getAge() {
        return age;
    }
    public String getHeight() {
        return height;
    }
    public Double getBmi() {
        return bmi;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setWeight(String weight) {
        this.weight = weight;
    }
    public void setHeight(String height) {
        this.height = height;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public void setBmi(double bmi) {
        this.bmi = bmi;
    }
}
