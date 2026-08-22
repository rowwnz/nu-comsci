import java.util.Scanner;

public class BankingTransaction {

    public static void main(String[] args) {

        //Variables

        Scanner scanner = new Scanner(System.in);

        String accountHolder;
        String accountNumber;
        double initialBalance;
        char transactionType;
        double transactionAmount;
        double newBalance;

        System.out.println("================================================");
        System.out.println("             BANKING TRANSACTION                ");
        System.out.println("================================================");

        //Account Holder Name
        while (true) {
            System.out.print("Enter Account Holder Name: ");
            accountHolder = scanner.nextLine().trim();

            if (!accountHolder.isEmpty()) {
                break;
            }

         System.out.println("Invalid account holder name.");
            System.out.println("Name cannot be empty.");
        }
        
        //Account Number:

        while (true) { 
            System.out.print("Enter Account Number: ");
            accountNumber = scanner.nextLine().trim();

            if (!accountNumber.isEmpty()) {
                break;        
            }
        
            System.out.println("Invalid account number.");
            System.out.println("Account number cannot be empty.");
        
        }

       while (true) { 
         System.out.println("Enter Initial Balance: ");

         if (scanner.hasNextDouble()) {
            initialBalance = scanner.nextDouble();

              if (initialBalance >= 0) {
                    break;
                }

                System.out.println("Invalid balance.");
                System.out.println("Balance cannot be negative.");
            } else {
                System.out.println("Invalid numeric input.");
                System.out.println("Please enter a valid decimal value.");
                scanner.next();
            }

         }
         
          // Transaction Type
        while (true) {
            System.out.print("Enter Transaction Type (D/W): ");
            String input = scanner.next().trim().toUpperCase();

            if (input.equals("D") || input.equals("W")) {
                transactionType = input.charAt(0);
                break;
            }

            System.out.println("Invalid transaction type.");
            System.out.println("Please enter D for Deposit or W for Withdrawal.");
        }

         // Transaction Amount
        while (true) {
            System.out.print("Enter Transaction Amount: ");

            if (scanner.hasNextDouble()) {
                transactionAmount = scanner.nextDouble();

            if (transactionAmount >= 0) {
                if (transactionType == 'W' && transactionAmount > initialBalance) {
                    System.out.println("Invalid withdrawal.");
                    System.out.println("Withdrawal amount cannot be greater than the available balance.");
                    } else {
                    break;
                    }

            } else {
                System.out.println("Invalid transaction amount.");
                System.out.println("Transaction amount cannot be negative.");
            }

            } else {
                System.out.println("Invalid numeric input.");
                System.out.println("Please enter a valid decimal value.");
                scanner.next();
            }
        }

         // Calculate new balance
        if (transactionType == 'D') {
            newBalance = initialBalance + transactionAmount;
        } else {
            newBalance = initialBalance - transactionAmount;
        }

        String transactionName = (transactionType == 'D') ? "Deposit" : "Withdrawal";

        // Transaction Receipt
        System.out.println();
        System.out.println("================================================");
        System.out.println("             BANKING TRANSACTION");
        System.out.println("================================================");
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Account Number : " + accountNumber);
        System.out.println("------------------------------------------------");
        System.out.printf("Initial Balance: " + initialBalance);
          System.out.println("                                                ");
        System.out.printf("Transaction    : " + transactionName);
          System.out.println("                                                ");
        System.out.printf("Amount         : " + transactionAmount);
            System.out.println("                                                ");
        System.out.println("------------------------------------------------");
        System.out.printf("New Balance    : " + newBalance);
        System.out.println("                                                ");
        System.out.println("================================================");
        System.out.println("       TRANSACTION COMPLETED SUCCESSFULLY");
        System.out.println("================================================");

        scanner.close();
      
    }    
}


