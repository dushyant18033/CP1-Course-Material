import java.util.*;

public class b1
{
	static int[] aux, sInd,tInd, solved,totTime;

	static void mergeS(int low, int mid, int high)
	{
		for(int i=low; i<=high; i++)
			aux[i]=sInd[i];

		int i=low;
		int j=mid+1;
		int k=low;

		while(i<=mid && j<=high)
		{
			if(solved[aux[i]]>=solved[aux[j]])
				sInd[k++]=aux[i++];
			else
				sInd[k++]=aux[j++];
		}
		while(i<=mid)
			sInd[k++]=aux[i++];
		while(j<=high)
			sInd[k++]=aux[j++];
	}
	static void mergeT(int low, int mid, int high)
	{
		for(int i=low; i<=high; i++)
			aux[i]=tInd[i];

		int i=low;
		int j=mid+1;
		int k=low;

		while(i<=mid && j<=high)
		{
			if(totTime[aux[i]]<=totTime[aux[j]])
				tInd[k++]=aux[i++];
			else
				tInd[k++]=aux[j++];
		}
		while(i<=mid)
			tInd[k++]=aux[i++];
		while(j<=high)
			tInd[k++]=aux[j++];
	}

	static void mergeSort(int low, int high)
	{
		if(low<high)
		{
			int mid=(low+high)/2;

			mergeSort(low,mid);
			mergeSort(mid+1,high);

			mergeS(low,mid,high);
			mergeT(low,mid,high);
		}
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);

		int n=s.nextInt();
		int m=s.nextInt();

		solved=new int[n];
		totTime=new int[n];

		sInd=new int[n];
		tInd=new int[n];

		aux=new int[n];


		for(int i=0; i<n; i++)
		{
			sInd[i]=i;
			tInd[i]=i;
		}

		int ctr=0;

		HashMap<String,Integer> map=new HashMap<>();

		for(int i=0; i<m; i++)
		{
			String name=s.next();
			int time=s.nextInt();

			if(map.containsKey(name))
			{
				int ind=(int)map.get(name);
				solved[ind]+=1;
				totTime[ind]+=time;
			}
			else
			{
				solved[ctr]=1;
				totTime[ctr]=time;
				map.put(name,ctr++);
			}
		}
		
		int indBM=(int)map.get("BhayanakMaut");

		mergeSort(0,ctr-1);

		//for(int i=0; i<ctr; i++)
		//{
		//	System.out.println(solved[sInd[i]]+" "+totTime[tInd[i]]);
		//}

		int s=0,t=0;
		int rank=1;
		while(s<ctr && t<ctr)
		{
			
		}
	}
}