
package lab1;

/**
 *
 * @author ahmedaly
 */
public class Flight {
    
    private int flightNumber;
    private String origin;
    private String destination;
    private String departureTime;
    private int capacity;
    private int numberOfSeatsLeft;
    private double originalPrice;
    
    public Flight(int flightNumber, String origin, String destination, String departureTime, int capacity, double originalPrice){
        if(origin.compareTo(destination)==0){
            throw new IllegalArgumentException("The Destination is identical to the Origin");
        }
        
        else{
            this.flightNumber=flightNumber;
            this.origin=origin;
            this.destination=destination;
            this.departureTime=departureTime;
            this.capacity=capacity;
            this.originalPrice=originalPrice;
            this.numberOfSeatsLeft=capacity;
        }
    }
    
    public int getflightNumber(){
        return this.flightNumber;
    }
    
    public void setflightNumber (int flightNumber){
        this.flightNumber=flightNumber;
    }
    
    public String getorigin(){
        return this.origin ;
    }
    
    public void setorigin (String origin){
        this.origin=origin;
    }
    
    public String getdestination(){
        return this.destination;
    }
    
    public void setdestination (String destination){
        this.destination=destination;
    }
    
    public String getdepartureTime(){
        return this.departureTime;
    }
    
    public void setdepartureTime (String departureTime){
        this.departureTime=departureTime;
    }
    
    public int getcapacity(){
        return this.capacity;
    }
    
    public void setcapacity (int capacity){
        this.capacity=capacity;
    }
    
    public int getnumberOfSeatsLeft(){
        return this.numberOfSeatsLeft;
    }
    
    public void setnumberOfSeatsLeft (int numberOfSeatsLeft){
        this.numberOfSeatsLeft=numberOfSeatsLeft;
    }
    
    public double getoriginalPrice(){
       return this.originalPrice;
    }
    
    public void setoriginalPrice(double originalPrice){
        this.originalPrice=originalPrice;
    }
    
    public boolean bookAseat(){
        if(this.numberOfSeatsLeft>0){
            this.numberOfSeatsLeft--;
            return true;
        }
        
        else{
            return false;
        }
    }
    
    @Override
    public String toString(){
        return "Flight "+this.flightNumber+", "+this.origin+" to "+this.destination+", "+this.departureTime+", "+"original price: "+this.originalPrice+"$";
    }
}