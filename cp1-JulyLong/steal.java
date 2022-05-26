import java.util.*;

class Main
{
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);

		int t=s.nextInt();

		for(int test=0; test<t; test++)
		{
			int n=s.nextInt();

			float[] a=new float[n];

			double mean=0;
			for(int i=0; i<n; i++)
			{
				a[i]=s.nextInt();
				mean+=a[i];
			}
			mean/=n;

			boolean found=false;

			//System.out.print(mean+" ");

			for(int i=0; i<n; i++)
				if(a[i]==mean)
				{
					System.out.println(i+1);
					found=true;
					break;
				}

			if(!found)
				System.out.println("Impossible");
		}
	}
}