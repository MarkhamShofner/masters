package HelloWorldJSP;

public class Hike {
    private String firstName = null;
    private String lastName = null;
    private String hikingOption = null;
    private int partySize = 0;
    private String StartDate = null;
    private int durationOption = 0;
        
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String name) {
    	this.firstName = name;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String name) {
    	this.lastName = name;
    }

    public String getHikingOption() {
        return hikingOption;
    }
    
    public void setHikingOption(String option) {
    	this.hikingOption = option;
    }
}

