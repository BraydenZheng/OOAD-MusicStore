package com.OOAD;

import com.OOAD.Command.BuyCommand;
import com.OOAD.Command.Command;
import com.OOAD.Command.SellCommand;
import com.OOAD.Command.TimeCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Brayden
 * @create 3/7/22 10:44 PM
 * @Description
 */
public class UnitTest
{

	@Test
	public void TestStoreNumber() {
		Simulation s = new Simulation();
		int storeNumber = s.storeList.size();
		assertEquals(storeNumber, 2);
	}

	@Test
	public void TestCommand() {
		Simulation s = new Simulation();
		Command time = new TimeCommand(s.interactionStore);
		s.interactionStore.setCommand(time);
		assertEquals(s.interactionStore.currentCommand, time);
	}

	@Test
	public void TestSellCommand() {
		Simulation s = new Simulation();
		Command sell = new SellCommand(s.interactionStore);
		s.interactionStore.setCommand(sell);
		assertEquals(s.interactionStore.currentCommand, sell);
	}

	@Test
	public void TestBuyCommand() {
		Simulation s = new Simulation();
		Command buy = new BuyCommand(s.interactionStore);
		s.interactionStore.setCommand(buy);
		assertEquals(s.interactionStore.currentCommand, buy);
	}

	@Test
	public void TestStoreName() {
		String north = "northSide";
		Store a = new Store(north);
		assertEquals(a.name, north);
	}

}
