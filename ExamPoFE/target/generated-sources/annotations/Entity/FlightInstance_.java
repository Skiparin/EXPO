package Entity;

import Entity.Flight;
import Entity.Reservation;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-01T12:07:56")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-01T11:51:29")
>>>>>>> ec1a5db9f2b113b0b9ade9917a67948c82b94c9c
@StaticMetamodel(FlightInstance.class)
public class FlightInstance_ { 

    public static volatile SingularAttribute<FlightInstance, String> date;
    public static volatile SingularAttribute<FlightInstance, Flight> flight;
    public static volatile SingularAttribute<FlightInstance, Integer> price;
    public static volatile ListAttribute<FlightInstance, Reservation> reservation;
    public static volatile SingularAttribute<FlightInstance, Integer> id;
    public static volatile SingularAttribute<FlightInstance, String> time;
    public static volatile SingularAttribute<FlightInstance, String> avaiableSeats;

}