import java.util.*;

public class c
{
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);

		int t=s.nextInt();

		for(int test=0; test<t; test++)
		{
			long n=s.nextLong();
			
			long rootn=(long)Math.sqrt(n);

			int ctr=0;
			int[] a=new int[2];

			for(int j=2; j<=rootn; j++)
			{
				if(n%j==0)
				{
					if(ctr<2)
						a[ctr++]=j;
					else
					{
						ctr=0;
						break;
					}

					while(n%j==0)
						n/=j;
				}
			}
			//System.out.println(n);
			//System.out.println(a[0]);
			if(ctr==1 && n>1)
				System.out.println(a[0]+" "+n);
			else if(ctr==2 && n==1)
				System.out.println(a[0]+" "+a[1]);
			else
				System.out.println(-1);
		}
	}
}