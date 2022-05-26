import java.util.*;

public class E
{
	static int[] evens;
	static int[] a;

	static int constructTree(int l, int r, int ind)
	{
		if(l>r)
			return 0;
		if(l==r)
		{
			evens[ind]=1;
			return evens[ind];
		}
		else
		{
			int mid=(l+r)/2;

			int evensLeft=constructTree(l,mid,2*ind+1);

			int evensRight=constructTree(mid+1,r,2*ind+2);

			evens[ind]=evensLeft+evensRight;

			return evens[ind];
		}
	}

	static int getEvensInRange(int ql, int qr, int curl, int curr, int ind)
	{
		if(ql<=curl && curr<=qr)
			return evens[ind];

		if(curl>qr || curr<ql)
			return 0;

		int mid=(curl+curr)/2;

		return getEvensInRange(ql,qr, curl,mid, 2*ind+1) + getEvensInRange(ql,qr, mid+1,curr, 2*ind+2);
	}

	static void update(int l, int r, int ind, int i, int inc)
	{
		if(i<l || i>r)
			return;

		evens[ind]+=inc;

		if(l!=r)
		{
			int mid=(l+r)/2;

			update(l,mid,2*ind+1,i, inc);
			update(mid+1,r,2*ind+2,i, inc);
		}
	}

	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int q=s.nextInt();

		a=new int[n];

		int h=1+(int)Math.ceil(Math.log(n)/Math.log(2));
		int size=(int)Math.pow(2,h)-1;
		evens=new int[size];

		constructTree(0,n-1,0);

		for(int i=0; i<q; i++)
		{
			String str=s.next();
			char t=str.charAt(0);

			if(t=='a')
			{
				int ind=s.nextInt()-1;
				int x=s.nextInt();
				
				if(x%2!=0)
				{
					if(a[ind]%2==0)
						update(0,n-1,0,ind,-1);
					else
						update(0,n-1,0,ind,1);
				}
				a[ind]+=x;

				//System.out.println(t+" "+ind+" "+x);
			}
			else if(t=='q')
			{
				int l=s.nextInt()-1;
				int r=s.nextInt()-1;
				//System.out.println(t+" "+l+" "+r);
				System.out.println(getEvensInRange(l,r,0,n-1,0));
			}

		}


	}
}