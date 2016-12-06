package Entity;

import Entity.Airline;
import Entity.Airport;
import Entity.FlightInstance;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-01T11:51:29")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-01T12:07:56")
>>>>>>> 4a1ea3217deacd9700e0d29f8a94d2c525d2f598
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-01T12:07:56")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-01T11:51:29")
>>>>>>> ec1a5db9f2b113b0b9ade9917a67948c82b94c9c
>>>>>>> 2e88383825f163c1cde4e808b6d18e6deb179b54
@StaticMetamodel(Flight.class)
public class Flight_ { 

    public static volatile SingularAttribute<Flight, Integer> numberOfSeats;
    public static volatile SingularAttribute<Flight, Airport> origin;
    public static volatile SingularAttribute<Flight, Airport> destination;
    public static volatile ListAttribute<Flight, FlightInstance> flightInstance;
    public static volatile SingularAttribute<Flight, Integer> id;
    public static volatile SingularAttribute<Flight, Integer> flightTime;
    public static volatile SingularAttribute<Flight, Airline> airline;
    public static volatile SingularAttribute<Flight, String> flightNumber;

}