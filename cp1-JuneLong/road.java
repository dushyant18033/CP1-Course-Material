import java.util.Scanner;

class road
{
	static int expo(int n) //x**n
	{
		if(n==0)
			return 1;
		if(n==1)
			return 2;

		if(n%2==0)
		{
			long a=expo(n/2)%1000000007;
			return (int)((a*a)%1000000007);
		}
		else
		{
			long a=expo(n/2)%1000000007;
			return (int)((2*((a*a)%1000000007))%1000000007);
		}
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);

		int t=s.nextInt();
		for(int i=0; i<t; i++)
		{
			int k=s.nextInt();

			System.out.println((5*expo(k))%1000000007);
		}
	}
}