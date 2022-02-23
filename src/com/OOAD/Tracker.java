package com.OOAD;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class Tracker implements Observer{
    private int day;
    private PrintWriter outFile;
    private FileWriter fw;


    public Tracker(int day) {
        this.day = day;

        try {
            createFile();
        } catch (IOException e) {
            //do nothing
        }
    }

    private void createFile() throws IOException {
        fw = new FileWriter("tracker.txt", true);
        outFile = new PrintWriter(fw);
    }

    @Override
    public void updateTracker(ArrayList<Clerk> clerks) {
        outFile.println("Tracker: " + day);
        outFile.println("Clerk      Items Sold      Items Purchased     Item Damaged");
        for (Clerk c : clerks) {
            outFile.println(c.name + "              " + c.itemsSold + "             " + c.itemsPurchased + "            " + c.itemsDamaged);
        }
        outFile.flush();
    }


}
