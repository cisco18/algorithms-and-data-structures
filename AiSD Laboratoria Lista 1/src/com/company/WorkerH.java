package com.company;

public class WorkerH extends Worker{
    private double hourPay;
    private int hoursWorked;


    public WorkerH(String name, String surname, long pesel, String position, int experience, double hourPay, int hoursWorked){
        super(name, surname, pesel, position, experience);
        this.hoursWorked = hoursWorked;
        this.hourPay = hourPay;
    }


    public double calculateSalary() {
        return hourPay*hoursWorked;
    }
    public String toString() {
        return String.format("nazwisko = " + getSurname() +" imie = " + this.getName() + " pesel = " + this.getPesel() + " stanowisko " + this.getPosition() + " staz = " + this.getExperience() + " pensja = " + calculateSalary() );
    }
}
