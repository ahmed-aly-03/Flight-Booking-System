
//possible flights to input into the array:
//1030,Toronto,Kolkata,02/05/23 7:15pm,2000,1800
//1040,Toronto,Montreal,02/05/23 9:15pm,800,400
//1050,Toronto,Abu Dhabi,02/06/23 6:15 am,3000,2500
//1060,Toronto,Kolkata,02/06/23 10:15 am,450,1800
//1070,Toronto,Abu Dhabi,02/06/23 5:15pm,1,2500
//1080,Toronto,Montreal,02/07/23 8:15pm,000,400

package lab1;

/**
 *
 * @author ahmedaly
 */
import java.util.Scanner; 
import java.util.ArrayList;

public class Manager {
    
    private ArrayList<Flight> flights=new ArrayList<>();
    private ArrayList<Ticket> issuedTickets=new ArrayList<>();
    
    public void createFlights() {
       Scanner scanner1 = new Scanner(System.in);
       int a=1;
       String input;
       String[] inputs = new String[6];
       int flightNumber;
       int capacity;
       double originalPrice;
       
        while(a!=2){
            System.out.println("Input the flight information seperated by a comma(ex:Flight Number,Origin,Destination,Departure Time,Capacity,Original Price):");
            
            input=scanner1.nextLine();
            inputs=input.split(",");
          
            flightNumber=Integer.parseInt(inputs[0]);
            capacity=Integer.parseInt(inputs[4]);
            originalPrice=Double.parseDouble(inputs[5]);

            flights.add(new Flight(flightNumber,inputs[1],inputs[2],inputs[3],capacity,originalPrice));
            
            System.out.println("1. Input a new flight"
               +          "\n2. Exit"
               +          "\n(Press either 1 or 2 to select an option)");
       
            a=scanner1.nextInt();
            scanner1.nextLine();
        }
    }
    
    public void displayAvailableFlights(String origin, String destination){
        int counter=0;
        for(Flight flight:flights){
            if(flight.getorigin().equalsIgnoreCase(origin)==true && flight.getdestination().equalsIgnoreCase(destination)==true && flight.getnumberOfSeatsLeft()>0 ){
                System.out.println(flight);
                counter++;
            }
        }
        
        if(counter==0){
            System.out.println("There are no flights found");
        }
    }
    
    public Flight getFlight(int flightNumber){
        for(Flight flight:flights){
            if(flight.getflightNumber()==flightNumber){
                return flight;
            }
        }
        return null;
    }
    
    public void bookSeat(int flightNumber, Passenger p){         
        Flight flight=getFlight(flightNumber);
        
        if(flight==null){
            System.out.println("The flight does not exist.");
        }
        
        else{
            if(flight.bookAseat()==true){
               double price=p.applyDiscount(flight.getoriginalPrice());
               Ticket ticket=new Ticket(p,flight,price);
               this.issuedTickets.add(ticket);
               System.out.println(ticket);
            }
            
            else{
                System.out.println("A seat cannot be found");
            }
        }
    }
    public static void main(String args[]) {
        Manager manager=new Manager();
        Scanner scanner1= new Scanner(System.in);
   
        int menu;
        String origin;
        String destination;
        String passengerName;
        int passengerAge;
        String membershipStatus;
        int flightNumber;
        
        System.out.println("1.Add new flights"
                + "\n2.Display available flights"
                + "\n4.Get Flight"
                + "\n4.Book a seat"
                + "\n5.Exit");
        menu=scanner1.nextInt();
        scanner1.nextLine();
        
        while(menu!=5){
            switch (menu) {
                case 1:
                    manager.createFlights();
                    System.out.println("Displaying all flights found on the system:");//Displaying all flights in the flights arraylist whether they're fully booked or not
                                                                                      //Note that this is not the displayAvailableFlights function at work
                    for(Flight flight:manager.flights){
                        System.out.println(flight);
                    }    break;
                case 2:
                    System.out.println("What is the Origin?");
                    origin=scanner1.nextLine();
                    
                    System.out.println("What is the destination?");
                    destination=scanner1.nextLine();
                    
                    manager.displayAvailableFlights(origin, destination);
                    break;
                case 3:
                    int fNumber;
                    System.out.println("Input the flight Number:");
                    fNumber=scanner1.nextInt();
                    scanner1.nextLine();
                    
                    Flight f=manager.getFlight(fNumber);
                    
                    if(f==null){
                        System.out.println("The flight does not exist.");
                    }
                    
                    else{
                        System.out.println(f);
                    }
                    break;
                case 4:
                    System.out.println("Input the flight Number for which the ticket will be booked on:");
                    flightNumber=scanner1.nextInt();
                    scanner1.nextLine();
                    
                    System.out.println("What is the passenger's name?");
                    passengerName=scanner1.nextLine();
                    
                    System.out.println("What is the passenger's age?");
                    passengerAge=scanner1.nextInt();
                    scanner1.nextLine();
                    
                    System.out.println("Is the passenger a memeber?(Y/N)");
                    membershipStatus=scanner1.nextLine();
                    
                    if(membershipStatus.equalsIgnoreCase("Y")==true){
                        int yearsofMembership;
                        System.out.println("For how many years has the passenger been a member");
                        yearsofMembership=scanner1.nextInt();
                        
                        Passenger P = new Member(passengerName,passengerAge,yearsofMembership);
                        manager.bookSeat(flightNumber,P);
                    }
                    
                    else if(membershipStatus.equalsIgnoreCase("N")==true){
                        Passenger P = new NonMember(passengerName,passengerAge);
                        manager.bookSeat(flightNumber,P);
                    }  
                    
                    else{
                       System.out.println("Invalid Input, the detected input was neither Y nor N.");
                    }
                    break;
                default:
                    System.out.println("Invalid option try again");
            }
            
            System.out.println("1.Add new flights"
                + "\n2.Display available flights"
                + "\n3.Get Flight"
                + "\n4.Book a seat"
                + "\n5.Exit");
             menu=scanner1.nextInt();
             scanner1.nextLine();
        }
        
        System.out.println("Here is a list of all booked Tickets:");
        
        for(Ticket ticket:manager.issuedTickets){
            System.out.println(ticket);
        }
        
        System.exit(0);
    }   
}
