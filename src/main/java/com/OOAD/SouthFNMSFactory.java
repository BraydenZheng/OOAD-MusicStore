package com.OOAD;

public class SouthFNMSFactory {
    public static GuitarKit createGuitarKit(String rnd1 , String rnd2, String rnd3,String bridge, String knobset,String covers, String neck,String pickup,String pickguard){
        GuitarKit guitar = null;
        System.out.println("South FNMS - Created guitar with " + rnd1 + " " + rnd2 + " " + rnd3);
        //return ItemType.GUITAR;
        return guitar;
    }
}
