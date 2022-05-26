import java.util.Scanner;

class Main
{
	public static void main(String[] args) {
		int[][] mat;
		int n,t;

		Scanner s=new Scanner(System.in);

		t=s.nextInt();
		for(int ti=0; ti<t; ti++)
		{
			n=s.nextInt();

			mat=new int[n][n];

			for(int i=n-1,j=0; j<n; i--, j++)
				mat[i][j]=1;

			int up=n-1;//row
			int dn=0;//col

			int ind=0;
			int[] inc = new int[]{1, 2, 4, 5, 8, 10, 14, 21, 15, 16};

			for(int count=0; count<10; count++)
			{
				up-=inc[count];
				//ind++;

				if(up>=0)
					for(int i=up,j=0; i>=0; i--,j++)
						mat[i][j]=1;
				/*
				dn+=inc[ind];
				ind++;

				if(dn<n)
					for(int i=n-1,j=dn; j<n; i--,j++)
						mat[i][j]=1;
				*/
			}


			int ctr=0;
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<n; j++)
				{
					if(mat[i][j]==1)
					{
						ctr++;
						System.out.print('o');
					}
					else
						System.out.print('.');
				}
				System.out.print("\n");
			}
			System.out.println(ctr);
		}

	}
}