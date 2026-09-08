import java.util.ArrayList;

class ShoppingException extends Exception {
    public ShoppingException(String message) {
        super(message);
    }
}

class ProductNotFoundException extends ShoppingException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}

class CartEmptyException extends ShoppingException {
    public CartEmptyException(String message) {
        super(message);
    }
}

class InvalidQuantityException extends ShoppingException {
    public InvalidQuantityException(String message) {
        super(message);
    }
}

class PaymentException extends ShoppingException {
    public PaymentException(String message) {
        super(message);
    }
}

class Product {

    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

public class ShoppingCart {

    static ArrayList<Product> products = new ArrayList<>();
    static ArrayList<Product> cart = new ArrayList<>();

    static Product searchProduct(int id)
            throws ProductNotFoundException {

        for (Product p : products) {
            if (p.id == id) {
                return p;
            }
        }

        throw new ProductNotFoundException(
            "Product not found"
        );
    }

    static void addProduct(int id, int quantity)
            throws ProductNotFoundException,
                   InvalidQuantityException {

        if (quantity <= 0) {
            throw new InvalidQuantityException(
                "Quantity must be greater than zero"
            );
        }

        Product p = searchProduct(id);

        for (int i = 0; i < quantity; i++) {
            cart.add(p);
        }

        System.out.println(
            p.name + " added to cart"
        );
    }

    static void removeProduct(int id)
            throws ProductNotFoundException {

        Product p = searchProduct(id);

        if (!cart.remove(p)) {
            throw new ProductNotFoundException(
                "Product is not in cart"
            );
        }

        System.out.println(
            p.name + " removed from cart"
        );
    }

    static double calculateTotal()
            throws CartEmptyException {

        if (cart.isEmpty()) {
            throw new CartEmptyException(
                "Cart is empty"
            );
        }

        double total = 0;

        for (Product p : cart) {
            total += p.price;
        }

        return total;
    }

    static void payment(double amount)
            throws PaymentException,
                   CartEmptyException {

        double total = calculateTotal();

        if (amount < total) {
            throw new PaymentException(
                "Insufficient payment"
            );
        }

        System.out.println(
            "Payment successful!"
        );
        System.out.println(
            "Total = Rs. " + total
        );
    }

    public static void main(String[] args) {

        products.add(
            new Product(101, "Laptop", 50000)
        );

        products.add(
            new Product(102, "Mouse", 1000)
        );

        products.add(
            new Product(103, "Keyboard", 2000)
        );

        try {

            addProduct(101, 1);
            addProduct(102, 2);

            System.out.println(
                "Cart Total = Rs. " + calculateTotal()
            );

            removeProduct(102);

            System.out.println(
                "New Cart Total = Rs. " + calculateTotal()
            );

            payment(60000);

        } catch (ProductNotFoundException e) {
            System.out.println(
                "Product Error: " + e.getMessage()
            );

        } catch (InvalidQuantityException e) {
            System.out.println(
                "Quantity Error: " + e.getMessage()
            );

        } catch (CartEmptyException e) {
            System.out.println(
                "Cart Error: " + e.getMessage()
            );

        } catch (PaymentException e) {
            System.out.println(
                "Payment Error: " + e.getMessage()
            );
        }
    }
}
