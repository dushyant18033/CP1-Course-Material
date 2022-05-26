import java.util.*;

public class C
{
	static ArrayList[] edges;
	static boolean[] visited;
	//static int[] dist;
	//static int[] parent;

	static int[] maxID;

	static void BFS(int s, int n)
	{
		ArrayList<Integer> q=new ArrayList<Integer>();	//Queue
		q.add(s);
		visited[s]=true;

		while(!q.isEmpty())
		{
			int u=q.get(0);
			q.remove(0);

			for(int j=0; j<edges[u].size(); j++)
			{
				int v=(int)edges[u].get(j);

				if(!visited[v])
				{
					q.add(v);
					visited[v]=true;
					//parent[v]=u;
					maxID[v]=((v>=maxID[u])?v:maxID[u]);
					//dist[v]=dist[u]+1;
				}
			}
		}
	}
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);

		int n=s.nextInt()+1;
		int q=s.nextInt();
		
		edges=new ArrayList[n];
		visited=new boolean[n];
		//parent=new int[n];
		maxID=new int[n];

		for(int i=0; i<n; i++)
			edges[i]=new ArrayList<Integer>();

		for(int i=1; i<n; i++)
		{
			int a=s.nextInt();
			int b=s.nextInt();
			edges[a].add(b);
		}	

		BFS(0,n);

		for(int i=0; i<q; i++)
		{
			int x=s.nextInt();
			System.out.println(maxID[x]);
		}
	}
}