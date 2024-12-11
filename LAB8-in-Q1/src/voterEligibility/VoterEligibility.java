package voterEligibility;

//User-defined exception class
class InvalidAgeException extends Exception {
 public InvalidAgeException(String message) {
     super(message);
 }
}

public class VoterEligibility {
 // Method to check eligibility
 public static void checkEligibility(int age) throws InvalidAgeException {
     if (age < 18) {
         throw new InvalidAgeException("VOTER IS NOT ELIGIBLE TO VOTE.");
     }
     System.out.println("VOTER IS ELIGIBLE TO VOTE.");
 }

 public static void main(String[] args) {
     try (java.util.Scanner sc = new java.util.Scanner(System.in)) {
         System.out.print("Enter age of the voter: ");
         int age = sc.nextInt();

         try {
             checkEligibility(age);
         } catch (InvalidAgeException e) {
             System.out.println("Exception: " + e.getMessage());
         }
     }
 }
}
