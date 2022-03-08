//Tracker class used to generate tracker.txt
//OBSERVER Design Pattern

package com.OOAD;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class Tracker implements Observer{
    private int day;
    private PrintWriter outFile;
    private FileWriter fw;
    private static Tracker uniqueInstance = new Tracker();

    private Tracker() {
    }

    public void setDay(int today) {
        this.day = today;
    }

    public void createFile() throws IOException {
        fw = new FileWriter("tracker.txt", true);
        outFile = new PrintWriter(fw);
    }

    public static synchronized Tracker getTrackInstance() {
        return uniqueInstance;
    }

    @Override
    public void updateTracker(ArrayList<Clerk> clerks) {
        outFile.println('\n');
        outFile.println("Tracker: " + day);
        outFile.println("Clerk      Items Sold      Items Purchased     Item Damaged");
        for (Clerk c : clerks) {
            outFile.println(c.name + "              " + c.itemsSold + "             " + c.itemsPurchased + "            " + c.itemsDamaged);
        }
        outFile.flush();
    }


}
