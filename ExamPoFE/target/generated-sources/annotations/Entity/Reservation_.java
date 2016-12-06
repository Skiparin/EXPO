package Entity;

import Entity.FlightInstance;
import Entity.Passenger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-01T12:07:56")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-01T11:51:29")
>>>>>>> ec1a5db9f2b113b0b9ade9917a67948c82b94c9c
@StaticMetamodel(Reservation.class)
public class Reservation_ { 

    public static volatile ListAttribute<Reservation, Passenger> passengers;
    public static volatile SingularAttribute<Reservation, Integer> totalPrice;
    public static volatile SingularAttribute<Reservation, FlightInstance> flightInstance;
    public static volatile SingularAttribute<Reservation, Integer> id;

}