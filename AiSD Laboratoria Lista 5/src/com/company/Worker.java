package com.company;

import java.io.Serializable;
import java.util.Objects;

public class Worker implements Serializable {
    private String PESEL;
    private String name;
    private String surname;
    private String date;
    private String position;
    private int salary;
    private int experience;
    private int bonus;


    public Worker(String PESEL, String name, String surname, String date, String position, int salary, int experience) {
        this.PESEL = PESEL;
        this.name = name;
        this.surname = surname;
        this.date = date;
        this.position = position;
        this.salary = salary;
        this.experience = experience;
        if (experience<10){
            bonus = 0;
        }
        if (experience<10){
            bonus = 0;
        }else if (experience>=20){
            bonus = (int) (this.salary*0.2);
        }else {
            bonus = (int)(salary*0.1);
        }
    }

    public String getSurname() {
        return surname;
    }

    public String getPESEL() {
        return PESEL;
    }

    public int getSalary() {
        return salary;
    }

    public int getBonus() {
        return bonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return name == ((Worker) o).name && surname == ((Worker) o).surname && PESEL == ((Worker) o).PESEL;
    }

    @Override
    public int hashCode() {
        return Objects.hash(PESEL+name+surname);
    }

    public int compare(Worker worker){
            return worker.PESEL.compareTo(PESEL);

    }

    @Override
    public String toString() {
        return
                "PESEL = " + PESEL  +
                " name = " + name +
                " surname = " + surname +
                " date = " + date +
                " position = " + position  +
                " salary = " + salary +
                " experience = " + experience +
                " bonus = " + bonus;
    }
}
