package com.OOAD;

/**
 * @Reference Class decoration example
 * @create 2/22/22 5:06 PM
 * @Description
 */
public class AccessoryDecorator extends Accessories
{
	public AccessoryDecorator()
	{
		super();
	}
	Accessories component;
}


class GigBagAddon extends AccessoryDecorator {
	GigBagAddon() {
		super();
		name = "Gig Bag";
		itemType = ItemType.GIGBAG;
		comboChance = 25;
	}
	GigBagAddon(Accessories component) {
		this.component = component;
		name = component.name + " and GigBag";
		salePrice += component.salePrice;
	}
}

class PracticeAmpsAddons extends AccessoryDecorator{
	int wattage;
	PracticeAmpsAddons() {
		super();
		name = "Practice Amps";
		wattage = Utility.rndFromRange(0, 220);
		itemType = ItemType.PRACTICEAMPS;
		comboChance = 25;
	}
	PracticeAmpsAddons(Accessories component) {
		this.component = component;
		name = component.name + " and Practice Amps";
		salePrice += component.salePrice;
	}
}

class CablesAddon extends AccessoryDecorator{
	int length;
	CablesAddon() {
		super();
		name = "Cables";
		length = Utility.rndFromRange(0, 50);
		itemType = ItemType.CABLES;
		comboChance = 30;
	}
	CablesAddon(Accessories component) {
		this.component = component;
		name = component.name + " and Cables";
		salePrice += component.salePrice;
	}
}

class StringsAddon extends AccessoryDecorator{
	String type;
	String types[] = {"E","A","G","C","D"};
	StringsAddon() {
		super();
		name = "Strings";
		type =  types[Utility.rndFromRange(0, types.length - 1)];
		itemType = ItemType.STRINGS;
		comboChance = 40;
	}
	StringsAddon(Accessories component) {
		this.component = component;
		name = component.name + " and Strings";
		salePrice += component.salePrice;
	}
}

