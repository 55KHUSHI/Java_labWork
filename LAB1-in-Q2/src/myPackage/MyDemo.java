package myPackage;

public class MyDemo 
{
	static int number = 3;
	
	public static void main(String[] args) 
	{
		MyIntegerMath obj = new MyIntegerMath();
			
		System.out.println("The factorial of " + number + " is: " + obj.fact(number));
		
		if (obj.isStrong(number))
		{
			System.out.println(number + " is a strong number");
		}
		else
		{
			System.out.println(number + " is not a strong number");
		}

	}

}




