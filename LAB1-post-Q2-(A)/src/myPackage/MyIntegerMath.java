package myPackage;

public class MyIntegerMath 
{
	public long fact(int num)
	{
        long facto = 1;

        for (int i = 1; i <= num; i++)
        {
            facto *= i;
        }
        
        return facto;
	}
	
	public boolean isStrong(int num)
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

	
    public int countDigits(int n)
    {
        int c = 0;
        while (n != 0)
        {
            n = n/10;
            c++;
        }
        return c;
    }
    
    
    public boolean isArmstrong(int n)
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
