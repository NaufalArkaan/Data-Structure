import java.util.Scanner;
import java.util.Stack;

public class Task1_InfixPostfix {
    static int precedence(char operator) {
        if (operator == '+' || operator == '-') return 1;
        if (operator == '*' || operator == '/') return 2;
        return 0;
    }

    static String infixToPostfix(String infix) {

        Stack<Character> stack = new Stack<>();
        String postfix = "";

        for (int i = 0; i < infix.length(); i++) {

            char c = infix.charAt(i);

            if (Character.isDigit(c)) {
                postfix += c + " ";
            }

            else if (c == '(') {
                stack.push(c);
            }

            else if (c == ')') {

                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix += stack.pop() + " ";
                }

                stack.pop();
            }

            else if (c == '+' || c == '-' || c == '*' || c == '/') {

                while (!stack.isEmpty() &&
                        precedence(stack.peek()) >= precedence(c)) {

                    postfix += stack.pop() + " ";
                }

                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix += stack.pop() + " ";
        }

        return postfix;
    }

    static double evaluatePostfix(String postfix) {

        Stack<Double> stack = new Stack<>();
        String[] tokens = postfix.split(" ");

        for (String token : tokens) {

            if (token.length() == 0) continue;

            if (Character.isDigit(token.charAt(0))) {

                stack.push(Double.parseDouble(token));
            }

            else {

                double b = stack.pop();
                double a = stack.pop();

                switch (token) {

                    case "+":
                        stack.push(a + b);
                        break;

                    case "-":
                        stack.push(a - b);
                        break;

                    case "*":
                        stack.push(a * b);
                        break;

                    case "/":
                        stack.push(a / b);
                        break;
                }
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan ekspresi infix: ");
        String infix = input.nextLine();

        String postfix = infixToPostfix(infix);

        double result = evaluatePostfix(postfix);

        System.out.println("Infix   : " + infix);
        System.out.println("Postfix : " + postfix);
        System.out.println("Result  : " + result);
    }
}