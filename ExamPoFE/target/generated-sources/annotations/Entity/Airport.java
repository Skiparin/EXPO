package Entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-28T12:08:49")
@StaticMetamodel(Airport.class)
public class Airport { 

    public static volatile SingularAttribute<Airport, String> country;
    public static volatile ListAttribute<Airport, Flight> flightFrom;
    public static volatile SingularAttribute<Airport, String> IATACode;
    public static volatile SingularAttribute<Airport, String> city;
    public static volatile SingularAttribute<Airport, String> timezone;
    public static volatile SingularAttribute<Airport, String> name;
    public static volatile ListAttribute<Airport, Flight> flightTo;
    public static volatile SingularAttribute<Airport, String> id;

}