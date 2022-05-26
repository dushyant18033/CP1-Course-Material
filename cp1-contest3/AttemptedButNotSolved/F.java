import java.util.*;

public class F
{
	static String toBinary(int num)
	{
		String key="";
		while(num>0)
		{
			int rem=num%2;
			num/=2;
			key=String.valueOf(rem)+key;
		}
		return key;
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);

		TrieADT tr=new TrieADT();

		int n=s.nextInt();

		for(int i=0; i<n; i++)
		{
			int num=s.nextInt();
			tr.insert(toBinary(num));
		}

		int q=s.nextInt();
		for(int i=0; i<q; i++)
		{
			int x=s.nextInt();
			int k=s.nextInt();
			String xbin=toBinary(x);
			String[] keys=new String[k];

			for(int j=0; j<k; j++)
			{
				String[j]=
			}
		}
	}
}
class Node
{
	Node[] children=new Node[2];
	boolean isLeaf;

	Node()
	{
		isLeaf=false;

		for(int i=0; i<2; i++)
			children[i]=null;
	}
}

class TrieADT
{
	Node root;

	TrieADT()
	{
		root=new Node();
	}

	String minXorKey(String xorWith)
	{
		
	}

	private boolean isEmpty(Node root)
	{
		for(int i=0; i<2; i++)
			if(root.children[i]!=null)
				return false;
		return true;
	}

	void insert(String key)
	{
		Node temp=root;
		int n=key.length();

		for(int i=0; i<n; i++)
		{
			int ind=key.charAt(i)-'0';

			if(temp.children[ind]==null)
				temp.children[ind]=new Node();

			temp=temp.children[ind];
		}
		temp.isLeaf=true;
	}

	private Node remove(String key, Node root, int level)
	{
		if(root==null)
			return null;

		if(level==key.length())
		{
			root.isLeaf=false;

			if(isEmpty(root))
				root=null;

			return root;
		}
		else
		{
			int ind=key.charAt(level)-'0';

			root.children[ind]=remove(key,root.children[ind],level+1);

			if(isEmpty(root) && !root.isLeaf)
				root=null;

			return root;
		}
	}

	void remove(String key)
	{
		remove(key,root,0);
	}
	void display()
	{
		display(this.root,"");
	}
	void display(Node root, String str)
	{
		if(root.isLeaf)
			System.out.println(str);

		for(int i=0; i<2; i++)
		{
			if(root.children[i]!=null)
			{
				String str1=str+(char)('0'+i);
				display(root.children[i],str1);
			}
		}
	}

}