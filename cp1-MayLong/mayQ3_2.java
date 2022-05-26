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
	static int n;
	static int[] ypx,ymx;
	static int[] aux;
	static void merge(int[] a, int low, int mid, int high)
	{
		for(int i=low; i<=high; i++)
			aux[i]=a[i];

		int i=low;
		int j=mid+1;
		int k=low;

		while(i<=mid && j<=high)
		{
			if(aux[i]<=aux[j])
				a[k++]=aux[i++];
			else
				a[k++]=aux[j++];
		}
		while(i<=mid)
			a[k++]=aux[i++];
		while(j<=high)
			a[k++]=aux[j++];
	}

	static void mergeSort(int low, int high)
	{
		if(low<high)
		{
			int mid=(low+high)/2;

			mergeSort(low,mid);
			mergeSort(mid+1,high);

			merge(ypx,low,mid,high);
			merge(ymx,low,mid,high);
		}
	}
	public static void main(String[] args) 
	{
		Reader s=new Reader();
		s.init(System.in);

		int t;

		try{
		t=s.nextInt();}
		catch(Exception e){t=0;}


		for(int p=0; p<t; p++)
		{
			try{
			n=s.nextInt();}
			catch(Exception e){n=0;}

			ypx=new int[n];
			ymx=new int[n];
			aux=new int[n];

			for(int j=0; j<n; j++)
			{
				int x,y;
				try{
				x=s.nextInt();
				y=s.nextInt();}
				catch(Exception e){x=0;y=0;}

				ypx[j]=y+x;
				ymx[j]=y-x;
			}

			mergeSort(0,n-1);


			/*for(int i=0; i<n; i++)
			{
				System.out.print(ypx[i]+" ");
			}
			System.out.print("\n");
			for(int i=0; i<n; i++)
			{
				System.out.print(ymx[i]+" ");
			}*/

			int minDist=Integer.MAX_VALUE;

			for(int i=0; i<n-1; i++)
			{
				int d1=ypx[i+1]-ypx[i];
				int d2=ymx[i+1]-ymx[i];

				if(d1<minDist)
					minDist=d1;
				if(d2<minDist)
					minDist=d2;
			}

			System.out.println(0.5*minDist);
		}
	}
}