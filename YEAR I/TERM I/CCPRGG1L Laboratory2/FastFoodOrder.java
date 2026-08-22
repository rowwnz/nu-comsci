import java.util.Scanner;

public class FastFoodOrder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String customerName;
        int burgerQuantity;
        double burgerPrice;
        int friesQuantity;
        double friesPrice;
        int drinkQuantity;
        double drinkPrice;
        double discountPercentage;

        // Customer Name
        while (true) {
            System.out.print("Enter Customer Name: ");
            customerName = scanner.nextLine().trim();

            if (!customerName.isEmpty()) {
                break;
            }

            System.out.println("Invalid customer name.");
            System.out.println("Name cannot be empty.");
        }

        // Burger Quantity
        burgerQuantity = getValidQuantity(scanner, "Enter Burger Quantity: ");

        // Burger Price
        burgerPrice = getValidPrice(scanner, "Enter Burger Price: ");

        // Fries Quantity
        friesQuantity = getValidQuantity(scanner, "Enter Fries Quantity: ");

        // Fries Price
        friesPrice = getValidPrice(scanner, "Enter Fries Price: ");

        // Drink Quantity
        drinkQuantity = getValidQuantity(scanner, "Enter Drink Quantity: ");

        // Drink Price
        drinkPrice = getValidPrice(scanner, "Enter Drink Price: ");

        // Discount Percentage
        discountPercentage = getValidDiscount(scanner);

        // Calculate item totals
        double burgerTotal = burgerQuantity * burgerPrice;
        double friesTotal = friesQuantity * friesPrice;
        double drinkTotal = drinkQuantity * drinkPrice;

        // Calculate subtotal
        double subtotal = burgerTotal + friesTotal + drinkTotal;

        // Convert percentage to decimal rate
        double discountRate = discountPercentage / 100.0;

        // Calculate discount and final total
        double discountAmount = subtotal * discountRate;
        double finalTotal = subtotal - discountAmount;

        // Receipt
        System.out.println();
        System.out.println("================================================");
        System.out.println("              FAST FOOD RECEIPT");
        System.out.println("================================================");
        System.out.println("Customer: " + customerName);
        System.out.println();
        System.out.printf( "Item", "Qty", "Price", "Total");
        System.out.printf("%-15s %5d %10.2f %12.2f%n","Fries", friesQuantity, friesPrice, friesTotal);
        System.out.printf("%-15s %5d %10.2f %12.2f%n","Drink", drinkQuantity, drinkPrice, drinkTotal);
        System.out.println("------------------------------------------------");
        System.out.printf("%-25s %15.2f%n", "Subtotal:", subtotal);
        System.out.printf("%-25s %15.2f%n", "Discount:", discountAmount);
        System.out.println("------------------------------------------------");
        System.out.printf("%-25s %15.2f%n", "TOTAL AMOUNT:", finalTotal);
        System.out.println("================================================");
        System.out.println("       THANK YOU FOR YOUR ORDER!");
        System.out.println("================================================");

        scanner.close();
    }

    // Method for validating integer quantities
    public static int getValidQuantity(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);

            if (scanner.hasNextInt()) {
                int quantity = scanner.nextInt();

                if (quantity >= 0) {
                    return quantity;
                }

                System.out.println("Invalid quantity.");
                System.out.println("Quantity cannot be negative.");
            } else {
                System.out.println("Invalid numeric input.");
                System.out.println("Please enter a whole number.");
                scanner.next();
            }
        }
    }

    // Method for validating prices
    public static double getValidPrice(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);

            if (scanner.hasNextDouble()) {
                double price = scanner.nextDouble();

                if (price >= 0) {
                    return price;
                }

                System.out.println("Invalid price.");
                System.out.println("Price cannot be negative.");
            } else {
                System.out.println("Invalid numeric input.");
                System.out.println("Please enter a valid decimal value.");
                scanner.next();
            }
        }
    }

    // Method for validating discount percentage
    public static double getValidDiscount(Scanner scanner) {
        while (true) {
            System.out.print("Enter Discount Percentage: ");

            if (scanner.hasNextDouble()) {
                double discount = scanner.nextDouble();

                if (discount >= 0 && discount <= 100) {
                    return discount;
                }

                System.out.println("Invalid discount.");
                System.out.println("Discount must be between 0% and 100%.");
            } else {
                System.out.println("Invalid numeric input.");
                System.out.println("Please enter a valid decimal value.");
                scanner.next();
            }
        }
    }
}