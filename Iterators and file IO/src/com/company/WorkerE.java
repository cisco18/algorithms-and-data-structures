package com.company;

public class WorkerE extends Worker{
    private double etat;
    private double pay;


    public WorkerE(String name, String surname, long pesel, String position, int experience, double etat, double pay) {
        super(name, surname, pesel, position, experience);
        this.etat = etat;
        this.pay = pay;

    }

    public double calculateSalary() {
        return etat*pay;
    }

    public String toString() {
        return String.format("nazwisko = " + getSurname() +" imie = " + this.getName() + " pesel = " + this.getPesel() + " stanowisko " + this.getPosition() + " staz = " + this.getExperience() + " pensja = " + calculateSalary() );
    }


}
