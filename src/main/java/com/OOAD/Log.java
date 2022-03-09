//Log class used to generate logger text files, part of Observer Design pattern

package com.OOAD;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

public class Log implements Observer {
    private int day;
    private PrintWriter outFile;
    private FileWriter fw;
    private static Log uniqueInstance;

    private Log() {
    }

    public void setDay(int today) {
        this.day = today;
    }

    public int getDay() {
        return this.day;
    }

    public void createFile(String storename) throws IOException {
        fw = new FileWriter("logger-" + this.day + ".txt");
        outFile = new PrintWriter(fw);
        outFile.println("logger of " + storename);
        outFile.flush();
    }

    public static synchronized Log getLogInstance() {
        if(uniqueInstance == null) {
            uniqueInstance = new Log();
        }
        return uniqueInstance;
    }

    @Override
    public void update(String message) {
        outFile.println(message);
        outFile.flush();
    }
}
