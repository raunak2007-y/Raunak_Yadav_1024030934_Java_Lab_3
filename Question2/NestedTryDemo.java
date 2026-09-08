public class NestedTryDemo {
    public static void main(String[] args) {

        try {
            System.out.println("Outer try block");

            try {
                int a = 10 / 0;
            } catch (ArithmeticException e) {
                System.out.println("Inner catch: Division by zero");
            }

            int arr[] = {10, 20, 30};
            System.out.println(arr[5]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Outer catch: Array index out of bounds");
        }

        System.out.println("Program continues...");
    }
}
