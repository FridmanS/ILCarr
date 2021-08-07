package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString

public class Car {
    private  String address;
    private  String make;
    private  String model;
    private  String year;
    private  String engine;
    private  String fuel;
    private  String gear;
    private  String wD;
    private  String doors;
    private  String seats;
    private  String clasS;
    private String fuelConsumption;
    private String  carRegNumber;
    private  String price;
    private String distanceIncluded;
    private String typeFeature;
    private  String about;
    private String photoPath;
}
