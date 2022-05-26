import java.util.*;

public class e
{
	static int[] money;
	static int[] dist;

	static int[] h;//Indices
	static int n;

	static void swap(int i, int j)
	{
		int temp=h[i];
		h[i]=h[j];
		h[j]=temp;
	}

	static boolean lessThan(int i, int j)//[i]<[j]
	{
		if(money[h[i]]!=money[h[j]])
			return money[h[i]]<money[h[j]];
		else
			return dist[h[i]]<dist[h[j]];
	}

	static void update()
	{
		money[h[0]]++;
		heapify(0);
	}

	static void heapify(int i)
	{
		while(i<(n+1)/2)
		{
			int min=i;
			if(2*i+1<n && lessThan(2*i+1,i))
				min=2*i+1;
			if(2*i+2<n && lessThan(2*i+2,min))
				min=2*i+2;

			if(min!=i)
			{
				swap(i,min);
			}
			else
				break;

			i++;
		}
	}

	

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);

		n=s.nextInt();
		int k=s.nextInt();

		h=new int[n];
		money=new int[n];
		dist=new int[n];

		for(int i=0; i<n; i++)
		{
			money[i]=s.nextInt();
			dist[i]=i+1;
			h[i]=i;
		}

		for(int i=(n-1)/2; i>=0; i--)
			heapify(i);

		for(int i=0; i<k; i++)
			update();

		int[] ans=new int[n];

		for(int i=0; i<n; i++)
		{
			ans[h[i]]=money[h[i]];
		}

		for(int i=0; i<n; i++)
			System.out.print(ans[i]+" ");
	}
}