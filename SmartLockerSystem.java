import java.util.Scanner;
import java.util.Random;

public class SmartLockerSystem{
  //array to hold 5 lockers 
  static Locker[] lockers = new Locker[5];
  static random = new Random();

  public static void main(String[] args) {
        // Initialize the 5 lockers
        for (int i = 0; i < lockers.length; i++) {
            lockers[i] = new Locker(i + 1);
        }
     Scanner scanner = new Scanner(System.in);
        int choice;

  do {
            // Display Menu
            System.out.println("##################################");
            System.out.println("Welcome to Smart Locker System");
            System.out.println("~~~~~~~~~~ by Vikas");
            System.out.println("##################################");
            System.out.println("1. Store Parcel");
            System.out.println("2. Retrieve Parcel");
            System.out.println("3. View Locker Status");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
    
    if(!Scanner.hasNextInt()){
      System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
                continue;
            }

     choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    storeParcel(scanner);
                    break;
                case 2:
                    retrieveParcel(scanner);
                    break;
                case 3:
                    viewStatus();
                    break;
                case 4:
                    System.out.println("\nThank you for using SLM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1-4.");
            }
    System.out.println();
  }while (choise != 4);

  Scanner.close();
}
  // Method to Store Parcel
    static void storeParcel(Scanner scanner) {
        // Find an empty locker
        Locker availableLocker = null;
        for (Locker locker : lockers) {
            if (!locker.isOccupied()) {
                availableLocker = locker;
                break;
            }
        }
      if (availableLocker == null) {
            System.out.println("\n✗ Error: All 5 lockers are currently occupied. Please retrieve a parcel first.");
            return;
        }
      
  
