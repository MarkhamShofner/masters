
public abstract class Ship implements Contact {
	
	int length;
	int speed;
	String name;
	String type;
	
	
	// interface overrides
	@Override
	public int getLength() {
		return length;
	}

	@Override
	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public int getSpeed() {
		return speed;
	}
	
	@Override
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public void setSpeed(String speed) {
		int parsedSpeed = Integer.parseInt(speed);
		this.speed = parsedSpeed;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public void setType(String type) {
		this.type = type;
	}

}
