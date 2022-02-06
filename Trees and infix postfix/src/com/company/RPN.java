package com.company;

import java.util.Stack;

public class RPN {

    // A utility function to return
    // precedence of a given operator
    // Higher returned value means
    // higher precedence
    static int Prec(String ch)
    {
        switch (ch)
        {
            case "+":
            case "-":
                return 1;

            case "*":
            case "'/'":
                return 2;

            case "^":
                return 3;
        }
        return -1;
    }

    boolean isOperand(String s){
        if (s.equals("*")||s.equals("+")||s.equals("-")||s.equals("/")||s.equals("^")||s.equals("(")||s.equals(")")){
            return false;
        }
        return true;
    }

    // The main method that converts
    // given infix expression
    // to postfix expression.
    public String[] infixToPostfix(String[] exp)
    {
        int countOfBrackets = 0;
        for (String s : exp){
            if (s.equals("(") || s.equals(")")){
                countOfBrackets++;
            }
        }
        // initializing empty String for result
        String[] result = new String[exp.length-countOfBrackets];
        int position = 0;

        // initializing empty stack
        Stack<String> stack = new Stack<>();

        for (int i = 0; i<exp.length; ++i)
        {
            String c = exp[i];

            // If the scanned character is an
            // operand, add it to output.
            if (isOperand(c)) {
                result[position] = c;
                position++;
            }
                // If the scanned character is an '(',
                // push it to the stack.
            else if (c.equals("(")) {
            stack.push(c);
        }
                //  If the scanned character is an ')',
                // pop and output from the stack
                // until an '(' is encountered.
            else if (c.equals(")"))
            {
                while (!stack.isEmpty() &&
                        !stack.peek().equals("("))
                    result[position] = stack.pop();
                    position++;

                stack.pop();
            }
            else // an operator is encountered
            {
                while (!stack.isEmpty() && Prec(c)
                        <= Prec(stack.peek())){

                    result[position] = stack.pop();
                    position++;
                }
                stack.push(c);
            }

        }

        // pop all the operators from the stack
        while (!stack.isEmpty()){
            result[position] = stack.pop();
            position++;
        }
        return result;
    }
}
