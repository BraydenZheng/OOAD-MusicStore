package com.OOAD;

import com.OOAD.Command.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// top level object to run the simulation
public class Simulation implements Logger {
    List<Store> storeList = new ArrayList<>();
    public Store interactionStore;
    int dayCounter;
    Weekday weekDay;
    Scanner in;

    // enum for Weekdays
    // next implementation from
    // https://stackoverflow.com/questions/17006239/whats-the-best-way-to-implement-next-and-previous-on-an-enum-type
    public static enum Weekday {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
        private static Weekday[] vals = values();
        public Weekday next() {
            return vals[(this.ordinal()+1) % vals.length];
        }
    }

    Simulation() {
        in = new Scanner(System.in);
        weekDay = Weekday.MONDAY;   //set the starting day
        dayCounter = 0;
        storeList.add(new Store("Northside FNMS"));
        storeList.add(new Store("Southside FNMS"));
        interactionStore = storeList.get(0);
    }


    void startSim(int days) {
        {
            for (int day = 1; day < days; day++)
            {
                for (Store store : storeList)
                {
                    out("Part for " + store.name);
                    out(" ");
                    out("*** Simulation day " + day + " ***");
                    startDay(store, day);
                }
            }
            interaction();
            for (Store store : storeList)
            {
                out("Part for " + store.name);
                out(" ");
                out("*** Simulation day " + days + " ***");
                startDay(store, days);
            }
        }
    }

    private void interaction()
    {
        out("Interaction start");
        // By default choose first store in the list
        Store interactionStore = storeList.get(0);
        int curr = 0;
        while (curr != -1)
        {
            out("Please input a number to select a command for simulation");
            out("(10: Northside, 11: Southside) Select a store to issue commands to ");
            out("2: Ask the clerk their name (should reply with clerk’s name)");
            out("3: Ask the clerk what time it is (should return the time)");
            out("4: Sell a normal inventory item to the clerk – following the normal selling to a store transaction flow – the user can decide whether to accept the buying price the clerk offers at the steps of the sale");
            out("5: Buy a normal inventory item from the clerk (if the item is in inventory), again, this should follow the normal purchase flow – the user can decide not to buy, the clerk will offer a discount, etc.");
            out("6: Buy a custom guitar kit from the clerk");
            out("7: End the interactions\n");
            // wait for user input
            curr = in.nextInt();
            curr = commandInput(curr);
        }
        out("End of Interaction");
    }

    private int commandInput(int curr)
    {
        switch (curr) {
            case 2 : interactionStore.setCommand(new ClerkNameCommand(interactionStore));
                break;
            case 3 : interactionStore.setCommand(new TimeCommand(interactionStore));
                break;
            case 4 : interactionStore.setCommand(new SellCommand(interactionStore));
                break;
            case 5 : interactionStore.setCommand(new BuyCommand(interactionStore));
                break;
                //TODO guitar command
            case 6 : interactionStore.setCommand(new BuyGuitarKitCommand(interactionStore));
                break;
            case 7 : return -1;
            case 10 : interactionStore.setCommand(new SelectStoreCommand(this.storeList.get(0), this));
                      break;
            case 11 : interactionStore.setCommand(new SelectStoreCommand(this.storeList.get(1), this));
                      break;
        }
        interactionStore.excuteCommand();
        return curr;
    }

    void startDay(Store store, int day) {
        if (weekDay == Weekday.SUNDAY) store.closedToday(day);
        else store.openToday(day);
        weekDay = weekDay.next();
    }

    void summary() {
//        out("The summary is left as an exercise to the reader :-)");
    }
}
