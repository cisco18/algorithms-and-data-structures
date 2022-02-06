package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Menu {
    public void createMenu() {
        boolean goOn = true;
        Operations operations = new Operations();
        Scanner scanner = new Scanner(System.in);
        OneWayLinkedListWithHead<Worker> list = operations.createList();
        System.out.println("1. Utworzenie nowej bazy danych\n" +
                "2. Odczyt bazy z pliku\n" +
                "3. Wyświetlenie wszystkich rekordów\n" +
                "4. Wyświetlenie danych jednego pracownika\n" +
                "5. Dopisanie nowego pracownika\n" +
                "6. Usunięcie pracownika z bazy\n" +
                "7. Aktualizowanie danych pracownika\n" +
                "8. Obliczanie średniej pensji w firmie\n" +
                "9. Obliczanie ilu pracowników zarabia poniżej średniej\n" +
                "10. Zapis bazy do pliku\n" +
                "11. Symulacja parkingu\n" +
                "Wpisz sama liczbe i kliknij enter\n");
        while (goOn) {
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: {
                    list = operations.createList();
                    System.out.println("Utworzono nowa baze danych");
                    break;
                }
                case 2: {
                    System.out.println("Podaj nazwe pliku");
                    String nameOfFile = scanner.nextLine();
                    list = operations.readFromFile(nameOfFile);
                    break;
                }
                case 3: {
                    operations.printList(list);
                    break;
                }
                case 4: {
                    System.out.println("Podaj nazwisko pracownika");
                    String surname = scanner.nextLine();
                    operations.printOneWorker(surname, list);
                    break;
                }
                case 5: {
                    System.out.println("Podaj PESEL");
                    String pesel = scanner.nextLine();
                    System.out.println("Podaj imie");
                    String name = scanner.nextLine();
                    System.out.println("Podaj nazwisko");
                    String surname = scanner.nextLine();
                    System.out.println("Podaj date urodzenia");
                    String date = scanner.nextLine();
                    System.out.println("Podaj stanowisko");
                    String position = scanner.nextLine();
                    System.out.println("Podaj pensje");
                    int salary = Integer.parseInt(scanner.nextLine());
                    System.out.println("Podaj staz");
                    int experience = Integer.parseInt(scanner.nextLine());
                    operations.addWorker(list, pesel, name, surname, date, position, salary, experience);
                    break;
                }


                case 6: {
                    System.out.println("Podaj nazwisko pracownika ktorego chcesz usunac, jesli chcesz usunac po PESELU wpisz PESEL");
                    String surname = scanner.nextLine();
                    if (surname.toUpperCase(Locale.ROOT).equals("PESEL")) {
                        System.out.println("Podaj PESEL pracownika do usuniecia z bazy");
                        String pesel2 = scanner.nextLine();
                        if (operations.deleteWorkerFromDataBasePesel(list, pesel2)) {
                            System.out.println("Usunieto pracownika");
                        } else {
                            System.out.println("Nie udalo sie znalezc takiego pracownika");
                        }

                    } else {
                        if (operations.deleteWorkerFromDataBase(list, surname)) {
                            System.out.println("Usunieto pracownika");
                        } else {
                            System.out.println("Nie udalo sie znalezc takiego pracownika");
                        }
                    }
                    break;
                }
                case 7: {
                    System.out.println("Podaj nazwisko pracownika ktorego chcesz zaktualizowac, jesli chcesz zaktualizowac po PESELU wpisz PESEL");
                    String surname = scanner.nextLine();
                    if (surname.toUpperCase(Locale.ROOT).equals("PESEL")) {
                        System.out.println("Podaj PESEL pracownika do aktualizacji z bazy");
                        String pesel3= scanner.nextLine();
                        if (operations.deleteWorkerFromDataBasePesel(list, pesel3)) {
                            System.out.println("Podaj PESEL");
                            String pesel = scanner.nextLine();
                            System.out.println("Podaj imie");
                            String name = scanner.nextLine();
                            System.out.println("Podaj nazwisko");
                            surname = scanner.nextLine();
                            System.out.println("Podaj date urodzenia");
                            String date = scanner.nextLine();
                            System.out.println("Podaj stanowisko");
                            String position = scanner.nextLine();
                            System.out.println("Podaj pensje");
                            int salary = Integer.parseInt(scanner.nextLine());
                            System.out.println("Podaj staz");
                            int experience = Integer.parseInt(scanner.nextLine());
                            operations.addWorker(list, pesel, name, surname, date, position, salary, experience);
                            System.out.println("Zaktualizowao pracownika");
                        } else {
                            System.out.println("Nie udalo sie znalezc takiego pracownika");
                        }

                    } else {
                        if (operations.deleteWorkerFromDataBase(list, surname)) {
                            System.out.println("Podaj PESEL");
                            String pesel = scanner.nextLine();
                            System.out.println("Podaj imie");
                            String name = scanner.nextLine();
                            System.out.println("Podaj nazwisko");
                            surname = scanner.nextLine();
                            System.out.println("Podaj date urodzenia");
                            String date = scanner.nextLine();
                            System.out.println("Podaj stanowisko");
                            String position = scanner.nextLine();
                            System.out.println("Podaj pensje");
                            int salary = Integer.parseInt(scanner.nextLine());
                            System.out.println("Podaj staz");
                            int experience = Integer.parseInt(scanner.nextLine());
                            operations.addWorker(list, pesel, name, surname, date, position, salary, experience);
                            System.out.println("Zaktualizowao pracownika");
                        } else {
                            System.out.println("Nie udalo sie znalezc takiego pracownika");
                        }
                    }
                    break;
                }
                case 8: {
                    String medium = String.valueOf(operations.calculateMediumSalary(list));
                    System.out.println("Srednia pensja wynosi " + medium);
                    break;
                }
                case 9: {
                    String count = String.valueOf(operations.howManyEarnLessThanMedium(list));
                    System.out.println("Ponizej sredniej zarabia " + count + " pracownikow");
                    break;
                }
                case 10: {
                    System.out.println("podaj nazwe pliku do zapisu");
                    String nameOfFile = scanner.nextLine();
                    operations.saveToFile(nameOfFile, list);
                    break;
                }
                case 11: {
                    operations.parking(list);
                }
                default: {
                    System.out.println("Wpisz poprawna cyfre");
                    break;
                }
            }
        }
    }
}
