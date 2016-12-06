package Entity;

import Entity.Flight;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-01T12:07:56")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-01T11:51:29")
>>>>>>> ec1a5db9f2b113b0b9ade9917a67948c82b94c9c
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