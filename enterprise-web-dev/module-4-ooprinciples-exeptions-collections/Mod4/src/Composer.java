import java.util.ArrayList;
import java.util.List;

public class Composer {
    public static void main(String[] args) {
    	
    	System.out.println("---Start of Main Method---");
    	
    	// create 2 destroyers
    	Destroyer firstDestroyer = new Destroyer ();
    	Destroyer secondDestroyer = new Destroyer ();

    	// create 2 submarines
    	Submarine firstSubmarine = new Submarine ();
    	Submarine secondSubmarine = new Submarine ();
    	
    	// create 2 P3s
    	P3 firstP3 = new P3 ();
    	P3 secondP3 = new P3 ();
    	
    	
    	// Make a collection of Destroyers (you select the type of Collection)
    	List<Destroyer> destroyersList = new ArrayList<>();
        destroyersList.add(firstDestroyer);
        destroyersList.add(secondDestroyer);
        
		// Make a collection of Submarines (you select the type)
    	List<Submarine> submarinesList = new ArrayList<>();
        submarinesList.add(firstSubmarine);
        submarinesList.add(secondSubmarine);
        
		// Make a collection that holds all Ships
    	List<Ship> shipsList = new ArrayList<>();
        shipsList.add(firstDestroyer);
        shipsList.add(secondDestroyer);
        shipsList.add(firstSubmarine);
        shipsList.add(secondSubmarine);
        
        // set a few properties on the instances of the classes
    	firstDestroyer.setNumberMissles(25);
    	secondDestroyer.setNumberMissles(4);
    	firstSubmarine.setNumberTorpedos(8);
    	secondSubmarine.setNumberTorpedos(16);
//    	secondSubmarine.setNumberTorpedos("foo");
        firstP3.setNumberEngines(3);;
        secondP3.setNumberEngines(1);;
        
		// Make a collection that holds all Contacts
    	List<Contact> contactsList = new ArrayList<>();
        contactsList.add(firstDestroyer);
        contactsList.add(secondDestroyer);
        contactsList.add(firstSubmarine);
        contactsList.add(secondSubmarine);
        contactsList.add(firstP3);
        contactsList.add(secondP3);
    	

        // Print out the list of Contacts
        for (int i = 0; i < contactsList.size(); i++) {
            System.out.println(contactsList.get(i).toString()); 
        }
            	
    	System.out.println("----End of Main Method----");
    	
    }

}
