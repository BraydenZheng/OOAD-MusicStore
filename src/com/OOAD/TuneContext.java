package com.OOAD;

public class TuneContext {
    Tune tune;
    Item item;

    public void setTune(Tune tune,Item item) {
        this.tune = tune;
        this.item = item;
    }
    public void tuning(Item item){
        tune.tuningTo(item);
    }
}
