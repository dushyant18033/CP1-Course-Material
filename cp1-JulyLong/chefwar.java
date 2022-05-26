import java.util.Scanner;

class Node
{
	int data;
	Node next;

	Node(int d)
	{
		data=d;
		next=null;
	}
}

class circularLinked
{

	Node head;
	Node tail;
	int size;

	circularLinked()
	{
		head=null;
		tail=null;
		size=0;
	}
	Node insert(int n)
	{
		Node nptr=new Node(n);

		if(size==0)
		{
			head=nptr;
			head.next=head;
			tail=head;
		}
		else
		{
			nptr.next=head;
			tail.next=nptr;
			tail=nptr;
		}
		size++;
		return nptr;
	}

	void printList()
	{
		Node temp=head;

		do
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}while(temp!=head);

	}
	void deleteNext(Node cur)
	{
		if(cur==tail)
		{
			head=head.next;
			tail.next=head;
		}
		else
		{
			Node temp=cur.next.next;
			cur.next=temp;
		}
		size--;
	}
}

class Main
{
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		
		int t=s.nextInt();

		for(int ti=0; ti<t; ti++)
		{
			circularLinked L=new circularLinked();

			int n=s.nextInt();

			int[] ar=new int[n-1];
			int p=0;
			boolean found=false;

			for(int i=0; i<n-1; i++)
			{
				ar[i]=s.nextInt();
			}

			int f=s.nextInt();

			Node josh=null;

			int minLeft=Integer.MAX_VALUE;

			for(int i=0; i<n-1; i++)
			{
				if(ar[i]<=f)
				{
					int k=i>0?i-1:n-2;
					if(ar[k]<minLeft)
					{
						minLeft=ar[k];
						p=i+1;
					}

					if(!found)
						found=true;
				}
			}

			for(int i=0; i<n-1; i++)
			{
				if(i+1==p)
					josh=L.insert(f);
				L.insert(ar[i]);
			}

			if(!found)
			{
				System.out.println("impossible");
				continue;
			}
			
			Node ptr=L.head;

			while(L.size>2)
			{
				if(ptr==josh)
					ptr=ptr.next;
				else if(ptr.next==josh)
				{
					josh.data+=ptr.data;
					ptr=josh.next;
				}
				else
				{
					L.deleteNext(ptr);
					ptr=ptr.next;
				}
			}

			System.out.println("possible");
			System.out.println(p+" "+josh.data);

		}		
	}
}