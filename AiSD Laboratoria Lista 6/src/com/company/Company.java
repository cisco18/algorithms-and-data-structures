package com.company;

import java.util.ArrayList;

public class Company {
    ArrayList<Magazine> list;
    private double gain;

    public Company() {
        list = new ArrayList<>();
    }


    public void addMagazine(Magazine magazine){
        list.add(magazine);
    }

    public void calculateGain(){
        for (Magazine magazine:list){
            gain += magazine.getGain();
        }
    }

    public  void print(){
        System.out.println("Firma zarobiła " + gain);
    }


}
