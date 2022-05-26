import java.util.*; 

public class creator 
{ 
	static void check(int[] nums,int n) 
	{ 

		int[] count = new int[100001]; 
		
		for(int i=0; i<n; i++) 
			count[nums[i]]++; 

		PriorityQueue<Key> pq = new PriorityQueue<>(new KeyComparator()); 

		for(int i=0; i<=100000; i++)
			if(count[i]>0) 
				pq.add(new Key(count[i], i)); 
		
		ArrayList<Integer> ans=new ArrayList<Integer>(); 

		Key prev = new Key(-1, -1); 

		while(pq.size()>0)
		{
			Key k=pq.peek(); 
			pq.poll(); 
			ans.add(k.num);

			if (prev.freq>0) 
				pq.add(prev); 

			(k.freq)--; 
			prev = k; 
		} 

		if (n!=ans.size()) 
			System.out.println("No"); 
		else
			System.out.println("Yes"); 
	}

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int[] nums=new int[n];

		for(int i=0; i<n; i++)
		{
			nums[i]=s.nextInt();
		}

		check(nums,n);
	}
}

class KeyComparator implements Comparator<Key> { 

	public int compare(Key k1, Key k2) 
	{ 
		return k2.freq-k1.freq;
	} 
} 

class Key { 
	int freq;
	int num;

	Key(int freq, int num) 
	{ 
		this.freq = freq; 
		this.num = num; 
	} 
} 