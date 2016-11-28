/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Thesoap
 */
@Entity
public class Airport implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String IATACode;
    private String timezone;
    private String name;
    private String country;
    private String city;
    @OneToMany(mappedBy = "Airport")
    private List<Flight> flightFrom;
    @OneToMany(mappedBy = "Airport")
    private List<Flight> flightTo;

    public Airport() {
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIATACode() {
        return IATACode;
    }

    public void setIATACode(String IATACode) {
        this.IATACode = IATACode;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Flight> getFlightFrom() {
        return flightFrom;
    }

    public void setFlightFrom(List<Flight> flightFrom) {
        this.flightFrom = flightFrom;
    }

    public List<Flight> getFlightTo() {
        return flightTo;
    }

    public void setFlightTo(List<Flight> flightTo) {
        this.flightTo = flightTo;
    }
    
    
    
    
}
