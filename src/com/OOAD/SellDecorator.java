package com.OOAD;

/**
 * @author Brayden
 * @create 2/22/22 5:31 PM
 * @Description
 */
public class SellDecorator implements Logger
{
	public void comboSell(Clerk clerk, Boolean isElectric, String custName, Store store) {
		int chanceDeduct = isElectric ? 0 : 10;
		AccessoryDecorator item = new AccessoryDecorator();

		int toss = Utility.rndFromRange(0, 100);
		int countInStock = store.inventory.countByType(store.inventory.items, ItemType.GIGBAG);

		if (countInStock > 0 && toss < GigBagAddon.comboChance - chanceDeduct) {
			int pickItemIndex = Utility.rndFromRange(1,countInStock);
			Item curr = clerk.GetItemFromInventoryByCount(countInStock, ItemType.GIGBAG);
			clerk.sellItemtoCustomer(curr, custName);
			item = new GigBagAddon(item);
		}

		if (countInStock > 0 && toss < PracticeAmpsAddons.comboChance - chanceDeduct) {
			int pickItemIndex = Utility.rndFromRange(1,countInStock);
			Item curr = clerk.GetItemFromInventoryByCount(countInStock, ItemType.PRACTICEAMPS);
			clerk.sellItemtoCustomer(curr, custName);
			item = new PracticeAmpsAddons(item);
		}

		for (int i = 0; i < 1; i++)
		{
			if (countInStock > 0 && toss < CablesAddon.comboChance - chanceDeduct)
			{
				int pickItemIndex = Utility.rndFromRange(1, countInStock);
				Item curr = clerk.GetItemFromInventoryByCount(countInStock, ItemType.CABLES);
				clerk.sellItemtoCustomer(curr, custName);
				item = new CablesAddon(item);
			}
		}

		for (int i = 0; i < 2; i++)
		{
			if (countInStock > 0 && toss < StringsAddon.comboChance - chanceDeduct)
			{
				int pickItemIndex = Utility.rndFromRange(1, countInStock);
				Item curr = clerk.GetItemFromInventoryByCount(countInStock, ItemType.STRINGS);
				clerk.sellItemtoCustomer(curr, custName);
				item = new StringsAddon(item);
			}
		}
		out(clerk.name + " selling " + item.name);     // combined decorated name
		out(clerk.name + " for " + item.salePrice);
	}

}
