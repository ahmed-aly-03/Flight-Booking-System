
package lab1;

/**
 *
 * @author ahmedaly
 */
public abstract class Passenger {
    
    private String name;
    private int age;
    
    public Passenger(String name,int age){    
        this.name=name;
        this.age=age;
    }
    
    public String getname(){
        return this.name;
    }
    
    public void setname(String name){
        this.name=name;
    }
    
    public int getage(){
        return this.age;
    }
    
    public void setage(int age){
        this.age=age;
    }
    
    public abstract double applyDiscount(double p);
}
