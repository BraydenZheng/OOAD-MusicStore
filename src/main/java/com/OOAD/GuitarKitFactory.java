package com.OOAD;


import javax.xml.stream.Location;
import java.util.HashMap;

public class GuitarKitFactory {

    enum Location
    {
        NFNMS, SFNMS
    }

    public static int createGuitarKit(String selectedBridge,String selectedKnobSet, String selectedCovers,String selectedNeck,String selectedPickUp,String selectedPickGuards){
        int guitarPrice = 0;
        Location location = Location.NFNMS;


        if (location.equals(Location.NFNMS))
            guitarPrice = NorthFNMSFactory.createGuitarKit(selectedBridge,selectedKnobSet,selectedCovers,selectedNeck,selectedPickUp,selectedPickGuards);
        //else
            //GuitarKit guitar = SouthFNMSFactory.createGuitarKit(selectedBridge,selectedKnobSet,selectedCovers,selectedNeck,selectedPickUp,selectedPickGuards);
        System.out.println("The total price of guitar kit is " + guitarPrice);
        return guitarPrice;
    }
}
