package com.company;

import java.io.Serializable;

public abstract class Worker implements Serializable {
    private String name;
    private String surname;
    private long pesel;
    private String position;
    private int experience;

    public Worker(String name, String surname, long pesel, String position, int experience)  {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.position = position;
        this.experience = experience;

    }

    public void showWorker(){
        System.out.printf("| %-17s| %-15s| %-29d| %-12s| %8d| %13.2f|\n", surname, name, pesel, position, experience, calculateSalary());
    }

    @Override
    public String toString() {
        return String.format("nazwisko = " + surname +" imie = " + name + " pesel = " + pesel + " stanowisko " + position + " staz = " + experience );
    }
    public abstract double calculateSalary();


    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public long getPesel() {
        return pesel;
    }

    public String getPosition() {
        return position;
    }

    public String getSurname() {
        return surname;
    }
}
