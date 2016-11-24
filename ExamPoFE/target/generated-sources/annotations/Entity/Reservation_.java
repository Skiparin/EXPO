package Entity;

import Entity.passenger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-23T13:37:37")
@StaticMetamodel(Reservation.class)
public class Reservation_ { 

    public static volatile SingularAttribute<Reservation, Integer> numberOfSeats;
    public static volatile SingularAttribute<Reservation, String> reserveeName;
    public static volatile SingularAttribute<Reservation, String> reserveeEmail;
    public static volatile SingularAttribute<Reservation, String> reserveePhone;
    public static volatile ListAttribute<Reservation, passenger> passenger;
    public static volatile SingularAttribute<Reservation, String> id;

}