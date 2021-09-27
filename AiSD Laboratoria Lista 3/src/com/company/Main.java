package com.company;

public class Main {

    public static void main(String[] args) {
        Brackets brackets = new Brackets();
        brackets.printBalance(brackets.isBalanced());
        System.out.println(brackets.isOpeningBracket());
        System.out.println(brackets.isClosingBracket());
        System.out.println(brackets.isPal());

    }
}
