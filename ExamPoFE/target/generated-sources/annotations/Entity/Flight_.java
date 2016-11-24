package Entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-23T13:37:37")
@StaticMetamodel(Flight.class)
public class Flight_ { 

    public static volatile SingularAttribute<Flight, String> date;
    public static volatile SingularAttribute<Flight, String> Destination;
    public static volatile SingularAttribute<Flight, Integer> numberOfSeats;
    public static volatile SingularAttribute<Flight, Integer> travelTime;
    public static volatile SingularAttribute<Flight, Integer> totalPrice;
    public static volatile SingularAttribute<Flight, String> origin;
    public static volatile SingularAttribute<Flight, String> FlightNumber;
    public static volatile SingularAttribute<Flight, String> id;

}