package com.example.lab2ex4;

public class Employee {
    private String id;
    private String name;
    private boolean Manager;

    public String getId() {
        return id;
    }

    public  String getFullName() {
        return name;
    }
    public void setId(String i){
        this.id =i;
    }
    public void setName(String n){
        this.name = n;
    }
    public boolean isManager() {
        return Manager;
    }
    public void setManager(boolean isMana){
        this.Manager=isMana;
    }
    public String toString(){
        return this.id +" "+ this.name;
    }


}
