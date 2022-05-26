import java.util.*;

public class E
{
	static int n,m;
	static int[] t;
	static HashMap[] dp;

	static int recur(int ind, int s)
	{
		if(ind>=n)
			return s;

		if(dp[ind].containsKey(s))
			return (int)dp[ind].get(s);

		int maxSoFar=0;
		int min=Integer.MAX_VALUE;
		int limit=((ind+m)<n)?(ind+m):n;
		
		for(int i=ind; i<limit; i++)
		{
			if(t[i]>maxSoFar)
				maxSoFar=t[i];

			int find=recur(i+1,s+maxSoFar);
			if(find<min)
				min=find;
		}
		dp[ind].put(s,min);
		return min;
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);

		n=s.nextInt();
		m=s.nextInt();
		t=new int[n];

		dp=new HashMap[n];

		for(int i=0; i<n; i++)
		{
			t[i]=s.nextInt();
			dp[i]=new HashMap<Integer,Integer>();
		}

		System.out.println(recur(0,0));
	}
}