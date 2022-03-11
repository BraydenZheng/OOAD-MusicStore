package com.OOAD;

public  class NorthGF implements GKitFactory {
    public Bridge createBridge(){
        return new BridgeA();
    }
    public KnobSet createKnobSet(){
        return new KnobSetC();
    }
    public Covers createCovers(){
        return new CoversA();
    }
    public Neck createNecks(){
        return new NeckA();
    }
    public PickUp createPickUps(){
        return new PickUpA();
    }
    public PickGuard createPickGuards(){
        return new PickGuardA();
    }
}
