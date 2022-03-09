package com.OOAD;

abstract class GuitarKit {

    enum Category { A,B,C}
    GuitarKit(Clerk.GuitarParts bridge, Clerk.GuitarParts knobSet, Clerk.GuitarParts covers,
              Clerk.GuitarParts neck, Clerk.GuitarParts pickguard, Clerk.GuitarParts pickup)
    {
        this.bridge = bridge;
        this.knobSet = knobSet;
        this.covers = covers;
        this.neck = neck;
        this.pickguard = pickguard;
        this.pickup = pickup;
    }
    abstract void createGuitarKit();
    Clerk.GuitarParts bridge = null;
    Clerk.GuitarParts knobSet = null;
    Clerk.GuitarParts covers = null;
    Clerk.GuitarParts neck = null;
    Clerk.GuitarParts pickguard = null;
    Clerk.GuitarParts pickup = null;

    public Clerk.GuitarParts getBridge() {
        return bridge;
    }

    public void setBridge(Clerk.GuitarParts bridge) {
        this.bridge = bridge;
    }

    public Clerk.GuitarParts getKnobSet() {
        return knobSet;
    }

    public void setKnobSet(Clerk.GuitarParts knobSet) {
        this.knobSet = knobSet;
    }

    public Clerk.GuitarParts getCovers() {
        return covers;
    }

    public void setCovers(Clerk.GuitarParts covers) {
        this.covers = covers;
    }

    public Clerk.GuitarParts getNeck() {
        return neck;
    }

    public void setNeck(Clerk.GuitarParts neck) {
        this.neck = neck;
    }

    public Clerk.GuitarParts getPickguard() {
        return pickguard;
    }

    public void setPickguard(Clerk.GuitarParts pickguard) {
        this.pickguard = pickguard;
    }

    public Clerk.GuitarParts getPickup() {
        return pickup;
    }

    public void setPickup(Clerk.GuitarParts pickup) {
        this.pickup = pickup;
    }

    @Override
    public String toString() {
        return "GuitarKit{" +
                "bridge=" + bridge +
                ", knobSet=" + knobSet +
                ", covers=" + covers +
                ", neck=" + neck +
                ", pickguard=" + pickguard +
                ", pickup=" + pickup +
                '}';
    }
}
