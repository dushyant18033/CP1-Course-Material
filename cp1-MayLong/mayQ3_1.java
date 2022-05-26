import java.util.Scanner;

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
	public static void main(String[] args) 
	{
		Reader s=new Reader();
		s.init(System.in);

		int t,n;

		try{
		t=s.nextInt();}
		catch(Exception e){t=0;}

		int[] x,y;

		for(int p=0; p<t; p++)
		{
			try{
			n=s.nextInt();}
			catch(Exception e){n=0;}

			x=new int[n];
			y=new int[n];

			for(int j=0; j<n; j++)
			{
				try{
				x[j]=s.nextInt();
				y[j]=s.nextInt();}
				catch(Exception e){}
			}

			double minDist=Double.MAX_VALUE;

			for(int i=0; i<n; i++)
			{
				for(int j=i+1; j<n; j++)
				{
					double d1=Math.abs(y[i]+x[i]-y[j]-x[j]);
					double d2=Math.abs(y[i]-x[i]-y[j]+x[j]);

					if(minDist>d1)
						minDist=d1;
					if(minDist>d2)
						minDist=d2;
				}
			}

			System.out.println(0.5*minDist);
		}
	}
}