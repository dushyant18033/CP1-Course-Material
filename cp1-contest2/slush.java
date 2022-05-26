import java.util.*;



class Main
{
	static int[] h,freq;
	static int size;

	static void swap(int i, int j)
	{
		int temp=h[i];
		h[i]=h[j];
		h[j]=temp;
	}

	static void insert(int el)
	{
		h[size++]=el;

		int i=size-1, j=(i-1)/2;

		while( i>0 && (freq[h[i]]>freq[h[j]]) )
		{
			swap(i,j);
			i=j;
			j=(i-1)/2;
		}
	}

	static int extract_max()
	{
		if(size<=0)
			return -1;

		int el=h[0];
		h[0]=h[--size];

		heapify(0);

		return el;
	}

	static void heapify(int i)
	{
		int n=size;

		while(i<(n+1)/2)
		{
			int max=i;
			if(2*i+1<n && freq[h[i]]<freq[h[2*i+1]])
				max=2*i+1;
			if(2*i+2<n && freq[h[max]]<freq[h[2*i+2]])
				max=2*i+2;

			if(max!=i)
				swap(max,i);
			else
				break;

			i++;
		}
	}



	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);

		int[] cust;

		int t=s.nextInt();

		for(int test=0; test<t; test++)
		{
			int n=s.nextInt();
			int m=s.nextInt();

			int money=0;

			size=m;
			h=new int[m];
			freq=new int[m];
			cust=new int[n];

			for(int i=0; i<m; i++)
			{
				h[i]=i;
				freq[i]=s.nextInt();
			}

			boolean fav=true;

			for(int i=0; i<n; i++)
			{
				int d=s.nextInt();
				int f=s.nextInt();
				int b=s.nextInt();

				if(freq[d-1]>0)
				{
					freq[d-1]-=1;
					//heapify(d-1);
					money+=f;
					cust[i]=d;

					fav=true;
				}
				else
				{
					if(fav)
					{
						fav=false;
						for(int j=(size-1)/2; j>=0; j--)
							heapify(j);
					}

					int ind=extract_max();

					freq[ind]-=1;
					cust[i]=ind+1;
					money+=b;
					
					if(freq[ind]>0)
						insert(ind);
				}

				/*for(int i1=0; i1<m; i1++)
				{
					System.out.print(freq[i1]+" ");
				}

				System.out.print(" - ");

				for(int i1=0; i1<m; i1++)
				{
					System.out.print(h[i1]+" ");
				}
				System.out.println();*/
			}
			System.out.println(money);
			for(int i=0; i<n; i++)
				System.out.print(cust[i]+" ");
		}
	}
}