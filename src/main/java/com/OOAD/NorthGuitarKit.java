package com.OOAD;

public class NorthGuitarKit extends GuitarKit {
    GKitFactory gKitFactory;
    public NorthGuitarKit(GKitFactory gKitFactory){
        this.gKitFactory = gKitFactory;
    }

    void createGuitarKit() {
        bridge = gKitFactory.createBridge();
    }
}
