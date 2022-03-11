package com.OOAD;

public class SouthFNMSFactory {
    public static int createGuitarKit(String selectedBridge,String selectedKnobSet, String selectedCovers,String selectedNeck,String selectedPickUp,String selectedPickGuards){
        int totalPrice=0;
        System.out.println("South FNMS - Created guitar with " + "Bridge" +  selectedBridge + " " + "Knob" + selectedKnobSet + " " + "Covers" +  selectedCovers + " "+ "Neck" + selectedNeck+
                " "+ "PickUp" + selectedPickUp + " " + "PickGuards" + selectedPickGuards);
        if(selectedKnobSet.equals("A")){
            KnobSet knob = new KnobSetA();
            totalPrice+=knob.price();
        }
        if(selectedKnobSet.equals("B")){
            KnobSet knob = new KnobSetB();
            totalPrice+=knob.price();
        }
        if(selectedKnobSet.equals("C")){
            KnobSet knob = new KnobSetC();
            totalPrice+=knob.price();
        }
        if(selectedBridge.equals("A")){
            Bridge bridge = new BridgeA();
            totalPrice+=bridge.price();
        }
        if(selectedBridge.equals("B")){
            Bridge bridge = new BridgeB();
            totalPrice+=bridge.price();
        }
        if(selectedBridge.equals("C")){
            Bridge bridge = new BridgeC();
            totalPrice+=bridge.price();
        }
        if(selectedCovers.equals("A")){
            Covers covers = new CoversA();
            totalPrice+=covers.price();
        }
        if(selectedCovers.equals("B")){
            Covers covers = new CoversB();
            totalPrice+=covers.price();
        }
        if(selectedCovers.equals("C")){
            Covers covers = new CoversC();
            totalPrice+=covers.price();
        }
        if(selectedNeck.equals("A")){
            Neck neck = new NeckA();
            totalPrice+=neck.price();
        }
        if(selectedNeck.equals("B")){
            Neck neck = new NeckB();
            totalPrice+=neck.price();
        }
        if(selectedNeck.equals("C")){
            Neck neck = new NeckC();
            totalPrice+=neck.price();
        }
        if(selectedPickGuards.equals("A")){
            PickGuard pickGuard = new PickGuardA();
            totalPrice+=pickGuard.price();
        }
        if(selectedPickGuards.equals("B")){
            PickGuard pickGuard = new PickGuardB();
            totalPrice+=pickGuard.price();
        }
        if(selectedPickGuards.equals("C")){
            PickGuard pickGuard = new PickGuardC();
            totalPrice+=pickGuard.price();
        }
        if(selectedPickUp.equals("A")){
            PickUp pickUp = new PickUpA();
            totalPrice+=pickUp.price();
        }
        if(selectedPickUp.equals("B")){
            PickUp pickUp = new PickUpA();
            totalPrice+=pickUp.price();
        }
        if(selectedKnobSet.equals("C")){
            PickUp pickUp = new PickUpA();
            totalPrice+=pickUp.price();
        }
        return totalPrice;
    }
}
