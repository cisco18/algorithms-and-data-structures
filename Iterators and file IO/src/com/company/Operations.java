package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Operations {
    public void addWorkers(Worker[] workers) {
        boolean stop = false;
        System.out.println("chcesz dodac pracownika?");
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equals("nie")) {
            stop = true;
        }
        while (stop == false) {
            System.out.println("podaj imie pracownika");
            String name = scanner.nextLine();
            System.out.println("podaj nazwisko pracownika");
            String surname = scanner.nextLine();
            System.out.println("podaj pesel pracownika");
            long pesel = Long.parseLong(scanner.nextLine());
            System.out.println("podaj stanowisko pracownika");
            String position = scanner.nextLine();
            System.out.println("podaj staz pracownika");
            int experience = Integer.parseInt(scanner.nextLine());
            System.out.println(surname + " jest pracownikiem etatowym?(tak/nie)");
            if (scanner.nextLine().equals("tak")) {
                System.out.println("podaj etat");
                double etat = Double.parseDouble(scanner.nextLine());
                System.out.println("podaj pensje");
                double pay = Double.parseDouble(scanner.nextLine());
                WorkerE workerE = new WorkerE(name, surname, pesel, position, experience, etat, pay);
                for (int i = 0; i < workers.length; i++) {
                    if (workers[i] == null) {
                        workers[i] = workerE;
                        i = workers.length;
                    }
                }
            } else {
                System.out.println("podaj liczbe godzin");
                int hoursWorked = Integer.parseInt(scanner.nextLine());
                System.out.println("podaj stawke godzinowa");
                double hourlyPay = Double.parseDouble(scanner.nextLine());
                WorkerH workerH = new WorkerH(name, surname, pesel, position, experience, hourlyPay, hoursWorked);
                for (int i = 0; i < workers.length; i++) {
                    if (workers[i] == null) {
                        workers[i] = workerH;
                        i = workers.length;
                    }
                }

            }

            System.out.println("Czy chcesz dodac wiecej elementow do tablicy?(nie/tak)");
            if (scanner.nextLine().

                    equals("nie")) {
                stop = true;
            }
        }
    }

    public void showWorkersList(Worker[] workers) {
        Iterator<Worker> iterator = Arrays.stream(workers).iterator();
        for (int i = 0; i < 107; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.printf("| %-17s| %-15s| %-29s| %-12s| %8s| %13s|\n", "Nazwisko", "Imie", "PESEL", "Stanowisko", "Staz", "Pensja");
        for (int i = 0; i < 107; i++) {
            System.out.print("-");
        }
        System.out.println();
        Worker object;
        while((iterator.hasNext())){
            if ((object = iterator.next()) != null){
                Worker worker = object;
                worker.showWorker();
            }
        }
    }

    public void writeToFile(Worker[] workers) {
        try {
            FileOutputStream fos = new FileOutputStream("workers.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Worker worker : workers) {
                if (worker != null) {
                    oos.writeObject(worker);
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }


//limit 20 pracowników
    public Worker[] readFromFile(String nameOfFile) {
        Worker[] workers = new Worker[20];
        try {
            FileInputStream fos = new FileInputStream(nameOfFile);
            ObjectInputStream ois = new ObjectInputStream(fos);
            Worker worker;
            while ((worker = (Worker) ois.readObject()) != null) {
                for (int i = 0; i < workers.length; i++) {
                    if (workers[i] == null) {
                        workers[i] = worker;
                        i = workers.length;
                    }
                }
            }
            return workers;
        } catch (IOException | ClassNotFoundException exception) {
            if (exception instanceof EOFException) {

            } else {
                exception.printStackTrace();
            }
        }
        return workers;
    }
}



