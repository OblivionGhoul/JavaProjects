import java.util.Stack;

class BinaryConverter {
        /**
         printBinary converts a decimal integer to its binary equivalent (and displays it to standard output).
         precondition: decimal > 0
         */
        public static void printBinary( int decimal ) {
            // Create stack to hold the integer values
            Stack<Integer> stack = new Stack<>();
            int remainder;
            // While decimal is not equal to 0
            while (decimal != 0) {
                // Find remainder when decimal is divided by 2
                remainder = decimal % 2;
                // Push the remainder onto the stack
                stack.push(remainder);
                // Divide the decimal by 2 and assign result to decimal
                decimal /= 2;
            }
            // While the stack is not empty
            while (!stack.isEmpty()) {
                // pop digit off top of stack and display
                System.out.print(stack.pop());
            }
        }
        public static void main(String[] a) {
            printBinary(10);
            printBinary(9);
            printBinary(8);
        }
}
