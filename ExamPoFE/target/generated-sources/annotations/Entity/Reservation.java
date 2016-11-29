package Entity;

import Entity.FlightInstance;
import Entity.Passenger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-28T12:08:49")
@StaticMetamodel(Reservation.class)
public class Reservation_ { 

    public static volatile ListAttribute<Reservation, Passenger> passengers;
    public static volatile SingularAttribute<Reservation, Integer> totalPrice;
    public static volatile SingularAttribute<Reservation, FlightInstance> flightInstance;
    public static volatile SingularAttribute<Reservation, String> id;

}