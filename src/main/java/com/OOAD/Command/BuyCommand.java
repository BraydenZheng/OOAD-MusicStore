package com.OOAD.Command;

import com.OOAD.Clerk;
import com.OOAD.Store;

/**
 * @author Brayden
 * @create 3/8/22 6:00 PM
 * @Description
 */
public class BuyCommand extends StoreCommand
{

	public BuyCommand(Store store)
	{
		super(store);
	}

	@Override
	public void excute()
	{
		// -1 indicates the customer is useSellCommandr
		//System.out.println(this.store.activeClerk.name);
		this.store.activeClerk.buyAnItem(-1);
	}
}
