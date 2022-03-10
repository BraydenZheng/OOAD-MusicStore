package com.OOAD;
import com.OOAD.Command.Command;

import java.util.ArrayList;

import static java.util.Objects.isNull;

public class Store implements Logger, Subject {
    public String name;
    public ArrayList<Clerk> clerks = new ArrayList<Clerk>();
    public Clerk activeClerk;
    public double cashRegister;
    public double cashFromBank;
    public Inventory inventory;
    public int today;
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    public Log log;
    public Tracker track;
    public ArrayList<Clerk> clerksTrackerData = new ArrayList<Clerk>();
    public Command currentCommand;

    Store(String name) {
        this.name = name;
        // initialize the store's starting inventory
        inventory = new Inventory();

        cashRegister = 0;   // cash register is empty to begin
        cashFromBank = 0;   // no cash from bank yet
        newClerks(); //initializing clerks

        Tune haphazardTuning = new haphazardTuning();
        Tune electronicTuning = new electronicTuning();
        Tune manualTuning = new manualTuning();
        clerksTrackerData.add(new Clerk("Velma",.05, this,haphazardTuning));
        clerksTrackerData.add(new Clerk("Shaggy", .20, this,electronicTuning));
        clerksTrackerData.add(new Clerk("Daphne", .30,this ,manualTuning));
        clerksTrackerData.add(new Clerk("Simon", .40,this ,manualTuning));
        clerksTrackerData.add(new Clerk("Mark", .25,this ,manualTuning));
        clerksTrackerData.add(new Clerk("Sid", .22,this ,manualTuning));
        this.registerObserver(new Clerk("observer", 0.5, this, haphazardTuning));
    }

    void newClerks(){
        // initialize the store's staff and add tuning
        clerks = new ArrayList<Clerk>();
        Tune haphazardTuning = new haphazardTuning();
        Tune electronicTuning = new electronicTuning();
        Tune manualTuning = new manualTuning();
        clerks.add(new Clerk("Velma",.05, this,haphazardTuning));
        clerks.add(new Clerk("Shaggy", .20, this,electronicTuning));
        clerks.add(new Clerk("Daphne", .30,this ,manualTuning));
    }

    void openToday(int day) {

        // new log object
        log = Log.getLogInstance();
        log.setDay(day);
        try {
            log.createFile(this.name);
        } catch (Exception e) {
            //file creation exception
        }

        track = Tracker.getTrackInstance();
        track.setDay(day);
        try {
            track.createFile(this.name);
        } catch (Exception e) {
            //file creation exception
        }

        out("Store opens today, day "+day);
        activeClerk = getValidClerk();
        out(activeClerk.name + " is working today.");
        activeClerk.arriveAtStore();
        activeClerk.checkRegister();
        activeClerk.doInventory();
        activeClerk.openTheStore();
        //activeClerk.buyGuitarKit();
        activeClerk.cleanTheStore();
        activeClerk.leaveTheStore();
    }

    Clerk getValidClerk() {
        // pick a random clerk
        Clerk clerk = clerks.get(Utility.rndFromRange(0,clerks.size()-1));

        // there is a 10% chance that the clerk might be sick
        if(Utility.rnd() < 0.1){
            out(clerk.name + " is sick today");
            clerks.remove(clerk);
            getValidClerk();
        }
        newClerks();
        if(isNull(clerk)){
            clerk = clerks.get(0);
        }

        // if they are ok to work, set days worked on other clerks to 0
        if (clerk.daysWorked < 3) {
            clerk.daysWorked += 1;
            for (Clerk other: clerks) {
                if (other != clerk) other.daysWorked = 0; // they had a day off, so clear their counter
            }
        }
        // if they are not ok to work, set their days worked to 0 and get another clerk
        else {
            out(clerk.name+" has worked maximum of 3 days in a row.");
            clerk.daysWorked = 0;   // they can't work, get another clerk
            for (Clerk other: clerks) {
                if (other != clerk) {
                    clerk = other;
                    break;
                }
            }
        }
        return clerk;
    }

    void closedToday(int day) {
        out("Store is closed today, day "+day);
    }

    //Observer Design Pattern functions
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver(String message) {
        for (Observer observer : observers) {
            log.update(message);
        }
    }

    public void notifyChanges(String message) {
        notifyObserver(message);
    }

    public void setCommand(Command command) {
        this.currentCommand = command;
    }

    public void excuteCommand() {
        this.currentCommand.excute();
    }

    public int getObserversCount() {
        return this.observers.size();
    }
}
