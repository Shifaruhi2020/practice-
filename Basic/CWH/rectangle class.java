
class Rectangle{
    int length; 
    int breadth;

    public int area(int length, int breadth)// length and breadth are params 
    {
        return length * breadth;
    }
    
     public int perimeter(int length, int breadth){
         return (2*(length+breadth) );
    }
    
    public void dimentions(int length, int breadth){
        System.out.print("length:"+length+", "+"breadth:"+breadth);
    }
}


public class Main {
    
    public static void main(String[] args) {
        Rectangle fun = new Rectangle();//insatntiating obj
       
        int length = 10;
        int breadth = 2;
        fun.dimentions(length, breadth);//passing arguments
        System.out.println();
        System.out.println("area :"+fun.area(length, breadth));
        System.out.println("perimeter"+fun.perimeter(length, breadth));
        
    }
}
