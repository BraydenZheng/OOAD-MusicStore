package com.OOAD;

public class NorthGKitFactory implements GKitFactory{

    public Bridge createBridge() {
        return new BridgeA();
    }
    public KnobSet createKnobSet(){return new KnobSetA();}
}
