import java.util.Scanner;

class InvalidUsernameException extends Exception {
    public InvalidUsernameException(String message) {
        super(message);
    }
}

class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message) {
        super(message);
    }
}

class AccountLockedException extends Exception {
    public AccountLockedException(String message) {
        super(message);
    }
}

public class LoginSystem {

    static String correctUsername = "admin";
    static String correctPassword = "1234";

    static int attempts = 0;
    static final int MAX_ATTEMPTS = 3;

    static void login(String username, String password)
            throws InvalidUsernameException,
                   InvalidPasswordException,
                   AccountLockedException {

        if (attempts >= MAX_ATTEMPTS) {
            throw new AccountLockedException(
                "Account is locked"
            );
        }

        if (!username.equals(correctUsername)) {
            attempts++;
            throw new InvalidUsernameException(
                "Invalid username"
            );
        }

        if (!password.equals(correctPassword)) {
            attempts++;
            throw new InvalidPasswordException(
                "Invalid password"
            );
        }

        System.out.println("Login successful!");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (attempts < MAX_ATTEMPTS) {

            try {
                System.out.print("Enter username: ");
                String username = sc.nextLine();

                System.out.print("Enter password: ");
                String password = sc.nextLine();

                login(username, password);
                break;

            } catch (InvalidUsernameException e) {
                System.out.println(e.getMessage());

            } catch (InvalidPasswordException e) {
                System.out.println(e.getMessage());

            } catch (AccountLockedException e) {
                System.out.println(e.getMessage());
                break;

            } finally {
                System.out.println(
                    "Attempt: " + attempts + "/" + MAX_ATTEMPTS
                );
            }
        }

        if (attempts >= MAX_ATTEMPTS) {
            System.out.println("Account has been locked.");
        }

        sc.close();
    }
}
