import java.util.Scanner;
import java.util.Random;

public class SmartLockerSystem{
  //array to hold 5 lockers 
  static Locker[] lockers = new Locker[5];
  static random random = new Random();

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
      System.out.println("Enter Student Name: ");
      string studentName = sc.nextline();
      System.out.println("Enter parcel ID: ");
      string parcelID = sc.nextline();
      System.out.println("Enter Deposit Hour: ");
      int depositHour = sc.nextInt();
      sc.nextline();
      // validate hours 

      if (depositHour < 0 || depositHour > 23) {
            System.out.println("✗ Invalid hour. Must be between 0 and 23.");
            return;
        }
      // gen a random 4 digit code
      int accessCode = 1000 + random.nextInt(9000);
      // store parcel id in the available locker
      availableLocker.storeParcel(studentName, parcelID, depositHour, accessCode);
      
      System.out.println("\n✓ Parcel stored successfully!");
      System.out.println("Assigned to Locker #" + availableLocker.getId());
      System.out.println("[info] Your generated access code is: " + accessCode);
    }

  // Method to Retrieve Parcel
    static void retrieveParcel(Scanner scanner) {
        // Check if any locker has a parcel
        boolean hasParcel = false;
        for (Locker locker : lockers) {
            if (locker.isOccupied()) {
                hasParcel = true;
                break;
            }
        }

      if(!hasParcel){
        System.out.println("Error: All lockers are empty. Nothing to retrieve. ");
        return;
      }

       System.out.print("Enter OTP: ");
        int enteredCode = scanner.nextInt();
        
        System.out.print("Enter Current Hour (0-23): ");
        int currentHour = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Validate hour
        if (currentHour < 0 || currentHour > 23) {
            System.out.println("✗ Invalid hour. Must be between 0-23.");
            return;
        }
       // Search all lockers for the matching code
        boolean found = false;
        for (Locker locker : lockers) {
            if (locker.isOccupied()) {
                if (locker.getAccessCode() == enteredCode) {
                    // Password Correct!
                    System.out.println("\n✓ Password Correct!");

                  //retrive and calculate hours
                  int hoursStored = locker.retrieveParcel(currentHour);
                    System.out.println("Parcel delivered to: " + locker.getStudentName());
                    System.out.println("Parcel ID: " + locker.getParcelID());
                    System.out.println("Stored for: " + hoursStored + " hours");
                    System.out.println("Retrieved from Locker #" + locker.getId());

                    found = true;
                    break; 
                }
            }
        }
      if (!found){
        System.out.println("Incorrect OTP! Access Denied");
        System.out.println("Parcel remains locked");
      }
    }
  //method to view status 
  static void viewStatus() {
        System.out.println("\n========== LOCKER STATUS ==========");
        System.out.println("Total Lockers: 5");

    int occupiedCount = 0;
        for (Locker locker : lockers) {
            if (locker.isOccupied()) {
                occupiedCount++;
            }
        }
    System.out.println("Occupied: " + occupiedcount + "/5");

    for (Locker locker : lockers) {
            if (locker.isOccupied()) {
                System.out.println("Locker #" + locker.getId() + ": OCCUPIED (ID: " + locker.getParcelID() + ", Owner: " + locker.getStudentName() + ")");
            } else {
                System.out.println("Locker #" + locker.getId() + ": EMPTY");
            }
        }
    }
}
// Locker class to represent a single physical locker
class Locker {
    private int id;
    private boolean isOccupied;
    private String studentName;
    private String parcelID;
    private int depositHour;
    private int accessCode;

    public Locker(int id) {
        this.id = id;
        this.isOccupied = false;
    }

    public void storeParcel(String studentName, String parcelID, int depositHour, int accessCode) {
        this.studentName = studentName;
        this.parcelID = parcelID;
        this.depositHour = depositHour;
        this.accessCode = accessCode;
        this.isOccupied = true;
    }

    public int retrieveParcel(int currentHour) {
        if (!isOccupied) return 0;
        
        int hoursStored = currentHour - depositHour;
        if (hoursStored < 0) {
            hoursStored += 24;
        }
        
        // Reset locker state
        this.isOccupied = false;
        this.studentName = "";
        this.parcelID = "";
        this.depositHour = 0;
        this.accessCode = 0;
        
        return hoursStored;
    }
    
    // Getters
    public int getId() { return id; }
    public boolean isOccupied() { return isOccupied; }
    public String getStudentName() { return studentName; }
    public String getParcelID() { return parcelID; }
    public int getDepositHour() { return depositHour; }
    public int getAccessCode() { return accessCode; }
}


    

      
  
