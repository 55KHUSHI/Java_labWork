package myPackage;

import java.lang.Math;


public class MyClass
{
	static int number = 1;

	public static void main(String[] args) 
	{
		System.out.println("The factorial of " + number + " is: " + fact(number));
		
		if (isStrong(number))
		{
			System.out.println(number + " is a strong number");
		}
		else
		{
			System.out.println(number + " is not a strong number");
		}
		
		System.out.println(number + " consists of " + countDigits(number) + " digits");
		
		if (isArmstrong(number))
		{
			System.out.println(number + " is an armstrong number");
		}
		else
		{
			System.out.println(number + " is not an armstrong number");
		}
	}
	
	public static long fact(int num)
	{
        long facto = 1;

        for (int i = 1; i <= num; i++)
        {
            facto *= i;
        }
        
        return facto;
	}
	
	public static boolean isStrong(int num)
    {
        int n = num;
        long result = 0;
        while(n!=0)
        {
            int r = n%10;
            result = result + fact(r);
            n = n/10;
        }
        if (result == num)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

	
    public static int countDigits(int n)
    {
        int c = 0;
        while (n != 0)
        {
            n = n/10;
            c++;
        }
        return c;
    }
    
    
    public static boolean isArmstrong(int n)
    {
        int digits = countDigits(n);
        long result = 0;
        int x = n;
        while(n>0)
        {
            int r = n%10;
            result += Math.pow(r, digits);
            n /= 10;
        }
        if (result == x)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

}



