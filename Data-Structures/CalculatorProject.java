import java.util.Scanner;
import java.util.EmptyStackException;
import java.util.LinkedList;

public class CalculatorProject {
    public static void main(String[] args) {
        Calculator test = new Calculator();
        Scanner in = new Scanner(System.in);
        String equation;

        do {
            System.out.println("\nEnter Equation (Press ENTER To Quit): ");
            equation = in.nextLine();

            if (!equation.equals("")) {
                System.out.println("Your Answer: " + test.evaluate(equation));
            }
        } while (!equation.equals(""));

        in.close();
    }
}

/**
 * Class for the calculator
 */
class Calculator {

    /**
     * Evaluates the equation
     * @param equation in reverse polish notation
     * @return the solved equation
     */
    public Integer evaluate(String equation) {
        String rpn = getRPN(equation);

        String[] arr = rpn.split(" ");
        Stack<Integer> operandStack = new Stack<>();

        for (String s : arr) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("^")) {
                int num1 = operandStack.pop();
                int num2 = operandStack.pop();

                switch (s) {
                    case "+" -> operandStack.push(num2 + num1);
                    case "-" -> operandStack.push(num2 - num1);
                    case "*" -> operandStack.push(num2 * num1);
                    case "/" -> operandStack.push(num2 / num1);
                    case "^" -> operandStack.push((int) Math.pow(num2, num1));
                }
            } else {
                try {
                    operandStack.push(Integer.parseInt(s));
                } catch (Exception e) {
                    System.out.println(("Invalid Input: " + e.getMessage()));
                    return null;
                }
            }
        }

        return operandStack.pop();
    }

    /**
     * Converts equation to reverse polish
     * @param equation given
     * @return equation in reverse polish notation
     */
    public String getRPN(String equation) {
        String[] arr = equation.split(" ");
        Stack<String> operationStack = new Stack<>();
        StringBuilder res = new StringBuilder();

        for (String s : arr) {
            switch (s) {
                case "+", "-", "/", "*", "^" -> {
                    if (!operationStack.isEmpty() && operationStack.peek().equals("(")) {
                        operationStack.push(s);
                        continue;
                    }

                    if (operationStack.isEmpty() || (precedenceLevel(s) > precedenceLevel(operationStack.peek()))) {
                        operationStack.push(s);
                    } else {
                        for (int i = 0; i <= operationStack.size(); i++) {
                            if (precedenceLevel(s) <= precedenceLevel(operationStack.peek())) {
                                res.append(operationStack.pop()).append(" ");
                            }
                        }
                        operationStack.push(s);
                    }
                }

                case "(" -> operationStack.push(s);

                case ")" -> {
                    while (!operationStack.peek().equals("(")) {
                        res.append(operationStack.pop()).append(" ");
                    }
                    operationStack.pop();
                }

                default -> res.append(s).append(" ");
            }
        }

        while (!operationStack.isEmpty()) {
            res.append(operationStack.pop()).append(" ");
        }

        return res.toString();
    }

    /**
     * @param op operation
     * @return the precedence level of operation
     */
    public int precedenceLevel(String op) {
        return switch (op) {
            case "+", "-" -> 0;
            case "*", "/" -> 1;
            case "^" -> 2;
            default -> throw new IllegalArgumentException("Operator unknown: " + op);
        };
    }
}

/**
 * Class for the stack made from LinkedLists
 * @param <E>
 */
class Stack<E> {
    private final LinkedList<E> stack;

    public Stack() {
        stack = new LinkedList<>();
    }

    /**
     * Checks if the stack is empty
     * @return boolean if the stack is empty
     */
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /**
     * Pushes to a stack
     * @param e The item to be pushed
     * @return The item pushed
     */
    public E push(E e) {
        stack.add(e);
        return e;
    }

    /**
     * Pops an item in the stack
     * @return the item removed
     */
    public E pop() {
        if (isEmpty()) throw new EmptyStackException();
        E o = stack.getLast();
        stack.removeLast();
        return o;
    }

    /**
     * Finds the top item in the stack
     * @return the top item in the stack
     */
    public E peek() {
        if (isEmpty()) throw new EmptyStackException();
        return stack.getLast();
    }

    /**
     * @return the number of items in the stack
     */
    public int size() {
        return stack.size();
    }
}