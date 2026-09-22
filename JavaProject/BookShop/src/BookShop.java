package JavaProject.BookShop.src;
import java.util.Scanner;

public class BookShop {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] books = {
            "Java Programming",
            "Python Basics",
            "C++ Programming",
            "Data Structures",
            "Web Development"
        };

        double[] prices = {
            499.00,
            399.00,
            599.00,
            549.00,
            449.00
        };

        int[] cart = new int[books.length];

        boolean running = true;

        System.out.println("=================================");
        System.out.println("       WELCOME TO BOOK SHOP       ");
        System.out.println("=================================");

        while (running) {

            System.out.println("\n---------- MENU ----------");
            System.out.println("1. Show Books");
            System.out.println("2. Buy Book");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.println("--------------------------");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    showBooks(books, prices);
                    break;

                case 2:
                    showBooks(books, prices);

                    System.out.print("\nEnter book number: ");
                    int bookNumber = scanner.nextInt();

                    if (bookNumber >= 1 && bookNumber <= books.length) {

                        System.out.print("Enter quantity: ");
                        int quantity = scanner.nextInt();

                        if (quantity > 0) {

                            cart[bookNumber - 1] += quantity;

                            System.out.println(
                                quantity + " x "
                                + books[bookNumber - 1]
                                + " added to cart."
                            );

                        } else {
                            System.out.println("Quantity must be greater than 0.");
                        }

                    } else {
                        System.out.println("Invalid book number.");
                    }

                    break;

                case 3:
                    viewCart(books, prices, cart);
                    break;

                case 4:
                    checkout(books, prices, cart);
                    break;

                case 5:
                    running = false;
                    System.out.println("\nThank you for visiting Book Shop!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    // Display all books
    public static void showBooks(String[] books, double[] prices) {

        System.out.println("\n========== BOOKS ==========");

        for (int i = 0; i < books.length; i++) {

            System.out.println(
                (i + 1) + ". "
                + books[i]
                + " - ₹"
                + prices[i]
            );
        }
    }

    // Display shopping cart
    public static void viewCart(
            String[] books,
            double[] prices,
            int[] cart) {

        System.out.println("\n========== YOUR CART ==========");

        double total = 0;
        boolean empty = true;

        for (int i = 0; i < books.length; i++) {

            if (cart[i] > 0) {

                empty = false;

                double itemTotal = prices[i] * cart[i];

                System.out.println(
                    books[i]
                    + " x "
                    + cart[i]
                    + " = ₹"
                    + itemTotal
                );

                total += itemTotal;
            }
        }

        if (empty) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("------------------------------");
            System.out.println("Total: ₹" + total);
        }
    }

    // Checkout
    public static void checkout(
            String[] books,
            double[] prices,
            int[] cart) {

        double total = 0;
        boolean empty = true;

        System.out.println("\n========== CHECKOUT ==========");

        for (int i = 0; i < books.length; i++) {

            if (cart[i] > 0) {

                empty = false;

                double itemTotal = prices[i] * cart[i];

                System.out.println(
                    books[i]
                    + " x "
                    + cart[i]
                    + " = ₹"
                    + itemTotal
                );

                total += itemTotal;
            }
        }

        if (empty) {
            System.out.println("Your cart is empty.");
            return;
        }

        System.out.println("------------------------------");
        System.out.println("Total Amount: ₹" + total);

        System.out.print("Confirm purchase? (yes/no): ");
        Scanner scanner = new Scanner(System.in);

        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("yes")) {

            System.out.println("\nPurchase successful!");
            System.out.println("Thank you for shopping with us.");

            // Empty cart
            for (int i = 0; i < cart.length; i++) {
                cart[i] = 0;
            }

        } else {
            System.out.println("Purchase cancelled.");
        }
    }
}