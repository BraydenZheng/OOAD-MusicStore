package com.OOAD;

public class electronicTuning extends Tune {
    @Override
    public void tuningTo(Item item) {
            if (Utility.rnd()>0.8) {
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
            else {
                if (item instanceof Players) {
                    ((Players) item).equalized = false;
                }
                if (item instanceof Stringed) {
                    ((Stringed) item).tuned = false;
                }
                if (item instanceof Wind) {
                    ((Wind) item).adjusted = false;
                }

            }
        }
    }
