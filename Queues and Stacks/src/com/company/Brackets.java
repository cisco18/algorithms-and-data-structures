package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Brackets {
    public boolean isBalanced() {
        try {
            boolean isTrue = true;
            ArrayStack<Character> arrayStack = new ArrayStack<>(Character.class, 40);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Podaj wyrazenie");
            String s1 = scanner.nextLine();
            char[] chars = s1.toCharArray();
            for (char c1 : chars) {
                c1 = (Character) c1;
                if (Character.compare(c1, '(') == 0 || Character.compare(c1, '{') == 0 || Character.compare(c1, '[') == 0) {
                    arrayStack.push(c1);
                }
                switch (c1) {
                    case ')':
                        if (Character.compare('(', arrayStack.pop()) != 0) {
                            isTrue = false;
                        }
                        break;
                    case '}':
                        if (Character.compare('{', arrayStack.pop()) != 0) {
                            isTrue = false;
                        }
                        break;
                    case ']':
                        if (Character.compare('[', arrayStack.pop()) != 0) {
                            isTrue = false;
                        }
                        break;
                }
            }
            return isTrue;

        } catch (NullPointerException e) {
            return false;
        } catch (StackOverflowError e) {
            return false;
        }

    }

    public boolean isOpeningBracket() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj wyrazenie");
        String s1 = scanner.nextLine();
        System.out.println("Podaj nawias otwierający");
        char c = scanner.nextLine().charAt(0);
        char[] chars = s1.toCharArray();
        for (char c1 : chars) {
            c1 = (Character) c1;
            if (Character.compare(c1, '(') == 0 || Character.compare(c1, '{') == 0 || Character.compare(c1, '[') == 0) {
                if (Character.compare(c1, c) == 0) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public boolean isClosingBracket() {
        ArrayStack<Character> arrayStack = new ArrayStack<>(Character.class, 40);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj wyrazenie");
        String s1 = scanner.nextLine();
        System.out.println("Podaj nawias zamykający");
        char c = scanner.nextLine().charAt(0);
        char[] chars = s1.toCharArray();
        for (char c1 : chars) {
            c1 = (Character) c1;
            if (Character.compare(c1, ')') == 0 || Character.compare(c1, '}') == 0 || Character.compare(c1, ']') == 0) {
                arrayStack.push(c1);
            }
        }
        if (arrayStack.pop() == c) {
            return true;
        } else return false;
    }


    public void printBalance(boolean b) {
        if (b == true) {
            System.out.println("wyrazenie zbalansowane");
        } else {
            System.out.println("wyrazenie niezbalansowane");
        }
    }

    public boolean isPal() {
        ArrayStack<Character> arrayStack = new ArrayStack<>(Character.class, 40);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj wyrazenie");
        String s1 = scanner.nextLine();
        char[] chars = s1.toCharArray();
        char[] charsReversed = new char[chars.length];
        for (char c1 : chars) {
            switch (c1) {
                case ')':
                    arrayStack.push('(');
                    break;
                case '}':
                    arrayStack.push('{');
                    break;
                case ']':
                    arrayStack.push('[');
                    break;
                case '(':
                    arrayStack.push(')');
                    break;
                case '{':
                    arrayStack.push('}');
                    break;
                case '[':
                    arrayStack.push(']');
                    break;
                default:
                    arrayStack.push(c1);
            }
        }
        int length = arrayStack.size();
        for (int i = 0; i < length; i++) {
            charsReversed[i] = arrayStack.pop();
        }
        if (Arrays.equals(charsReversed, chars)) {
            return true;
        } else return false;
    }
}
