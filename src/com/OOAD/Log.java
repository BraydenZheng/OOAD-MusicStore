package com.OOAD;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

public class Log implements Observer {
    private int day;
    private PrintWriter outFile;
    private FileWriter fw;

    public Log(int today) {
        day = today;
        try {
            createFile();
        } catch (IOException e) {
            //do nothing
        }

    }

    private void createFile() throws IOException {
        fw = new FileWriter("logger-" + day + ".txt");
        outFile = new PrintWriter(fw);
    }

    @Override
    public void update(String message) {
        outFile.println(message);
        outFile.flush();
    }
}
