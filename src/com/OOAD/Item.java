package com.OOAD;

public abstract class Item implements Logger {
    String name;            // I didn't implement a naming scheme - mostly ignoring this - how would you?
    double purchasePrice;   // $1 to $50
    double listPrice;       // purchasePrice x 2
    boolean isNew;          // set by constructor randomly
    int dayArriving;        // 0 at initialization, otherwise set at delivery
    Condition condition;    // set by constructor randomly
    double salePrice;       // set when sold
    int daySold;            // set when sold
    ItemType itemType;      // set by subclass constructors
    static int comboChance;        // the chance to be bought combined with other items

    static Store store;            //store object
    static void damageAnItem(Item i) {
        switch (i.condition){
            case FAIR -> i.condition = Condition.POOR;
            case GOOD -> i.condition = Condition.FAIR;
            case VERYGOOD -> i.condition = Condition.GOOD;
            case EXCELLENT -> i.condition = Condition.VERYGOOD;
        }
        //item removed from inventory and added in discarded items
        store.inventory.items.remove(i);
        store.inventory.discardedItems.add(i);
    }

    public Item() {
        // common initialization of a new instance
        purchasePrice = Utility.rndFromRange(1,50);
        listPrice = 2 * purchasePrice;
        isNew = (Utility.rnd() > .5);  // coin flip for new or used
        dayArriving = 0;
        condition = Utility.randomEnum(Condition.class);
        salePrice = 0;
        daySold = 0;
    };
}

abstract class Music extends Item {
    String band;
    String album;
    String[] bands = {"Yes","Jethro Tull","Rush","Genesis","ELP","Enya"};
    String[] albums = {"Fragile","Stormwatch","2112","Abacab","Tarkus","The Memory of Trees"};
    Music() {
        super();
        band = bands[Utility.rndFromRange(0,bands.length-1)];
        album = albums[Utility.rndFromRange(0,albums.length-1)];
    }
}

class PaperScore extends Music {
    PaperScore() {
        super();
        itemType = ItemType.PAPERSCORE;
    }
}
class CD extends Music {
    CD() {
        super();
        itemType = ItemType.CD;
    }
}
class Vinyl extends Music {
    Vinyl() {
        super();
        itemType = ItemType.VINYL;
    }
}

class Cassette extends Music {
    Cassette() {
        super();
        itemType = ItemType.CASSETTE;
    }
}

abstract class Instrument extends Item {
}

abstract class Stringed extends Instrument {
    public boolean isElectric;
    boolean tuned;
    Stringed() {
        super();
        isElectric = (Utility.rnd()>.5); // coin flip for electric or acoustic
        boolean tuned = false;
    }
}

class Guitar extends Stringed {
    Guitar() {
        super();
        itemType = ItemType.GUITAR;
    }
}
class Bass extends Stringed {
    Bass() {
        super();
        itemType = ItemType.BASS;
    }
}
class Mandolin extends Stringed {
    Mandolin() {
        super();
        itemType = ItemType.MANDOLIN;
    }
}

abstract class Wind extends Instrument {
    boolean adjusted;
    Wind() {
        super();
        boolean adjusted = false;
    }
}

class Flute extends Wind {
    String type;
    String[] types = {"Piccolo","Alto","Bass","Tierce","Concert","Plastic"};
    Flute() {
        super();
        type = types[Utility.rndFromRange(0,types.length-1)];
        itemType = ItemType.FLUTE;
    }
}
class Harmonica extends Wind {
    String key;
    String keys[] = {"E","A","G","C","D"};
    Harmonica() {
        super();
        key = keys[Utility.rndFromRange(0,keys.length-1)];
        itemType = ItemType.HARMONICA;
    }
}

class Saxophone extends Wind {
    String type;
    String[] types = {"Piccolo","Alto","Bass","Tierce","Concert","Plastic"};
    Saxophone() {
        super();
        type = types[Utility.rndFromRange(0,types.length-1)];
        itemType = ItemType.SAXOPHONE;
    }
}

abstract class Accessories extends Item {
}

abstract class Players extends Item {
    public boolean equalized;
    Players() {
        super();
        equalized = false;
    }
}

class CDPlayers extends Players
{
    public CDPlayers()
    {
    	super();
    	itemType = ItemType.CDPLAYER;
    }
}

class RecordPlayers extends Players
{
    public RecordPlayers()
    {
        super();
        itemType = ItemType.RECORDPLAYER;
    }
}

class MP3 extends Players
{
    public MP3()
    {
        super();
        itemType = ItemType.MP3;
    }
}

class CassettePlayers extends Players
{
    public CassettePlayers()
    {
        super();
        itemType = ItemType.CASSETTEPLAYER;
    }
}

