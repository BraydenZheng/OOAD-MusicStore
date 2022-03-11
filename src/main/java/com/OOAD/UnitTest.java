package com.OOAD;

import com.OOAD.Command.BuyCommand;
import com.OOAD.Command.Command;
import com.OOAD.Command.SellCommand;
import com.OOAD.Command.TimeCommand;
import org.junit.jupiter.api.Test;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

import static com.OOAD.ItemType.CDPLAYER;
import static org.junit.jupiter.api.Assertions.*;

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

	@Test
	public void TestRegisterObserver() {
		String north = "northSide";
		Store s = new Store(north);
		assertEquals(s.getObserversCount(), 1);
	}

	@Test
	public void TestRemoveObserver() {
		String north = "northSide";
		Store s = new Store(north);
		Tune haphazardTuning = new haphazardTuning();
		s.removeObserver(new Clerk("observer", 0.5, s, haphazardTuning));
		assertEquals(s.getObserversCount(), 1);
	}

	@Test
	public void TestLogInstance() {
		Log log1, log2;
		log1 = Log.getLogInstance();
		log2 = Log.getLogInstance();
		assertEquals(log1, log2);
	}

	@Test
	public void TestTrackerInstance() {
		Tracker tracker1, tracker2;
		tracker1 = Tracker.getTrackInstance();
		tracker2 = Tracker.getTrackInstance();
		assertEquals(tracker1, tracker2);
	}

	@Test
	public void TestSetDay() {
		Log log;
		log = Log.getLogInstance();
		log.setDay(30);
		assertEquals(log.getDay(), 30);
	}

	@Test
	public void TestGuitarKit(){
		Tune haphazardTuning = new haphazardTuning();
		Store store = new Store("NorthStore");
		Clerk clerk = new Clerk("Daphne",0.5,store,haphazardTuning);
		int price = (int) GuitarKitFactory.createGuitarKit("A","A","A","A","A","A");
		assertEquals(180,price);
	}

	@Test
	public void TestGuitarKit0(){
		String temp;
		Tune haphazardTuning = new haphazardTuning();
		Store store = new Store("NorthStore");
		Clerk clerk = new Clerk("Daphne",0.5,store,haphazardTuning);
		int price = (int) GuitarKitFactory.createGuitarKit("A","B","C","A","B","C");
		assertFalse(price==0);

	}
	@Test
	public void TestGuitarKitNull(){
		Tune haphazardTuning = new haphazardTuning();
		Store store = new Store("NorthStore");
		Clerk clerk = new Clerk("Daphne",0.5,store,haphazardTuning);
		int price = (int) GuitarKitFactory.createGuitarKit("A","C","A","B","C","A");
		assertNotNull(price);

	}
	@Test
	public void TestPurchasePrice() {
		Store store = new Store("SouthStore");
		Tune haphazardTuning = new haphazardTuning();
		Clerk clerk = new Clerk("Daphne",0.5,store,haphazardTuning);
		int price = (int) clerk.getPurchasePriceByCondition(Condition.POOR);
		assertNotNull(price);
	}
	@Test
	public void TestTuning() {
		Store store = new Store("SouthStore");
		Tune manualTuning = new manualTuning();
		Item item = new CassettePlayers();
		manualTuning.tuningTo(item);
		assertTrue(((Players) item).equalized);
	}

}
