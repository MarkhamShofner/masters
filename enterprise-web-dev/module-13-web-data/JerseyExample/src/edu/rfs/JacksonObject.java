package edu.rfs;

public class JacksonObject {
	
	// number in party, hike, start date and hike duration
	private int durationOption;
	public String hikingOption;
	private int partySize;
	private int StartDate;
	
	/**
	 * @return the durationOption
	 */
	public int getDurationOption() {
		return durationOption;
	}

	/**
	 * @param durationOption the durationOption to set
	 */
	public void setDurationOption(int durationOption) {
		this.durationOption = durationOption;
	}

	/**
	 * @return the hikingOption
	 */
	public String getHikingOption() {
		return hikingOption;
	}

	/**
	 * @param hikingOption the hikingOption to set
	 */
	public void setHikingOption(String hikingOption) {
		this.hikingOption = hikingOption;
	}

	/**
	 * @return the partySize
	 */
	public int getPartySize() {
		return partySize;
	}

	/**
	 * @param partySize the partySize to set
	 */
	public void setPartySize(int partySize) {
		this.partySize = partySize;
	}

	/**
	 * @return the startDate
	 */
	public int getStartDate() {
		return StartDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(int StartDate) {
		this.StartDate = StartDate;
	}

	public JacksonObject() {
		super();
	}
	

	@Override
	public String toString() {
		return "JacksonObject [StartDate=" + StartDate + ", hikingOption=" + hikingOption + ", durationOption=" + durationOption + ", partySize=" + partySize + "]";
	}
	
	
}
