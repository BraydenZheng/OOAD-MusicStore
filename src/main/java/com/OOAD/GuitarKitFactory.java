package com.OOAD;


import java.util.HashMap;


enum Location {NFNMS,SFNMS}
public class GuitarKitFactory {
    private  GuitarKitFactory(){
    }
    public static GuitarKit createGuitarKit(Clerk.Category rnd1, Clerk.Category rnd2, Clerk.Category rnd3, Clerk.GuitarParts part1
    , Clerk.GuitarParts part2, Clerk.GuitarParts part3){
        GuitarKit guitar = null;
        Location location = Location.NFNMS;
        int totalPrice;
        //Mapping price to each of the guitar parts
        HashMap<String,Integer> priceMap = new HashMap<>();
        priceMap.put("BRIDGE",30);
        priceMap.put("KNOBSET",35);
        priceMap.put("COVERS",40);
        priceMap.put("NECK",65);
        priceMap.put("PICKUPS",38);
        priceMap.put("PICKGUARDS",78);
        // Calculating the total price based on the parts selected by the client
        totalPrice = priceMap.get(part1.toString())+priceMap.get(part2.toString())+priceMap.get(part3.toString());
        guitar = switch (location) {
            case NFNMS -> NFNMSFactory.createGuitarKit(rnd1, rnd2, rnd3, part1, part2, part3);
            case SFNMS -> SFNMSFactory.createGuitarKit(rnd1, rnd2, rnd3, part1, part2, part3);
        };
        System.out.println("The total price of guitar kit is " + totalPrice);
        return guitar;
    }
}
