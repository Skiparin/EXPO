package Entity;

import Entity.Flight;
import Entity.Reservation;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-28T12:08:49")
@StaticMetamodel(FlightInstance.class)
public class FlightInstance_ { 

    public static volatile SingularAttribute<FlightInstance, String> date;
    public static volatile SingularAttribute<FlightInstance, Flight> flight;
    public static volatile SingularAttribute<FlightInstance, Integer> price;
    public static volatile ListAttribute<FlightInstance, Reservation> reservation;
    public static volatile SingularAttribute<FlightInstance, String> id;
    public static volatile SingularAttribute<FlightInstance, String> time;
    public static volatile SingularAttribute<FlightInstance, String> avaiableSeats;

}