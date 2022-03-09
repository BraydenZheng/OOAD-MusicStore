package com.OOAD.Command;

import com.OOAD.Store;

/**
 * @author Brayden
 * @create 3/8/22 6:00 PM
 * @Description
 */
public class SellCommand extends StoreCommand
{

	public SellCommand(Store store)
	{
		super(store);
	}

	@Override
	public void excute()
	{
		// -1 indicates the customer is useSellCommandr
		this.store.activeClerk.sellAnItem(-1);
	}
}
