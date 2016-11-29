package Entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-28T12:08:49")
@StaticMetamodel(Flight.class)
public class Flight { 

    public static volatile SingularAttribute<Flight, Integer> numberOfSeats;
    public static volatile SingularAttribute<Flight, Airport> Airport;
    public static volatile SingularAttribute<Flight, Airport> from;
    public static volatile ListAttribute<Flight, FlightInstance> flightInstance;
    public static volatile SingularAttribute<Flight, String> id;
    public static volatile SingularAttribute<Flight, Integer> flightTime;
    public static volatile SingularAttribute<Flight, Airline> airline;
    public static volatile SingularAttribute<Flight, String> flightNumber;

}