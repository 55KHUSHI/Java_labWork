package myPackage;

public class MyFirstClass 
{

    public static void main(String[] args) 
    {
        int number = 5; 
        long facto = 1;

        for (int i = 1; i <= number; i++) 
        {
            facto *= i;
        }

        System.out.println("The factorial of " + number + " is: " + facto);
    }
}

