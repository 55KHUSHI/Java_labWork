package myMathematics;


public class MyIntegerMath 
{
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

}
