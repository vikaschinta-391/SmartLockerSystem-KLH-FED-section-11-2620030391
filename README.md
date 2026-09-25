Smart Locker System
A robust, console-based Java application designed to simulate a real-world parcel locker management system. This project handles parcel storage, retrieval, and status tracking using dynamic access codes and duration calculation logic.

Built by Vikas
Java | Console Application | Object-Oriented Design

📖 Project Overview
The Smart Locker System is a Java console application that simulates the functionality of smart parcel lockers often found in universities, offices, and apartment complexes. It allows students or users to store parcels in assigned lockers and retrieve them using a secure, randomly generated 4-digit access code.

The system features:

Dynamic Parcel Management: Store and retrieve parcels with detailed tracking.
Security: Each parcel is assigned a unique random 4-digit OTP (One-Time Password).
Time Tracking: Automatically calculates the storage duration, handling complex scenarios like midnight wrap-around (e.g., depositing at 23:00 and retrieving at 01:00).
Status Monitoring: Real-time view of all locker states (Occupied/Empty).
Validation: Input validation for hours, access codes, and user choices.
Note: The current version is configured with 5 physical lockers. When a user attempts to store a parcel in a full system, the system currently prompts for retrieval (future updates may include dynamic expansion).

✨ Key Features
1. 📦 Store Parcel
Automatically finds the first available empty locker.
Collects user details: Student Name, Parcel ID, and Deposit Hour.
Validates that the deposit hour is within the 24-hour format (0–23).
Generates a random 4-digit access code for security.
Displays locker assignment and access code to the user.
2. 🔓 Retrieve Parcel
OTP Verification: Requires the correct 4-digit access code to proceed.
Duration Calculation: Calculates the exact number of hours the parcel was stored.
Smart Logic: Handles midnight wrap-around (e.g., if deposited at 22:00 and retrieved at 02:00, storage time is 4 hours).
Reset Mechanism: Automatically clears the locker data and marks it as empty after successful retrieval.
Security Feedback: Provides clear "Access Denied" messages for incorrect OTPs.
3. 📊 View Locker Status
Displays a comprehensive list of all 5 lockers.
Shows Occupied lockers with details:
Locker ID
Parcel ID
Owner (Student Name)
Shows Empty lockers.
Provides a summary count of occupied vs. total lockers.
4. 🛡️ Input Validation
Ensures all numeric inputs (choices, hours, OTPs) are valid integers.
Validates that hours entered are between 0 and 23.
Handles invalid menu choices gracefully with user-friendly error messages.
🛠️ Technology Stack
Language: Java (JDK 8 or later)
Dependencies: None (Uses only standard Java libraries: java.util.Scanner, java.util.Random)
Architecture: Object-Oriented Programming (OOP) with a main controller class (SmartLockerSystem) and a data model class (Locker).
🚀 Getting Started
Prerequisites
Java Development Kit (JDK): Version 8 or higher
Environment: Any terminal or command prompt
Installation & Compilation
Navigate to the project directory:

bash

Copy
cd SmartLockerSystem-KLH-FED-section-11-2620030391
Compile the Java source file:

bash

Copy
javac SmartLockerSystem.java
This will generate SmartLockerSystem.class and Locker.class.

Run the application:

bash

Copy
java SmartLockerSystem
📋 How It Works
Menu Interface
The application runs in a loop, presenting a main menu:

##################################
Welcome to Smart Locker System
~~~~~~~~~~ by Vikas
##################################
1. Store Parcel
2. Retrieve Parcel
3. View Locker Status
4. Exit
Enter your choice: 
Store a Parcel
Select Option 1.
Enter Student Name (e.g., "John Doe").
Enter Parcel ID (e.g., "PKG-123").
Enter Deposit Hour (0–23).
The system assigns a locker and displays the Access Code.
Retrieve a Parcel
Select Option 2.
Enter the 4-digit OTP provided during storage.
Enter the Current Hour (0–23).
If the OTP is correct, the system:
Confirms the password.
Calculates and displays storage duration.
Shows parcel details.
Clears the locker.
View Status
Select Option 3.
Review the list of all lockers and their current occupancy status.
📂 Project Structure
The project consists of a single file for simplicity, containing two classes:

SmartLockerSystem
public
The main class containing the main() method, menu loop, and business logic for storing, retrieving, and viewing lockers.
Locker
class
An inner/non-public class that models a single physical locker. It holds state (ID, occupancy, student name, parcel ID, deposit hour, access code) and methods for storing/retrieving parcels.
Class Diagram (Logical)
SmartLockerSystem
├── + main(String[]): void
├── + storeParcel(Scanner): void
├── + retrieveParcel(Scanner): void
├── + viewStatus(): void
└── - lockers: Locker[] (Array of 5 Lockers)

Locker
├── - id: int
├── - isOccupied: boolean
├── - studentName: String
├── - parcelID: String
├── - depositHour: int
├── - accessCode: int
├── + storeParcel(...): void
├── + retrieveParcel(int): int
├── + clear(): void
└── + Getters: getId(), isOccupied(), etc.
💡 Code Highlights
Dynamic Access Code Generation
Each parcel is assigned a unique 4-digit code using Java's Random class:

java

Copy
int accessCode = 1000 + random.nextInt(9000);
This ensures codes range from 1000 to 9999.

Midnight Wrap-Around Calculation
The retrieveParcel method in the Locker class calculates storage time, accounting for cases where the pickup hour is less than the deposit hour (indicating midnight crossing):

java

Copy
// Logic in Locker.java
int hoursStored;
if (currentHour >= depositHour) {
    hoursStored = currentHour - depositHour;
} else {
    hoursStored = (24 - depositHour) + currentHour;
}
return hoursStored;
Input Validation
The system uses Scanner methods to prevent crashes from invalid input:

java

Copy
if (!scanner.hasNextInt()) {
    System.out.println("Invalid input. Please enter a number.");
    scanner.next(); // Clear invalid input
    continue;
}
🧪 Example Usage Scenario
Step 1: Store a Parcel
1. Store Parcel
Enter Student Name: Alice Smith
Enter parcel ID: PARCEL-001
Enter Deposit Hour: 14

✓ Parcel stored successfully!
Assigned to Locker #1
[info] Your generated access code is: 4821
Step 2: View Status
3. View Locker Status

========== LOCKER STATUS ==========
Total Lockers: 5
Occupied: 1/5
Locker #1: OCCUPIED (ID: PARCEL-001, Owner: Alice Smith)
Locker #2: EMPTY
Locker #3: EMPTY
Locker #4: EMPTY
Locker #5: EMPTY
Step 3: Retrieve a Parcel (Next Day)
2. Retrieve Parcel
Enter OTP: 4821
Enter Current Hour (0-23): 10

✓ Password Correct!
Parcel delivered to: Alice Smith
Parcel ID: PARCEL-001
Stored for: 20 hours
Retrieved from Locker #1
Calculation: 14:00 to 24:00 (10 hours) + 00:00 to 10:00 (10 hours) = 20 hours total.

🔮 Future Enhancements
Dynamic Locker Expansion: Automatically create a new locker when all 5 are full (as mentioned in original specs).
Persistent Storage: Save locker data to a file or database so data persists after application restart.
User Authentication: Add login functionality for students.
Graphical User Interface (GUI): Convert the console app to a JavaFX or Swing application.
Parcel Expiry: Add notifications for parcels stored beyond a certain duration.
📄 License
This project is open-source and available for educational purposes.

👨‍💻 Author
Vikas
Java Developer

For questions or feedback, please open an issue in the repository.

🙏 Acknowledgments
Built using visual studio code and my brain
Inspired by real-world smart locker systems in educational institutions .
