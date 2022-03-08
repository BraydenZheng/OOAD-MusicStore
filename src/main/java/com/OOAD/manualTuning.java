package com.OOAD;

public class manualTuning extends Tune {
    @Override
    public void tuningTo(Item item) {
            if (item instanceof Players) {
                ((Players) item).equalized = true;
            }
            if (item instanceof Stringed) {
                ((Stringed) item).tuned = true;
            }
            if (item instanceof Wind) {
                ((Wind) item).adjusted = true;
            }
    }
    }

