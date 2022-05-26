import java.util.*;

class parti
{
	int solved;
	int tot_time;

	parti()
	{
		solved=0;
		tot_time=Integer.MAX_VALUE;
	}
	parti(int time)
	{
		solved=1;
		tot_time=time;
	}
	void update(int time)
	{
		solved++;
		tot_time+=time;
	}
	String print()
	{
		return solved+" "+tot_time;
	}
}

class applyRanking implements Comparator<parti>
{
	public int compare(parti a, parti b)
	{
		if(a.solved!=b.solved)
			return b.solved-a.solved;
		else
			return a.tot_time-b.tot_time;
	}
}

public class b
{
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);

		int n=s.nextInt();
		int m=s.nextInt();

		parti[] objs=new parti[n];
		int ctr=0;

		HashMap<String,parti> h=new HashMap<>();
		HashSet<String> done=new HashSet<String>();

		for(int i=0; i<m; i++)
		{
			String name=s.next();
			int time=s.nextInt();
			
			if(done.contains(name))
			{
				h.get(name).update(time);
			}
			else
			{
				done.add(name);
				objs[ctr]=new parti(time);
				h.put(name,objs[ctr++]);
			}
		}
		while(ctr<n)
			objs[ctr++]=new parti();

		Arrays.sort(objs,new applyRanking());

		Iterator it = h.entrySet().iterator();
		int rank=1;
		while (it.hasNext()) {
		    Map.Entry pair = (Map.Entry)it.next();
		    //System.out.println(pair.getKey() + " = " + ((parti)pair.getValue()).print());
		    if(pair.getKey().equals("BhayanakMaut"))
		    {
		    	System.out.println(rank);
		    	break;
		    }
		    rank++;
		    it.remove(); // avoids a ConcurrentModificationException
		}
	
	}
}