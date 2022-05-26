import java.util.*;

public class chemical
{
	static ArrayList[] edges;
	static boolean[] visited;
	static int[] dist;

	static void BFS(int s, int n)
	{
		LinkedList<Integer> q=new LinkedList<Integer>();	//Queue
		q.add(s-1);
		visited[s-1]=true;

		dist[s-1]=0;

		while(!q.isEmpty())
		{
			int u=q.poll();

			//System.out.print((u+1)+" ");

			for(int j=0; j<edges[u].size(); j++)
			{
				int v=(int)edges[u].get(j);

				if(!visited[v])
				{
					q.add(v);
					visited[v]=true;
					dist[v]=dist[u]+1;
				}
			}
			//System.out.println(q);
		}
	}
	
	static void addEdge(int i, int j)	//i--->j
	{
		edges[i-1].add(j-1);
		edges[j-1].add(i-1);
	}

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);

		int n=s.nextInt();
		int m=s.nextInt();

		int A=s.nextInt();
		int B=s.nextInt();

		edges=new ArrayList[n];
		visited=new boolean[n];
		dist=new int[n];

		for(int i=0; i<n; i++)
		{
			visited[i]=false;
			edges[i]=new ArrayList<Integer>();
		}

		for(int i=0; i<m; i++)
		{
			int a=s.nextInt();
			int b=s.nextInt();
			addEdge(a,b);
		}

		BFS(A,n);
		int[] distA=dist;

		System.out.println();

		visited=new boolean[n];
		dist=new int[n];

		BFS(B,n);

		int[] distB=dist;

		int ctr=0;

		for(int i=0; i<n; i++)
		{
			if(distA[i]==distB[i] && (distA[i]+distB[i]!=0))
				ctr++;
		}

		if(A==B)
			ctr++;

		System.out.println(ctr);

	}
}