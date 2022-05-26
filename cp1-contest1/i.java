import java.util.*;

public class i
{
	static int[] ml;

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);

		ml=new int[100000];
		int size=100000;

		int c=0;
		int i=0;
		int j=0;

		while(c<size)
		{
			j=0;
			while(c<size && j<=i)
			{
				ml[c++]=(i*i)+(j*j);
				j++;
			}
			i++;
		}



		int t=s.nextInt();
/*
		for(int abc=0; abc<t; abc++)
		{
			int n=s.nextInt();
			System.out.println(ml[n-1]);
		}*/

		for(int a=0; a<t; a++)
			System.out.println(ml[a]);

	}
}