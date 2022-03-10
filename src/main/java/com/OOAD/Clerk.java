package com.OOAD;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Brayden
 * @create 3/8/22 4:15 PM
 * @Description
 */
public  class Clerk extends Staff implements Logger, Observer {
	int daysWorked;
	double damageChance;    // Velma = .05, Shaggy = .20
	Store store;
	Tune tuneAlgorithm;
	int itemsSold;
	int itemsPurchased;
	int itemsDamaged;
	String rndVar1;
	String rndVar2;
	String rndVar3;
	GuitarParts rndPart1;
	GuitarParts rndPart2;
	GuitarParts rndPart3;

	Clerk(String name, double damageChance, Store store, Tune tuneAlgorithm) {
		this.name = name;
		this.damageChance = damageChance;
		this.store = store;
		daysWorked = 0;
		this.itemsSold = 0;
		this.itemsPurchased = 0;
		this.itemsDamaged = 0;
		this.tuneAlgorithm = tuneAlgorithm;
	}

	// code taken from stack overflow
	//https://stackoverflow.com/questions/9832919/generate-poisson-arrival-in-java
	private static int getPoissonRandom(double mean) {
		Random r = new Random();
		double L = Math.exp(-mean);
		int k = 0;
		double p = 1.0;
		do {
			p = p * r.nextDouble();
			k++;
		} while (p > L);
		return k - 1;
	}

	void arriveAtStore() {
		int addItems = 0;

		out(this.name + " arrives at store.");

		//publish event: arriving at store
		store.notifyChanges(this.name + " arrives at store.");

		// have to check for any arriving items slated for this day
		out( this.name + " checking for arriving items.");
		// there's a tricky concurrent removal thing that prevents doing this
		// with a simple for loop - you need to use an iterator
		// https://www.java67.com/2014/03/2-ways-to-remove-elementsobjects-from-ArrayList-java.html#:~:text=There%20are%20two%20ways%20to,i.e.%20remove(Object%20obj).
		Iterator<Item> itr = store.inventory.arrivingItems.iterator();
		while (itr.hasNext()) {
			Item item = itr.next();
			if (item.dayArriving == store.today) {
				out( this.name + " putting a " + item.itemType.toString().toLowerCase() + " in inventory.");
				store.inventory.items.add(item);
				addItems++;
				itr.remove();
			}
		}

		//publishing event: number of items added to inventory
		store.notifyChanges("Number of items added to inventory is " + addItems);
	}

	void checkRegister() {
		out(this.name + " checks: "+Utility.asDollar(store.cashRegister)+" in register.");

		//publish event: check register
		store.notifyChanges(this.name + " checks: " + Utility.asDollar(store.cashRegister) + " in register.");

		if (store.cashRegister<75) {
			out("Cash register is low on funds.");
			this.goToBank();
		}
	}

	void goToBank() {
		out(this.name + " gets money from the bank.");
		store.cashRegister += 1000;
		store.cashFromBank += 1000;
		this.checkRegister();
	}

	void doInventory() {
		out(this.name + " is doing inventory.");
		//setting tune algorithm
		Tune tAlg = this.tuneAlgorithm;
		TuneContext tuneContext = new TuneContext();
		for ( Item item: store.inventory.items){
			tuneContext.setTune(tAlg,item);
			if ((item instanceof Players && !((Players) item).equalized) ||
					(item instanceof Stringed && !((Stringed) item).tuned) ||
					(item instanceof Wind && !((Wind) item).adjusted)) {
				if(Utility.rnd()<=0.1) Item.damageAnItem(item);
			}
		}
		for (ItemType type: ItemType.values()) {
			int numItems = store.inventory.countByType(store.inventory.items,type);
			out(this.name + " counts "+numItems+" "+type.toString().toLowerCase());
			if (numItems == 0) {
				this.placeAnOrder(type);
			}
		}
		int count = store.inventory.items.size();
		double worth = store.inventory.getValue(store.inventory.items);
		out(this.name + " finds " + count + " items in store, worth "+Utility.asDollar(worth));

		//publish event: total number of items, total price and damage items
		store.notifyChanges("Number of items in inventory is " + count);
		store.notifyChanges("The total purchase price value of inventory items is " + Utility.asDollar(worth));
		store.notifyChanges("The total number of items damages is: " + store.inventory.discardedItems.size());
	}

	void placeAnOrder(ItemType type) {
		out(this.name + " needs to order "+type.toString().toLowerCase());
		// order 3 more of this item type
		// they arrive in 1 to 3 days
		int arrivalDay = Utility.rndFromRange(1,3);
		// check to see if any are in the arriving queue
		int count = store.inventory.countByType(store.inventory.arrivingItems,type);
		if (count>0 && !"clothing".equals(type.toString().toLowerCase())) {
			out("There is an order coming for " + type.toString().toLowerCase());
		}
		else {
			// order 3 of the missing items if you have the money to buy them
			for (int i = 0; i < 3; i++) {
				Item item = store.inventory.makeNewItemByType(type);
				if (store.cashRegister > item.purchasePrice) {
					out(this.name + " ordered a " + item.itemType.toString().toLowerCase());
					item.dayArriving = store.today + arrivalDay;
					store.inventory.arrivingItems.add(item);
				}
				else {
					out("Insufficient funds to order this item.");
				}
			}
		}

		//publish event: total number of items ordered
		store.notifyChanges("Number of items in inventory is " + store.inventory.items.size());
	}

	void openTheStore() {
		//int buyers = Utility.rndFromRange(4,10);
		int buyers = 2 + getPoissonRandom(3);
		int sellers = Utility.rndFromRange(1,4);
		out(buyers + " buyers, "+sellers+" sellers today.");
		for (int i = 1; i <= buyers; i++) this.sellAnItem(i);
		for (int i = 1; i <= sellers; i++) this.buyAnItem(i);
	}

	public void sellAnItem(int customer) {
		String custName = "Buyer "+customer;
		out(this.name+" serving "+custName);
		ItemType type = Utility.randomEnum(ItemType.class);
		out(custName + " wants to buy a "+type.toString().toLowerCase());
		int countInStock = store.inventory.countByType(store.inventory.items, type);
		// if no items - bye
		if (countInStock == 0) {
			out (custName + " leaves, no items in stock.");
		}
		else {
			// pick one of the types of items from inventory
			int pickItemIndex = Utility.rndFromRange(1,countInStock);
			Item item = GetItemFromInventoryByCount(countInStock, type);
			out("Item is "+type.toString().toLowerCase()+" in "+item.condition.toString().toLowerCase()+" condition.");
			// 50% chance to buy at listPrice
			out (this.name+" selling at "+Utility.asDollar(item.listPrice));
			if (Utility.rnd()>.5) {
				sellItemtoCustomer(item, custName);
			}
			else {
				// if not, clerk offers 10% off listPrice
				double newListPrice = item.listPrice * .9;
				out (this.name+" selling at "+Utility.asDollar(newListPrice));
				// now 75% chance of buy
				if (Utility.rnd()>.25) {
					item.listPrice = newListPrice;
					sellItemtoCustomer(item,custName);
				}
				else {
					out(custName + " wouldn't buy item.");
				}
			}
		}
	}

	// things we need to do when an item is sold
	void sellItemtoCustomer(Item item,String custName) {
		String itemName = item.itemType.toString().toLowerCase();
		String price = Utility.asDollar(item.listPrice);
		// do combo sale for stringed class
		if (item instanceof Stringed)
		{
			SellDecorator sellDecorator = new SellDecorator();
			sellDecorator.comboSell(this, ((Stringed)item).isElectric, custName, store);
		}

		out(this.name + " is selling " + itemName + " for " + price + " to " + custName);
		// when sold - move item to sold items with daySold and salePrice noted
		out("inventory count: " + store.inventory.items.size());
		store.inventory.items.remove(item);
		out("inventory count: " + store.inventory.items.size());
		item.salePrice = item.listPrice;
		item.daySold = store.today;
		store.inventory.soldItems.add(item);
		// money for item goes to register
		store.cashRegister += item.listPrice;
		this.itemsSold++;

		//publish event: total number of items sold
		store.notifyChanges("Number of items in inventory is " + store.inventory.soldItems.size());
	}

	// find a selected item of a certain type from the items
	Item GetItemFromInventoryByCount(int countInStock, ItemType type) {
		int count = 0;
		for(Item item: store.inventory.items) {
			if (item.itemType == type) {
				count += 1;
				if (count == countInStock) return item;
			}
		}
		return null;
	}

	public void buyAnItem(int customer) {
		String custName = "Seller "+customer;
		out(this.name+" serving "+custName);
		ItemType type = Utility.randomEnum(ItemType.class);
		out(custName + " wants to sell a "+type.toString().toLowerCase());
		if("clothing".equals(type.toString().toLowerCase())) {
			System.out.println("Customer wants to sell clothing item but store is no more accepting this");
		}
		Item item = store.inventory.makeNewItemByType(type);
		// clerk will determine new or used, condition, purchase price (based on condition)
		// we'll take the random isNew, condition from the generated item
		out("Item is "+type.toString().toLowerCase()+" in "+item.condition.toString().toLowerCase()+" condition.");
		item.purchasePrice = getPurchasePriceByCondition(item.condition);
		// seller has 50% chance of selling
		out (this.name+" offers "+Utility.asDollar(item.purchasePrice));
		if (Utility.rnd()>.5) {
			buyItemFromCustomer(item, custName);
		}
		else {
			// if not, clerk will add 10% to purchasePrice
			item.purchasePrice += item.purchasePrice * .10;
			out (this.name+" offers "+Utility.asDollar(item.purchasePrice));
			// seller has 75% chance of selling
			if (Utility.rnd()>.25) {
				buyItemFromCustomer(item, custName);
			}
			else {
				out(custName + " wouldn't sell item.");
			}
		}

		//publish event: total number of items purchased
		store.notifyChanges("Number of items in inventory is " + store.inventory.items.size());
	}

	void buyItemFromCustomer(Item item, String custName) {
		String itemName = item.itemType.toString().toLowerCase();
		String price = Utility.asDollar(item.purchasePrice);
		out (this.name + " is buying "+ itemName + " for " + price +" from "+custName);
		if (store.cashRegister>item.purchasePrice) {
			store.cashRegister -= item.purchasePrice;
			item.listPrice = 2 * item.purchasePrice;
			item.dayArriving = store.today;
			store.inventory.items.add(item);
			this.itemsPurchased++;
		}
		else {
			out(this.name + "cannot buy item, register only has "+Utility.asDollar(store.cashRegister));
		}
	}


	double getPurchasePriceByCondition(Condition condition) {
		int lowPrice = 2*condition.level;
		int highPrice = 10*condition.level;
		return (double) Utility.rndFromRange(lowPrice,highPrice);
	}

	enum Category { A,B,C}

	enum GuitarParts {BRIDGE,KNOBSET,COVERS,NECK,PICKUPS,PICKGUARDS}
	public Object buyGuitarKit(){
		Scanner in = new Scanner(System.in);
		out("Enter the  3 categories for guitar kit creation");
		rndVar1=in.nextLine();
		rndVar2=in.nextLine();
		rndVar3=in.nextLine();

		int curr = GuitarKitFactory.createGuitarKit(rndVar1,rndVar2,rndVar3);


        return curr;
    }



	void cleanTheStore() {
		out(this.name + " is cleaning up the store.");
		if (Utility.rnd()>this.damageChance) {
			out(this.name + " doesn't break anything.");
		}
		else {
			out(this.name + " breaks something!");
			// reduce the condition for a random item
			// take the item off the main inventory and put it on the broken items ArrayList
			// left as an exercise to the reader :-)
			Item item = store.inventory.items.get(Utility.rndFromRange(0,store.inventory.items.size()));
			switch (item.condition){
				case FAIR -> item.condition = Condition.POOR;
				case GOOD -> item.condition = Condition.FAIR;
				case VERYGOOD -> item.condition = Condition.GOOD;
				case EXCELLENT -> item.condition = Condition.VERYGOOD;
			}
			//item removed from inventory and added in discarded items
			store.inventory.items.remove(item);
			store.inventory.discardedItems.add(item);

			this.itemsDamaged++;
			//publish event: total number of items ordered
			store.notifyChanges("Number of items in inventory is " + store.inventory.discardedItems.size());
		}
	}
	void leaveTheStore() {
		out(this.name + " locks up the store and leaves.");

		for (Clerk c : store.clerksTrackerData) {
			if(this.name.equals(c.name)) {
				c.itemsSold += this.itemsSold;
				c.itemsPurchased += this.itemsPurchased;
				c.itemsDamaged += this.itemsDamaged;
			}
		}

		//tracker
		store.track.updateTracker(store.clerksTrackerData);

		store.notifyChanges(this.name + " clerk has left the store");
	}


}
