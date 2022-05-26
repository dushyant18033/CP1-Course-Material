import java.util.*;

class Main
{
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		long[] a;

		long ans1=0, ans2=0;

		for(int test=0; test<t; test++)
		{
			int n=s.nextInt();
			a=new long[n];

			for(int i=0; i<n; i++)
				a[i]=s.nextInt();	
			
			int k=s.nextInt();
			long x=s.nextInt();

			if(k==n)
			{
				for(int i=0; i<n; i++)
				{
					ans1+=a[i];
					ans2+=(a[i]^x);
				}
				if(ans1>=ans2)
					System.out.println(ans1);
				else
					System.out.println(ans2);
			}
			else
			{
				int min=-1;
				long minDiff=Long.MAX_VALUE;
				for(int i=0; i<n; i++)
				{
					long b=x^a[i];
					
					//System.out.print(b+" ");/////////////

					long diff=Math.abs(a[i]-b);
					if(diff<minDiff)
					{
						min=i;
						minDiff=diff;
					}

					if(a[i]>=b)
						ans1+=a[i];
					else
						ans1+=b;
				}

				if(min!=-1)
					ans2=ans1-minDiff;
				//System.out.println(ans1+" "+minDiff+" "+ans2);
				
				if(k%2==0 &&(min!=-1))
					System.out.println(ans2);
				else
					System.out.println(ans1);
			}

		}
	}
}