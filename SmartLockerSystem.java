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
