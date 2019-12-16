
public class Destroyer extends Ship {

	int numberMissles;
	int FALLBACK = 2;

	public int getNumberMissles() {
		return numberMissles;
	}

	public void setNumberMissles(int numberMissles) {
		if (numberMissles > 0) {
			this.numberMissles = numberMissles;
		} else {
			// default to 0 if a negative number has been passed in
			this.numberMissles = 0;
		}
	}
	
	public void setNumberMissles(String numberMissles) {
		try {
			int parsedNumberMissles = Integer.parseInt(numberMissles);
			if (parsedNumberMissles > 0) {
				this.numberMissles = parsedNumberMissles;
			} else {
				// default to 0 if a negative number has been passed in
				this.numberMissles = 0;
			}
		} catch (NumberFormatException e) {
			System.out.println("Error in Desroyer:setNumberMissles(String):: " + e);
			this.numberMissles = FALLBACK;
		}
	}
	
	@Override
	public String toString() {
		return "This Destroyer has " + numberMissles + " missles.";
	}
	
}
