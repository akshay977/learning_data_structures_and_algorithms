package stacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class EvaluatePostfixNotation {
    static Integer evaluateRPN(String expr) {
        Deque<Integer> operands = new ArrayDeque<>();

        for (char ch : expr.toCharArray()) {
            if (Character.isDigit(ch)) {
                operands.push(ch - '0');
            } else {
                int val2 = operands.pop();
                int val1 = operands.pop();

                switch (ch) {
                    case '+':
                        operands.push(val1 + val2);
                        break;
                    case '-':
                        operands.push(val1 - val2);
                        break;
                    case '*':
                        operands.push(val1 * val2);
                        break;
                }
            }
        }

        return operands.peek();
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//
//        while (t-- > 0) {
//            int n = sc.nextInt();
//            sc.nextLine();
//            String s = sc.nextLine();
//            System.out.println(evaluateRPN(s));
//        }
        System.out.println(evaluateRPN("703*-9-"));
        System.out.println(evaluateRPN("27*"));
        System.out.println(evaluateRPN("04*3*0-"));
    }
}
