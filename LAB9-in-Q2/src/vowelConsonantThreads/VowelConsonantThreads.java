package vowelConsonantThreads;

import java.util.Scanner;

//Thread to print vowels
class VowelThread extends Thread {
 private char[] letters;

 public VowelThread(char[] letters) {
     this.letters = letters;
 }

 @Override
 public void run() {
     System.out.println("Vowels:");
     for (char letter : letters) {
         if (isVowel(letter)) {
             System.out.print(letter + " ");
         }
     }
     System.out.println();
 }

 private boolean isVowel(char ch) {
     ch = Character.toLowerCase(ch);
     return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
 }
}

//Thread to print consonants
class ConsonantThread extends Thread {
 private char[] letters;

 public ConsonantThread(char[] letters) {
     this.letters = letters;
 }

 @Override
 public void run() {
     System.out.println("Consonants:");
     for (char letter : letters) {
         if (!isVowel(letter) && Character.isLetter(letter)) {
             System.out.print(letter + " ");
         }
     }
     System.out.println();
 }

 private boolean isVowel(char ch) {
     ch = Character.toLowerCase(ch);
     return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
 }
}

public class VowelConsonantThreads {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     char[] letters = new char[5];

     // Input letters
     System.out.println("Enter 5 alphabets:");
     for (int i = 0; i < letters.length; i++) {
         letters[i] = sc.next().charAt(0);
     }

     // Create threads
     VowelThread vowelThread = new VowelThread(letters);
     ConsonantThread consonantThread = new ConsonantThread(letters);

     // Start threads
     vowelThread.start();
     consonantThread.start();
 }
}
