import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class SymbolTableTester {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SymbolTable codeRunner = new SymbolTable();
        System.out.println("Welcome to the Java++ language! Enter \"QUIT\" or \"EXIT\" to exit and \"HELP\" for the command menu.");

        label:
        while (true) {
            System.out.println("\nEnter an expression: ");
            String input = in.nextLine();

            switch (input) {
                case "QUIT":
                case "EXIT":
                    System.out.println("Goodbye!");
                    break label;
                case "HELP":
                    System.out.println("Use \"VARS\" to view variable list, (var varName = value) to declare variables and (print value + value) to print.");
                    System.out.println("Use quotes for strings and add correct spacing for math expressions.");
                    break;
                case "VARS":
                    codeRunner.printSymbolTable();
                    break;
                default:
                    try {
                        codeRunner.evaluate(input);
                    } catch (Exception e) {
                        System.out.println("Error: Invalid Input: " + input + "\nUse \"HELP\" to get help.");
                    }
                    break;
            }
        }

        in.close();
    }
}

/**
 * SymbolTable class
 */
class SymbolTable {
    Map<String, Object> symbolTable;

    public SymbolTable() {
        symbolTable = new HashMap<>();
    }

    /**
     * Evaluates the expression
     * Checks for vars and adds them to the symbol table
     * Checks for math expressions and evaluates them
     * @param expression given expression
     */
    public void evaluate(String expression) {
        String command = expression.substring(0, expression.indexOf(" "));
        String statement = findVars(expression.substring(expression.indexOf(" ") + 1));
        boolean isString = isString(statement);
        Calculator calc = new Calculator();

        switch (command) {
            case "var" -> {
                String varName = statement.substring(0, statement.indexOf(" "));

                if (isString && statement.contains("+")) {
                    symbolTable.put(varName, statement.substring(statement.indexOf("=") + 1).replace("\"", "").replace(" + ", "").trim());
                } else if (isString) {
                    symbolTable.put(varName, statement.substring(statement.indexOf("=") + 1));
                } else {
                    String equation = statement.substring(statement.indexOf("=") + 1).trim();
                    symbolTable.put(varName, calc.evaluate(equation));
                }
                System.out.println("OK");
            }
            case "print" -> {
                if (isString && statement.contains("+")) {
                    String res = findVars(statement);
                    System.out.println(res.replace("\"", "").replace(" + ", ""));
                } else if (isString) {
                    System.out.println(formatString(statement));
                } else if (symbolTable.containsKey(statement)) {
                    if (isString(symbolTable.get(statement).toString())) {
                        System.out.println(formatString(symbolTable.get(statement).toString()));
                    } else {
                        System.out.println(symbolTable.get(statement));
                    }
                } else {
                    String newStatement = findVars(statement);
                    if (isString(newStatement)) {
                        StringBuilder res = new StringBuilder();
                        while (newStatement.contains("\"")) {
                            try {
                                res.append(formatString(newStatement.substring(0, newStatement.indexOf("+"))));
                            } catch (Exception e) {
                                res.append(formatString(newStatement));
                                break;
                            }
                            newStatement = newStatement.substring(newStatement.indexOf("+") + 1);
                        }
                        System.out.println(res);
                    } else {
                        System.out.println(calc.evaluate(newStatement));
                    }
                }
            } 
            default -> System.out.println("Invalid Command! Use \"HELP\" to get help.");
        }
    }

    /**
     * Formats the given string
     * @param expression given string
     * @return the formatted string
     */
    public String formatString(String expression) {
        int start = expression.indexOf("\"");
        int end = expression.indexOf("\"", start + 1);
        return expression.substring(start + 1, end);
    }

    /**
     * Finds vars in the expression
     * Replaces the vars with their values
     * @param statement given expression
     * @return the expression with replaced vars
     */
    public String findVars(String statement) {
        String[] arr = statement.split(" ");
        Integer index = null;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].contains("=")) {
                index = i;
                break;
            }
        }
        if (index == null) index = 0;
        for (int i = index; i < arr.length; i++) {
            if (symbolTable.containsKey(arr[i])) {
                arr[i] = symbolTable.get(arr[i]).toString();
            }
        }
        return String.join(" ", arr);
    }

    /**
     * Checks if the given string is a string by checking if it contains "
     * @param expression given string
     * @return true if the string is a string, false otherwise
     */
    public boolean isString(String expression) {
        return expression.contains("\"");
    }

    /**
     * Prints out the symbol table
     */
    public void printSymbolTable() {
        symbolTable.forEach((key, value) -> System.out.println(key + " = " + value));
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