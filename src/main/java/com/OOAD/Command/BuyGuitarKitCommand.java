package com.OOAD.Command;


import com.OOAD.Clerk;
import com.OOAD.Store;

public class BuyGuitarKitCommand extends StoreCommand
{

    public BuyGuitarKitCommand(Store store) {
        super(store);
    }

    @Override
    public void excute()
    {
        // calls the method for creating the guitar kit
        this.store.activeClerk.buyGuitarKit();
    }
}
