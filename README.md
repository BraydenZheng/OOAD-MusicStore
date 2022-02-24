<h2>Team members : Bofan Zheng , Shreyas Savanoor Ravindra , Harini Thorali<h2> <br>
<h3> This project using all example code for Project 2 Part 2 (Bruce Montgomery - 2/14/22 - OOAD CSCI 4/5448 - CU Boulder) </h3>
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

UML change

Observer Design Pattern Implementation: 
We approached the implementation by creating Subject and Observer interfaces. Log class is used to generate the text files and tracker class is used to generate the tracker.txt. Tracker and Log both implements the observer interface and overrides the update function. Log object is created in Store and is used to notify observers.
the final count of money in the cashRegister and the money added to register from goToBank action. <br><br>
Strategy pattern : 
We have used strategy pattern to implement unique tuning algorithm to a clerk when instantiated. For this we have used an abstract class called Tune which contains the tuningTo method and a context class called TuneContext where tune and item objects are instantiated and set and the tuningTo method is called. haphazardTuning , electronicTuning , manualTuning extend the Tuning class and modify tuning algorithm as per the questions. During the doInventory step , the tuning algorithm is set. <br>

Decorator pattern: We add comboSell method to do a chain of additional selling activity (amps, strings, ...) based on the customer buying. Also, we add a new class called AccessoriesDecorator that extend accessories, all original accessories

