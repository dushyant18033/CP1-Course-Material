import java.util.*;

class ks1
{
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int ti=0; ti<t; ti++)
		{
			int n=s.nextInt();
			int[] a=new int[n];
			//xor=new int[n];

			for(int i=0; i<n; i++)
				a[i]=s.nextInt();

			int ctr=0;

			for(int i=0; i<n; i++)
			{
				int right=0;
				for(int j=i+1; j<n; j++)
				{
					right^=a[j];
					if(a[i]==right)
						ctr+=(j-i);
				}
			}

			System.out.println(ctr);
		}
	}
}