import java.util.*;

public class C
{
	static int[][] mat;
	static int v1;
	static boolean[] visited;
	static int n;

	static void DFS_Visit(int u)
	{
		visited[u]=true;
		if(u==v1)
			return;

		for(int v=0; v<n; v++)
		{
			if(mat[u][v]==1)
				if(!visited[v])
					DFS_Visit(v);
		}
	}
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);

		n=s.nextInt();
		int q=s.nextInt();

		mat=new int[n][n];

		for(int i=0; i<q; i++)
		{
			int t=s.nextInt();
			int u=s.nextInt()-1;
			v1=s.nextInt()-1;

			if(t==1)
			{
				mat[u][v1]=1;
				mat[v1][u]=1;
			}
			else if(t==2)
			{
				visited=new boolean[n];
				DFS_Visit(u);
				if(visited[v1])
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}
	}
}