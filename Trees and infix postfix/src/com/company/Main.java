package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz wyrazenie w postaci infix(notacja zwykla)");
        String infix = scanner.nextLine();
        Operations operations = new Operations();
        String[] infixTransformed = operations.transform(infix);
        for (String string: infixTransformed){
            System.out.print(string);
        }
        System.out.println();
        RPN rpn = new RPN();

        String[] postfix = rpn.infixToPostfix(infixTransformed);
        for (String string: postfix){
            System.out.print(string);
        }
        operations.chooseAnOperation( infix, postfix);


    }
}
