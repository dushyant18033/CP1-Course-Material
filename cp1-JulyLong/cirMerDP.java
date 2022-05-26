import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/** Class for buffered reading int and double values */
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}
class Main
{
	static int[] nums;
	static long[][] dp;
	static long[] sums;

	static long recurDP(int l, int r)
	{
		if(l>=r)
			return 0;

		else if(dp[l][r]>0)
			return dp[l][r];

		else if(r-l==1)
		{
			dp[l][r]=nums[l]+nums[r];
			return dp[l][r];
		}
		
		else
		{
			long minSum=Long.MAX_VALUE;

			for(int k=l; k<r; k++)
			{
				long cur=recurDP(l,k)+recurDP(k+1,r);

				if(cur<minSum)
					minSum=cur;
			}

			if(l>0)
				dp[l][r]=minSum+(sums[r]-sums[l-1]);
			else
				dp[l][r]=minSum+sums[r];

			return dp[l][r];
		}
	}
	public static void main(String[] args) 
	{
		Reader s=new Reader();
		s.init(System.in);

		int t=0;
		try{t=s.nextInt();}
		catch(Exception e){}

		for(int test=0; test<t; test++)
		{
			int n=0;
			try{n=s.nextInt();}
			catch(Exception e){}

			int n2=2*n;
			nums=new int[n2];
			sums=new long[n2];

			for(int i=0; i<n; i++)
			{
				try{nums[i]=nums[i+n]=s.nextInt();}
				catch(Exception e){}
			}

			long cur=0;

			for(int i=0; i<n2; i++)
			{
				cur+=nums[i];
				sums[i]=cur;
			}

			long ans=Long.MAX_VALUE;

			dp=new long[n2][n2];

			recurDP(0,n2-1);

			for(int i=0; i<n; i++)
			{
				long res=dp[i][i+n-1];
				
				if(res<ans)
					ans=res;
			}

			System.out.println(ans);
		}
	}
}