package com.OOAD;

public class NorthFNMSFactory {
    public static GuitarKit createGuitarKit(String rnd1, String rnd2, String rnd3, String bridge, String knob, String covers, String neck, String pickup , String pickguard)
                                            {
        GuitarKit guitar = null;
        System.out.println("North FNMS - Created guitar with category " + rnd1 + " " + rnd2 + " " + rnd3);
        return guitar;
    }

}
