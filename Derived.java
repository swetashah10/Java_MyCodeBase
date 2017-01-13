public class Derived extends Base {
    public void fun(double val){
        System.out.println("val is derived " + (val +6));
    }

    public static void main(String[] args) {
        Base obj = new Derived();
        System.out.println("object type is.." + obj.getClass().getName());
//error line
        obj.fun(3.4);
    }
}
class Base{
    public void fun(int val){
        System.out.println("val is base " + (val +4));
    }
    
    public void fun(double value){
    	
    }
}
