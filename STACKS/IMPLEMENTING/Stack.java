public class Stack
{
    int stack[]=new int[7];

   int top=0;
   //pushing the element in the array 
   //creating the top variable so that new element can b added
   //top->1->added
   //we need to add more elements 
   //so top is incremented so that the new it points to new element and it is added to the stack
  //top->3->added
    int push(int data)
    {
       stack[top]=data;
       top++;
       return stack[top];
    }
    
   public void print()
   {
       for(int n:stack)
       {
           System.out.println(n +" ");
       }
   }
   
   public int pop()
   {
       int data;
       top--;
       data=stack[top];
       stack[top]=0;
       return data;
   }
}
