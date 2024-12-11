package myPackage;

import myMathematics.MyIntegerMath;


public class MyDemo 
{
	static int number = 8;
	
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
		
		System.out.println(number + " consists of " + obj.countDigits(number) + " digits");
		
		if (obj.isArmstrong(number))
		{
			System.out.println(number + " is an armstrong number");
		}
		else
		{
			System.out.println(number + " is not an armstrong number");
		}
	}
	

}




