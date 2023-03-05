
package lab1;

/**
 *
 * @author ahmedaly
 */
public class Member extends Passenger{

    private int yearsOfMembership;
    
    public Member(String name, int age,int yearsOfMembership) {
        super(name, age);   
        this.yearsOfMembership=yearsOfMembership;
    }
    
    @Override
    public double applyDiscount(double p) {
        if(this.yearsOfMembership>5){
            return p*0.5;
        }
      
        else if(this.yearsOfMembership>1 && this.yearsOfMembership<=5){
            return p*0.9;
        }
        
        else{
            return p;
        }
    }
}
