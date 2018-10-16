package com.cmq.linkedin;

import java.util.Stack;

/*
Question:
150        Evaluate Reverse Polish Notation  input 是double，原题是int。
第二题有follow up，加一个 factorial “！”。
 */


public class Evaluate_Reverse_Polish_Notation_modifyed {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                checkValid(stack);
                int number1 = stack.pop();
                int number2 = stack.pop();
                stack.push(number1 + number2);
            }
            else if (tokens[i].equals("-")) {
                checkValid(stack);
                int number1 = stack.pop();
                int number2 = stack.pop();
                stack.push(number2 - number1);
            }
            else if (tokens[i].equals("*")) {
                checkValid(stack);
                int number1 = stack.pop();
                int number2 = stack.pop();
                stack.push(number1 * number2);
            }
            else if (tokens[i].equals("/")) {
                checkValid(stack);
                int number1 = stack.pop();
                int number2 = stack.pop();
                stack.push(number2 / number1);
            }
            else if (tokens[i].equals("!")) {
                if (stack.size() < 1) {
                    throw new IllegalArgumentException("Invalid input.\n");
                }
                int number = stack.pop();
                int result = 1;
                while (number > 0) {
                    result *= number;
                    number--;
                }
                stack.push(result);
            }
            else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        if (stack.size() != 1) {
            throw new IllegalArgumentException("The input in not valid.\n");
        }
        return stack.pop();
    }

    private void checkValid(Stack<Integer> stack) {
        if (stack.size() < 2) {
            throw new IllegalArgumentException("The input in not valid.\n");

        }

    }

}
