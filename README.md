<h2>Team members : Bofan Zheng , Shreyas Savanoor Ravindra , Harini Thorali<h2> <br>
<h3>JAVA version: 13</h3>
<h3> Assumptions and implementations :</h3>
We have used Item class. Classes Music , Players , Instruments, Clothing,Accessories
inherit Item class. Classes PaperScore, CD, Vinyl inherit Music , Classes CD Players,
RecordPlayer, MP3 inherit Players. Classes Stringed and Wind inherit Instruments.Similarly,
other classes are created and inherited according to the UML diagram. We have used multi-level inheritance.
We have defined a Clerk class which inherits the Staff class. The clerk performs the following functions- 
checkRegister, goToBank, doInventory,placeOrder,openStore,cleanStore, leaveTheStore. The customer class
implements buy and sell methods as per the requirements and in the UML diagram. 
<br>The Simulator class runs for 30 days
doing the following in order- checkRegister , doInventory, openStore and then print the itemsLeft, the items sold and the price, 
the final count of money in the cashRegister and the money added to register from goToBank action.


Observer Design Pattern Implementation: 
We approached the implementation by creating Subject and Observer interfaces. Log class is used to generate the text files and tracker class is used to generate the tracker.txt. Tracker and Log both implements the observer interface and overrides the update function. Log object is created in Store and is used to notify observers.
<br><br>
