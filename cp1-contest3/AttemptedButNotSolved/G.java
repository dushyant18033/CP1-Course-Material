import java.util.*;

public class G
{
	static edge[] edges;
	static edge[] aux;
	static int[] parent;
	static int[] rank;
	static int n;
	static int m;

	static int mst()
	{
		int mstSum=0;
		int found=0;
		int c=0;

		while(found<n-1)
		{
			int u=edges[c].src;
			int v=edges[c].dest;

			int a=find(u);
			int b=find(v);

			if(a!=b)
			{
				found++;

				//edges[c].print();

				if(rank[a]<=rank[b])
				{
					parent[a]=b;
					rank[b]+=rank[a];
				}
				else
				{
					parent[b]=a;
					rank[a]+=rank[b];
				}				
				
				mstSum+=edges[c].weight;
			}
			c++;
		}

		return mstSum;
	}

	static int find(int i)
	{
		if(parent[i]<0)
			return i;
		else
		{
			int c=find(parent[i]);
			parent[i]=c;
			return c;
		}
	}

	static void merge(int beg, int mid, int end)
	{
		for(int i=beg; i<=end; i++)
			aux[i]=edges[i].copy();

		int i=beg;
		int j=mid+1;
		int k=beg;

		while(i<=mid && j<=end)
		{
			if(aux[i].weight<=aux[j].weight)
				edges[k++]=aux[i++];
			else
				edges[k++]=aux[j++];
		}

		while(i<=mid)
			edges[k++]=aux[i++];
		while(j<=end)
			edges[k++]=aux[j++];
	}

	static void mergeSort(int i, int j)
	{
		if(i<j)
		{
			int mid=(i+j)/2;

			mergeSort(i,mid);
			mergeSort(mid+1,j);

			merge(i,mid,j);
		}
	}

	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		m=n*(n-1)/2;
		
		parent=new int[n];
		rank=new int[n];


		edges=new edge[m];
		aux=new edge[m];

		int transf=Integer.MAX_VALUE;
		for(int i=0; i<n; i++)
		{
			parent[i]=-1;
			rank[i]=1;
			int cost=s.nextInt();
			if(cost<transf)
				transf=cost;
		}

		int k=0;

		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				int wt=s.nextInt();

				if(i>=j)
					continue;
				else
					edges[k++]=new edge(i,j,wt);
			}
		}

		mergeSort(0,m-1);

		System.out.println(mst()+transf);
	}
}


class edge
{
	int src;
	int dest;
	int weight;

	edge(int s, int d, int w)
	{
		src=s;
		dest=d;
		weight=w;
	}
	edge copy()
	{
		return new edge(this.src,this.dest,this.weight);
	}
	void print()
	{
		System.out.println(src+"->"+dest+" ="+weight);
	}
}