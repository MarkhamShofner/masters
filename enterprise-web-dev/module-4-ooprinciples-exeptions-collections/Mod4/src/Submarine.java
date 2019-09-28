
public class Submarine extends Ship {

	int numberTorpedos;
	int FALLBACK = 2;

	public int getNumberTorpedos() {
		return numberTorpedos;
	}

	public void setNumberTorpedos(int numberTorpedos) {
		if (numberTorpedos > 0) {
			this.numberTorpedos = numberTorpedos;
		} else {
			// default to 0 if a negative number has been passed in
			this.numberTorpedos = 0;
		}
	}
	
	public void setNumberTorpedos(String numberTorpedos) {
		try {
			int parsedNumberTorpedos = Integer.parseInt(numberTorpedos);
			this.numberTorpedos = parsedNumberTorpedos;
		} catch (NumberFormatException e) {
			System.out.println("Error in Desroyer:setNumberTorpedos(String):: " + e);
			this.numberTorpedos = FALLBACK;
		}
	}
	
	@Override
	public String toString() {
		return "This Submarine has " + numberTorpedos + " torpedos.";
	}
	
}
