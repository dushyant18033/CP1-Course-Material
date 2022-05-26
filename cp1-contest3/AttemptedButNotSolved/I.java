import java.util.*;

public class I
{
	static int[] power;
	static int[] parent;
	static int[] rank;
	static int n;

	static int calc(int ind, int x)
	{
		int ctr=0;

		for(int i=0; i<n; i++)
		{
			if(parent[i]==ind)
			{
				if(power[i]<=x)
					ctr++;
				ctr+=calc(i,x);
			}
		}

		return ctr;
	}

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);

		n=s.nextInt();
		
		power=new int[n];
		parent=new int[n];
		rank=new int[n];

		parent[0]=-1;

		for(int i=0; i<n; i++)
		{
			rank[i]=1;
			power[i]=s.nextInt();
		}

		for(int i=0; i<n-1; i++)
		{
			int a=s.nextInt()-1;
			int b=s.nextInt()-1;

			if(b==0)
			{
				rank[b]+=rank[a];
				parent[a]=b;
			}
			else if(a==0)
			{
				rank[a]+=rank[b];
				parent[b]=a;
			}
			else if(rank[a]>=rank[b])
			{
				rank[a]+=rank[b];
				parent[b]=a;
			}
			else
			{
				rank[b]+=rank[a];
				parent[a]=b;				
			}
		}

		int q=s.nextInt();
		for(int i=0; i<q; i++)
		{
			int k=s.nextInt()-1;
			int x=s.nextInt();

			System.out.println(((power[k]<=x)?1:0)+calc(k,x));
		}
	}
}