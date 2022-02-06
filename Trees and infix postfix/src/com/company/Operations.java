package com.company;

import java.util.Scanner;

public class Operations {
    public void chooseAnOperation(String infix, String[] chars) {
        System.out.println("Wybierz opcje:\n 1 tworzenie drzewa wyrażenia, węzły zawierają albo liczby całkowite albo operatory\n" +
                "(+,-, *, /, %)\n" +
                "Zanim wybierzesz opcje 5,6,7 najpierw wybierz 1\n" +
                "2 obliczanie wyrażenia arytmetycznego zapisanego w drzewie binarnym\n" +
                "3 wyświetlanie wyrażenia w postaci infiksowej (z nawiasami)\n" +
                "4 wyświetlanie wyrażenia w postaci postfiksowej (w postaci beznawiasowej, ONP)\n" +
                "5 obliczanie liczby liści\n" +
                "6 obliczanie liczby węzłów\n" +
                "7 obliczanie wysokości drzewa\n" +
                "8 koniec\n"+
                "9 zadanie dodatkowe\n");
        ExpressionTree expressionTree = new ExpressionTree();
        boolean goOn = true;
        while (goOn) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Wybierz numer");
            String number = scanner.nextLine();
            switch (number) {
                case "1":
                    expressionTree.constructTree(chars);
                    System.out.println("korzen to " + expressionTree.root.value);
                    break;
                case "2":
                    System.out.println("Wynik to " + expressionTree.calculate());
                    break;
                case "3":
                    System.out.println(infix + "\n");
                    break;
                case "4":
                    for (String string : chars) {
                        System.out.print(string);
                    }
                    System.out.println();
                    break;
                case "5":
                    System.out.println("Liczba lisci drzewa wynosi " + expressionTree.getLeafCount() + "\n");
                    break;
                case "6":
                    System.out.println("Liczba wezlow wynosi " + expressionTree.getNodeCount() + "\n");
                    break;
                case "7":
                    System.out.println("Wysokosc drzewa to " + expressionTree.findHeight() + "\n");
                    break;
                case "8":
                    goOn = false;
                    break;
                case "9":
                    expressionTree.zadanieDodatkowe(expressionTree.root);
                    break;

            }
        }
    }

    boolean isOperator(char c) {
        return c == ('+') || c == ('-')
                || c == ('*') || c == ('/')
                || c == ('^');
    }

    boolean isOperator2(char c) {
        return c == ('(') || c == (')');
    }

    public String[] transform(String string) {
        String[] strings;
        StringBuilder stringBuilder = new StringBuilder();
        int position = 0;
        boolean numberAgain = false;
        for (int i = 0; i < string.length(); i++) {
            if (isOperator(string.charAt(i)) || isOperator2(string.charAt(i))) {
                position++;
                numberAgain = false;
            } else {
                if (!numberAgain) {
                    position++;
                }
                numberAgain = true;
            }
        }
        strings = new String[position];
        position = 0;
        for (int i = 0; i < string.length(); i++) {
            if (isOperator(string.charAt(i)) || isOperator2(string.charAt(i))) {
                if (!stringBuilder.toString().equals("")) {
                    strings[position] = stringBuilder.toString();
                    position++;
                }
                stringBuilder.delete(0, 16);
                strings[position] = Character.toString(string.charAt(i));
                position++;
            } else {
                stringBuilder.append(string.charAt(i));
            }
        }

        if (!stringBuilder.toString().equals("")) {
            strings[position] = stringBuilder.toString();
        }


        return strings;
    }

    public String transformBack(String[] strings) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            stringBuilder.append(strings[i]);
        }
        return stringBuilder.toString();
    }
}
