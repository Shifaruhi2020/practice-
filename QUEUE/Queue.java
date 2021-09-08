public class Queue 
{
    int Queue[]=new int[5];
    int size;
    int front;
    int rear;
    public void enqueue(int data)
    {
        Queue[rear]=data;
        rear++;
        rear=rear%5;
        size++;
    }
    public void show()
    {
        for(int i=0;i<size;i++)
        {
            System.out.print(Queue[(front+i)%5]+" ");
        }
    }
    
    public int dequeue()
    {
        int data=Queue[front];
        front++;
        front=front%5;
        size--;
        return data;
    }
    public int getsize()
    {
        return size;
    }
}
