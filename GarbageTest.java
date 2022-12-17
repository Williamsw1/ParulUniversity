/* Java program to demonstrate that 
objects created inside a method will become
eligible for gc after method execution terminate */
/*How to make object eligible for garbage collection in Java? */
  
class GarbageTest
{
      
    // to store object name
    String obj_name;
      
    public GarbageTest(String obj_name) 
    {
        this.obj_name = obj_name;
    }
      
    static void show()
    {
        //object t1 inside method becomes unreachable when show() removed
        GarbageTest t1 = new GarbageTest("t1"); 
        display();
          
    }
    static void display()
    {
        //object t2 inside method becomes unreachable when display() removed
        GarbageTest t2 = new GarbageTest("t2"); 
    }
      
    // Driver method
    public static void main(String args[])
    {
        // calling show()
        show();
          
        // calling garbage collector
        System.gc();
    }
      
    @Override
    /* Overriding finalize method to check which object
    is garbage collected */
    protected void finalize() throws Throwable 
    {
        // will print name of object
        System.out.println(this.obj_name + " successfully garbage collected");
    }
}
