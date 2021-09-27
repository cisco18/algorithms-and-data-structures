package com.company;

import java.io.*;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Operations {
    public OneWayLinkedListWithHead<Worker> createList() {
        OneWayLinkedListWithHead<Worker> oneWayLinkedListWithHead = new OneWayLinkedListWithHead();
        return oneWayLinkedListWithHead;
    }


    public OneWayLinkedListWithHead<Worker> readFromFile(String nameOfFile) {
        try {
            FileInputStream fis = new FileInputStream(nameOfFile);
            ObjectInputStream objectOutputStream = new ObjectInputStream(fis);
            return (OneWayLinkedListWithHead<Worker>) objectOutputStream.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public void saveToFile(String nameOfFile, OneWayLinkedListWithHead<Worker> list) {
        try {
            FileOutputStream fos = new FileOutputStream(nameOfFile);
            ObjectOutputStream outputStream = new ObjectOutputStream(fos);
            outputStream.writeObject(list);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Nie udalo sie zapisac bazy, sprobuj ponownie");
        }
    }

    public void printList(OneWayLinkedListWithHead<Worker> list) {

        System.out.println("Lista prezentuje sie nastepujaco:");
        OneWayLinkedListWithHead<Worker> list2 = new OneWayLinkedListWithHead<>();
        Iterator<Worker> iterator = list.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Worker worker = iterator.next();
            System.out.println(worker.toString());
        }


    }

    public boolean printOneWorker(String surname, OneWayLinkedListWithHead<Worker> list) {
        Iterator<Worker> iterator = list.iterator();
        while (iterator.hasNext()) {
            Worker worker = iterator.next();
            if (worker.getSurname().equals(surname)) {
                System.out.println(worker.toString());
                return true;
            }
        }
        return false;
    }

    public boolean addWorker(OneWayLinkedListWithHead<Worker> list, String PESEL, String name, String surname, String date, String position, int salary, int experience) {
        Worker worker = new Worker(PESEL, name, surname, date, position, salary, experience);
        add(list, worker);
        return true;
    }

    public void parking(OneWayLinkedListWithHead<Worker> list) {
        Operations operations = new Operations();
        boolean goOn = true;
        OneWayLinkedListWithHead<Worker> listParking = new OneWayLinkedListWithHead<>();
        Scanner scanner = new Scanner(System.in);
        while (goOn) {
            Iterator<Worker> iterator = list.iterator();
            Iterator<Worker> iterator2 = listParking.iterator();
            System.out.println("Osoba parkuje, czy wyjezdza? Wpisz P dla parkuje, W dla wyjezdza. By wyłączyć symulacje wpisz stop");
            String parking = scanner.nextLine();
            if (parking.toLowerCase().equals("stop")) {
                goOn = false;
            } else {
                if (parking.toUpperCase(Locale.ROOT).equals("P")) {
                    System.out.println("Podaj nazwisko osoby parkującej");
                    String surname = scanner.nextLine();
                    while (iterator.hasNext()) {
                        Worker worker = iterator.next();
                        if (worker.getSurname().equals(surname)) {
                            listParking.add(worker);
                        }
                    }
                    operations.printList(listParking);
                } else {
                    System.out.println("Podaj nazwisko osoby wyjezdzajacej");
                    String surname = scanner.nextLine();
                    boolean yet = false;
                    Worker toDelete = null;
                    while (iterator2.hasNext()) {
                        Worker worker = iterator2.next();
                        if (!worker.getSurname().equals(surname)) {
                            if (yet) {
                                System.out.println(worker.getSurname() + " musi wyjechać z parkingu");
                            }
                        }
                        if (worker.getSurname().equals(surname)) {
                            toDelete = worker;
                            yet = true;
                        }
                    }
                    if (toDelete != null) {
                        listParking.delete(toDelete);
                    }
                    operations.printList(listParking);
                }
            }

        }
    }

    public void add(OneWayLinkedListWithHead<Worker> list, Worker worker) {
        boolean ended = false;
        for (Worker worker1 : list) {
            if (worker1.compare(worker) == 0) {
                int index = list.indexOf(worker1);
                list.add(index, worker);
                ended = true;
                break;
            }
        }
        if (list.size() >= 2 && !ended) {
            boolean highest = true;
            boolean lowest = true;
            for (Worker worker1 : list) {
                if (worker.compare(worker1) < 0) {
                    highest = false;
                }
                if (worker.compare(worker1) > 0) {
                    lowest = false;
                }
            }
            if (lowest) {
                list.add(worker);
            } else if (highest) {
                list.add(0, worker);
            } else {
                for (int i = 0; i < list.size() - 1; i++) {
                    if (worker.compare(list.get(i)) > 0 && worker.compare(list.get(i + 1)) < 0) {
                        list.add(i + 1, worker);
                    }
                }
            }
        }
        if (list.size() == 1 && !ended) {
            if (list.get(0).compare(worker) > 0) {
                list.add(1, worker);
            } else if (list.get(0).compare(worker) < 0) {
                list.add(0, worker);
            }
        }

        if (list.size() == 0 && !ended) {
            list.add(worker);

        }
    }

    public boolean deleteWorkerFromDataBase(OneWayLinkedListWithHead<Worker> list, String surname) {
        Iterator<Worker> iterator = list.iterator();
        while (iterator.hasNext()) {
            Worker worker = iterator.next();
            if (worker.getSurname().equals(surname)) {
                list.delete(worker);
                return true;
            }
        }
        return false;

    }

    public boolean deleteWorkerFromDataBasePesel(OneWayLinkedListWithHead<Worker> list, String pesel) {
        Iterator<Worker> iterator = list.iterator();
        while (iterator.hasNext()) {
            Worker worker = iterator.next();
            if (worker.getPESEL().equals(pesel)) {
                list.delete(worker);
                return true;
            }
        }
        return false;

    }

    public boolean updateWorkersData(String surnameOfOldWorker, OneWayLinkedListWithHead<Worker> list, String PESEL, String name, String surname, String date,
                                     String position, int salary, int experience) {
        deleteWorkerFromDataBase(list, surnameOfOldWorker);
        return addWorker(list, PESEL, name, surname, date, position, salary, experience);


    }

    public int calculateMediumSalary(OneWayLinkedListWithHead<Worker> list) {
        int sum = 0;
        int workersCount = 0;
        Iterator<Worker> iterator = list.iterator();
        while (iterator.hasNext()) {
            Worker worker = (Worker) iterator.next();
            sum += (worker.getSalary() + worker.getBonus());
            workersCount++;

        }
        return (sum / workersCount);
    }


    public int howManyEarnLessThanMedium(OneWayLinkedListWithHead<Worker> list) {
        int medium = calculateMediumSalary(list);
        int count = 0;
        Iterator<Worker> iterator = list.iterator();
        while (iterator.hasNext()) {
            Worker worker = (Worker) iterator.next();
            if (worker.getSalary() + worker.getBonus() < medium) {
                count++;
            }

        }
        return count;
    }
}


