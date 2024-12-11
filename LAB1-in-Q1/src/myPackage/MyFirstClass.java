package myPackage;

public class MyFirstClass
{
	static int number = 2;

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
        while(n != 0)
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

}



