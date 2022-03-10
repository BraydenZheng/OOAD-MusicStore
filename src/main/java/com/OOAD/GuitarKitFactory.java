package com.OOAD;


import javax.xml.stream.Location;
import java.util.HashMap;

public class GuitarKitFactory {
    private  GuitarKitFactory(){
    }

    enum Location
    {
        DEFAULT, NFNMS, SFNMS
    }

    public static int createGuitarKit(String rnd1, String rnd2, String rnd3){
        GuitarKit guitar;
        Location location = Location.NFNMS;
        int totalPrice;
        String bridge = "BRIDGE";
        String knobset = "KNOBSET";
        String covers = "COVERS";
        String neck = "NECK";
        String pickup = "PICKUPS";
        String pickguard = "PICKGARDS";
        //Mapping price to each of the guitar parts
        HashMap<String,Integer> priceMap = new HashMap<>();
        priceMap.put("BRIDGE",30);
        priceMap.put("KNOBSET",35);
        priceMap.put("COVERS",40);
        priceMap.put("NECK",65);
        priceMap.put("PICKUPS",38);
        priceMap.put("PICKGUARDS",78);
        // Calculating the total price based on the parts selected by the client
        totalPrice = priceMap.get("BRIDGE")+priceMap.get("KNOBSET")+priceMap.get("COVERS")+priceMap.get("NECK")+priceMap.get("PICKUPS")+priceMap.get("PICKGUARDS");

        if (location.equals(Location.NFNMS))
            guitar = NorthFNMSFactory.createGuitarKit(rnd1, rnd2, rnd3,bridge,knobset,covers,neck,pickup,pickguard);
        else
            guitar = SouthFNMSFactory.createGuitarKit(rnd1, rnd2, rnd3, bridge,knobset,covers,neck,pickup,pickguard);

        System.out.println("The total price of guitar kit is " + totalPrice);
        return totalPrice;
    }
}
