public class ExceptionDemo {
    public static void main(String[] args) {

        // ArithmeticException
        try {
            int a = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException: " + e.getMessage());
        }

        // NullPointerException
        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: " + e.getMessage());
        }

        // ArrayIndexOutOfBoundsException
        try {
            int arr[] = {10, 20, 30};
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException: " + e.getMessage());
        }

        // NumberFormatException
        try {
            int num = Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: " + e.getMessage());
        }
    }
}
