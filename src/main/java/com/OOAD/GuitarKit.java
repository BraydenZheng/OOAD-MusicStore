package com.OOAD;

abstract class GuitarKit {

    enum Category { A,B,C}
    GuitarKit( Category bridge, Category knobSet, Category covers,
                     Category neck, Category pickguard, Category pickup)
    {
        this.bridge = bridge;
        this.knobSet = knobSet;
        this.covers = covers;
        this.neck = neck;
        this.pickguard = pickguard;
        this.pickup = pickup;
    }
    abstract void createGuitarKit();
    Category bridge = null;
    Category knobSet = null;
    Category covers = null;
    Category neck = null;
    Category pickguard = null;
    Category pickup = null;

    public Category getBridge() {
        return bridge;
    }

    public void setBridge(Category bridge) {
        this.bridge = bridge;
    }

    public Category getKnobSet() {
        return knobSet;
    }

    public void setKnobSet(Category knobSet) {
        this.knobSet = knobSet;
    }

    public Category getCovers() {
        return covers;
    }

    public void setCovers(Category covers) {
        this.covers = covers;
    }

    public Category getNeck() {
        return neck;
    }

    public void setNeck(Category neck) {
        this.neck = neck;
    }

    public Category getPickguard() {
        return pickguard;
    }

    public void setPickguard(Category pickguard) {
        this.pickguard = pickguard;
    }

    public Category getPickup() {
        return pickup;
    }

    public void setPickup(Category pickup) {
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
