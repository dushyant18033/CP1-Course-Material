import java.util.Scanner;

public class p2
{
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);

		int n=s.nextInt();
		int a=s.nextInt();
		int b=s.nextInt();
		int c=s.nextInt();

		int n1=n/a, n2=n/b;

		int max=0;

		for(int i=0; i<=n1; i++)
		{
			for(int j=0; j<=n2; j++)
			{
				int cz=n-a*i-b*j;

				if(cz<0)
					break;
				if(cz%c==0)
				{
					int k=i+j+(cz/c);
					if(k > max)
						max=k;
				}
			}
		}

		System.out.println(max);
	}
}