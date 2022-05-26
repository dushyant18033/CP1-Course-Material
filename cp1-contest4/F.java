import java.util.*;

public class F
{
	static ArrayList[] edges;
	static boolean[] visited;
	//static int[] dist;
	static int[] parent;
	static int[][] nums;

	static TrieADT[] bins;

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
					parent[v]=u;
					//bins[v].insert(u);
					//dist[v]=dist[u]+1;
				}
			}
		}
	}

	static void genBinaryNums(int n)
	{
		for(int j=0; j<n; j++)
		{
			int i=0;
			int num=j;
			while(num>0)
			{
				int rem=num%2;
				num/=2;
				nums[j][i++]=rem;
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
		parent=new int[n];
		//maxID=new int[n];
		bins=new TrieADT[n];
		nums=new int[n][32];

		for(int i=0; i<n; i++)
		{
			bins[i]=new TrieADT();
			edges[i]=new ArrayList<Integer>();
		}

		for(int i=1; i<n; i++)
		{
			int a=s.nextInt();
			int b=s.nextInt();
			edges[a].add(b);
		}	

		BFS(0,n);
		genBinaryNums(n);

		for(int i=1; i<n; i++)
		{
			int temp=i;
			while(temp>0)
			{
				bins[i].insert(nums[temp]);
				temp=parent[temp];
			}
			bins[i].insert(nums[0]);
		}

		for(int i=0; i<q; i++)
		{
			int x=s.nextInt();
			long k=s.nextLong();
			System.out.println(bins[x].findMinXor(k));
		}
	}
}

class Node
{
	Node[] children=new Node[2];
	boolean isLeaf;

	Node()
	{
		isLeaf=false;

		for(int i=0; i<2; i++)
			children[i]=null;
	}
}

class TrieADT
{
	Node root;

	TrieADT()
	{
		root=new Node();
	}

	void insert(int[] key)
	{
		
		Node temp=root;

		for(int i=31; i>=0; i--)
		{
			int ind=key[i];

			if(temp.children[ind]==null)
				temp.children[ind]=new Node();

			temp=temp.children[ind];
		}

		temp.isLeaf=true;
	}

	long findMinXor(long k)
	{
		int[] key=new int[32];
		int i=0;
		long num=k;
		while(num>0)
		{
			int rem=(int)(num%2);
			num/=2;
			key[i++]=rem;
		}

		long xor=0;
		Node temp=root;
		for(i=31; i>=0; i--)
		{
			int find=key[i];
			if(temp.children[find]!=null)
			{
				xor*=2;
				temp=temp.children[find];
			}
			else
			{
				temp=temp.children[1-find];
				xor=2*xor+1;
			}
		}
		return xor;
	}
}