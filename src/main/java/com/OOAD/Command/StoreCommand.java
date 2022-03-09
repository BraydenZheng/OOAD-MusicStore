package com.OOAD.Command;

import com.OOAD.Logger;
import com.OOAD.Store;

/**
 * @author Brayden
 * @create 3/8/22 3:43 PM
 * @Description
 */
public abstract class StoreCommand implements Command, Logger
{
	Store store;

	public StoreCommand(Store store)
	{
		this.store = store;
	}

//	@Override
//	public void excute()
//	{
//		System.out.println(1);
//	}
}
