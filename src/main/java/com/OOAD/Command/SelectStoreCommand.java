package com.OOAD.Command;

import com.OOAD.Simulation;
import com.OOAD.Store;

/**
 * @author Brayden
 * @create 3/8/22 8:45 PM
 * @Description
 */
public class SelectStoreCommand extends StoreCommand
{
	private Simulation simulation;

	public SelectStoreCommand(Store store, Simulation simulation)
	{
		super(store);
		this.simulation = simulation;
	}

	@Override
	public void excute()
	{
		simulation.interactionStore = store;
	}
}
