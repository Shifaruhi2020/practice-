public class Main
{
	public static void main(String[] args)
	{
		Queue q=new Queue();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		
		q.show();
		        System.out.println();
		
	         	q.dequeue();
		        q.dequeue();
		        
		        q.show();
		        System.out.println();
		q.enqueue(5);
		q.enqueue(6);
		q.show();
		 System.out.println();
		 System.out.println(q.getsize());
		
	}
}
