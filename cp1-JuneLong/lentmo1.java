import java.util.*;

class Main
{
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		long[] a;

		for(int test=0; test<t; test++)
		{
			int n=s.nextInt();
			a=new long[n];

			for(int i=0; i<n; i++)
				a[i]=s.nextInt();	
			
			int k=s.nextInt();
			long x=s.nextInt();

			if(n==k)
			{
				long ans1=0,ans2=0;
				for(int i=0; i<n; i++)
				{
					long temp=a[i]^x;
					ans1+=a[i];
					ans2+=temp;
				}
				long ans=(ans1>=ans2)?ans1:ans2;
				System.out.println(ans);
			}
			else if(k%2!=0)
			{
				long sum=0;
				for(int i=0; i<n; i++)
				{
					long temp=a[i]^x;
					while(temp>a[i])
					{
						a[i]=temp;
						temp=temp^x;
					}
					sum+=a[i];
				}

				System.out.println(sum);
			}
			else
			{
				int ctr=0;
				for(int i=0; i<n; i++)
				{
					long temp=a[i]^x;
					if(temp>a[i])
						ctr++;
				}

				if(ctr%2==0)
				{
					long sum=0;
					for(int i=0; i<n; i++)
					{
						long temp=a[i]^x;
						while(temp>a[i])
						{
							a[i]=temp;
							temp=temp^x;
						}
						sum+=a[i];
					}

					System.out.println(sum);
				}
				else
				{
					long sum=0;
					long minDiff=Long.MAX_VALUE;

					for(int i=0; i<n; i++)
					{
						long temp=a[i]^x;
						while(temp>a[i])
						{
							a[i]=temp;
							temp=temp^x;
						}

						long diff=a[i]-temp;
						if(diff<minDiff)
							minDiff=diff;

						sum+=a[i];
					}

					sum-=minDiff;

					System.out.println(sum);
				}
			}
		}
	}
}