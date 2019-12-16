
public class P3 extends Aircraft {

	int numberEngines;

	public int getNumberEngines() {
		return numberEngines;
	}

	public void setNumberEngines(int numberEngines) {
		if (numberEngines > 0) {
			this.numberEngines = numberEngines;
		} else {
			// default to 0 if a negative number has been passed in
			this.numberEngines = 0;
		}
	}
	
	@Override
	public String toString() {
		return "This P3 has " + numberEngines + " engines.";
	}
	
}
