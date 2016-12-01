package Entity;

import Entity.Flight;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-01T12:07:56")
@StaticMetamodel(Airport.class)
public class Airport_ { 

    public static volatile SingularAttribute<Airport, String> country;
    public static volatile SingularAttribute<Airport, String> IATACode;
    public static volatile SingularAttribute<Airport, String> city;
    public static volatile SingularAttribute<Airport, String> timezone;
    public static volatile ListAttribute<Airport, Flight> origin;
    public static volatile SingularAttribute<Airport, String> name;
    public static volatile ListAttribute<Airport, Flight> destination;
    public static volatile SingularAttribute<Airport, Integer> id;

}