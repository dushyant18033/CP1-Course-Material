import java.util.Scanner;

class Main
{
	static long[] dp;
	static void train()
	{
		dp=new long[1000002];
		dp[0]=0;
		dp[1]=1;

		for(int i=2; i<1000002; i++)
		{
			long temp=i*dp[i-1];
			dp[i]=temp%1000000007;
		}
	}
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);

		int t=s.nextInt();

/*		for(int i=0; i<t; i++)
		{
			long n=s.nextInt();

			long y=n;

			for(long x=n-1; x>0; x--)
			{
				y=x+y+x*y;
			}

			System.out.println(y%1000000007);
		}
*/
		train();

		for(int i=0; i<t; i++)
		{
			int n=s.nextInt();
			
			/*BigInteger ans=new BigInteger("1");

			for(long j=n+1; j>1; j--)
				ans=ans.multiply(BigInteger.valueOf(j));
			*/
			System.out.println(dp[n+1]-1);
		}
	}
}