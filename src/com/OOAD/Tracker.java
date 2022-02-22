package com.OOAD;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

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
        fw = new FileWriter("tracker.txt");
        outFile = new PrintWriter(fw);
    }

    @Override
    public void update(String message) {
        outFile.println(message);
        outFile.flush();
    }


}
