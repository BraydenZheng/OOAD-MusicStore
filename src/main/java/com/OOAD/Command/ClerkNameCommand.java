package com.OOAD.Command;

import com.OOAD.Store;

/**
 * @author Brayden
 * @create 3/8/22 3:48 PM
 * @Description
 */
public class ClerkNameCommand extends StoreCommand
{
	public ClerkNameCommand(Store store)
	{
		super(store);
	}

	@Override
	public void excute() {
		out(this.store.activeClerk.name);
	}
}
