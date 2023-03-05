
package lab1;

/**
 *
 * @author ahmedaly
 */
public class Ticket {
    
    private Passenger passenger;
    private Flight flight;
    private double price;
    private int ticketNumber;
    private static int number=1;
    
    public Ticket(Passenger p,Flight flight,double price){
        this.passenger=p;
        this.flight=flight;
        this.price=price;
        this.ticketNumber=Ticket.number;
        Ticket.number++;
    }
    
    public Passenger getpassenger(){
        return this.passenger;
    }
    
    public void setpassenger(Passenger passenger){
        this.passenger=passenger;
    }
    
    public Flight getflight(){
        return this.flight;
    }
    
    public void setflight(Flight flight){
        this.flight=flight;
    }
    
    public double getprice(){
        return this.price;
    }
    
    public void setprice(double price){
        this.price=price;
    }
    
    public int getticketNumber(){
        return this.ticketNumber;
    }
    
    public void settickerNumber(int ticketNumber){
        this.ticketNumber=ticketNumber;
    }
    
    @Override
    public String toString(){
        return " "+this.getpassenger().getname()+", "+this.flight.toString()+", Ticket Price: "+this.price+"$";
    }
}
