package com.OOAD;

public class NorthStore extends Store {
    NorthStore(String name) {
        super(name);
    }

    protected Bridge createGuitarKit(GuitarKit.Category category) {
        Bridge bridge;
        GuitarKit guitar = null;
        GKitFactory gKitFactory = new NorthGF();
        if(category.equals("A")){
            bridge = new BridgeA();
        }
        else if(category.equals("B")){
            bridge = new BridgeB();
        }
        else{
            bridge = new BridgeC();
        }
        return bridge;
    }
}
