package Entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-28T12:08:49")
@StaticMetamodel(Airline.class)
public class Airline { 

    public static volatile SingularAttribute<Airline, String> name;
    public static volatile SingularAttribute<Airline, String> id;
    public static volatile ListAttribute<Airline, Flight> flights;

}