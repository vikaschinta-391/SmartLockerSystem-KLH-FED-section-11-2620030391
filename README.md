# SmartLockerSystem-KLH-FED-section-11-2620030391
Smart Locker System project 
Smart Locker System
A Java console-based application for managing parcel lockers.

📖 Overview
This project simulates a smart locker system for storing and retrieving student parcels. Each locker is assigned a random 4-digit access code, and the system tracks locker occupancy, parcel details, and storage duration.

✨ Features
Store Parcel – Assigns the next available locker, generates a random access code, and records student/parcel details.
Retrieve Parcel – Verifies the access code, calculates storage duration (including midnight wrap-around), and resets the locker.
View Locker Status – Displays the current state of all lockers (occupied or empty).
Dynamic Locker Expansion – Automatically creates a new locker when all existing ones are full.
🛠️ Technology
Language: Java
Dependencies: JDK standard library only (java.util) — no external libraries required.
🚀 Getting Started
Prerequisites
JDK 8 or later
Compile
bash

Copy
javac SmartLockerSystem.java
Run
bash

Copy
java SmartLockerSystem
📋 How It Works
1. Store a Parcel
The system finds the first empty locker. If none is available, a new one is created.
You enter the Student Name, Parcel ID, and Deposit Hour (0–23).
A random 4-digit access code is generated and displayed.
2. Retrieve a Parcel
You select the locker number and enter the access code.
If the code is correct, the parcel is delivered and the locker is reset to empty.
The system also calculates and displays how many hours the parcel was stored.
3. View Locker Status
Lists every locker and whether it is EMPTY or OCCUPIED (with student and parcel details).
📂 Project Structure
SmartLockerSystem.java   → Main class with menu, store, retrieve, and status logic
Locker                   → Inner class representing individual locker state
Both classes are defined in a single file for simplicity. Locker is a non-public class in the same file as SmartLockerSystem.

✏️ Author
Vikas
