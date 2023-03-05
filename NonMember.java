
package lab1;

/**
 *
 * @author ahmedaly
 */
public class NonMember extends Passenger {

    public NonMember(String name, int age) {
        super(name, age);
    }

    @Override
    public double applyDiscount(double p) {
        if(this.getage()>65){
            return p*0.90;
        }
        
        else{
            return p;
        }
    }
}
