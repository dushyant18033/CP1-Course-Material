//import java.util.Scanner;

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

		int t;

		try{
			t=s.nextInt();
		}
		catch(Exception e){t=0;}

		int[] a,b;

		for(int i=0; i<t; i++)
		{
			int n,z;

			try{
				n=s.nextInt();
				z=s.nextInt();
			}
			catch(Exception e){n=0; z=0;}

			a=new int[n];
			
			for(int j=0; j<n; j++)
			{
				try{	
					a[j]=s.nextInt();
				}
				catch(Exception e){a[j]=0;}
			}
			
			boolean swapped;
			//int swaps=0;

			for(int k=0; k<z; k++)
			{
				b=new int[n];

				b[n-1]=a[n-1];

				swapped=false;

				for(int j=0; j<n-1; j++)
				{
					if(a[j]==0 && a[j+1]==1)
					{
						b[j]=1;
						b[j+1]=0;

						j++;

						swapped=true;
					}
					else
						b[j]=a[j];
				}

				a=b;

				if(!swapped)
					break;
				//swaps++;
			}

			for(int j=0; j<n; j++)
				System.out.print(a[j]+" ");
		}
	}
}