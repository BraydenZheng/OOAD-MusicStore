package com.OOAD;

public class NorthFNMSFactory {
    public static GuitarKit createGuitarKit(Clerk.Category rnd1, Clerk.Category rnd2, Clerk.Category rnd3, Clerk.GuitarParts part1,
                                            Clerk.GuitarParts part2, Clerk.GuitarParts part3){
        GuitarKit guitar = null;
        System.out.println("North FNMS - Created guitar with " + part1 + " " + rnd1 + " " + part2 + " " + rnd2 + " " + part3 + " " + rnd3);
        return guitar;
    }

}
