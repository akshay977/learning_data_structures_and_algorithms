package stacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class InfixToPostfix {
    static int getPrecedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }

    static String infixToPostfix(String infix) {
        Deque<Character> operatorStack = new ArrayDeque<>();
        StringBuilder postfix = new StringBuilder();

        for (char ch: infix.toCharArray()) {
            int precedence = getPrecedence(ch);

            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch);
            } else if (ch == '(') {
                operatorStack.push(ch);
            } else if (ch == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfix.append(operatorStack.pop());
                }
                operatorStack.pop();
            } else {
                while (!operatorStack.isEmpty() && precedence <= getPrecedence(operatorStack.peek())) {
                    postfix.append(operatorStack.pop());
                }
                operatorStack.push(ch);
            }
        }

        while (!operatorStack.isEmpty()) {
            postfix.append(operatorStack.pop());
        }

        return postfix.toString();
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int t = scanner.nextInt();
//        scanner.nextLine();
//
//        while (t-- > 0) {
//            String infixExpression = scanner.nextLine();
//            String postfixExpression = infixToPostfix(infixExpression);
//            System.out.println(postfixExpression);
//        }

        String postFixExpression1 = infixToPostfix("(a+(b*c))");
        System.out.println(postFixExpression1);
        String postFixExpression2 = infixToPostfix("((a+b)*(z+x))");
        System.out.println(postFixExpression2);
        String postFixExpression3 = infixToPostfix("((a+t)*((b+(a+c))^(c+d)))");
        System.out.println(postFixExpression3);
    }
}
