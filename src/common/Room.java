package common;

import java.io.Serializable;

public class Room implements Serializable {

	private static final long serialVersionUID = 1L;
	public int roomNumber = 1;
	public String type = "Suite";
	public String description = "King Suite";
	public String qualityLevel = "King sized room with a beach view";
	public double price = 0.0;
	public int noOfBeds = 2;

	public Room(int roomNumber, String type, String description, String qualityLevel, double price, int noOfBeds) {
		super();
		this.roomNumber = roomNumber;
		this.type = type;
		this.description = description;
		this.qualityLevel = qualityLevel;
		this.price = price;
		this.noOfBeds = noOfBeds;
	}

	@Override
	public String toString() {
		return "Room [roomNumber=" + roomNumber + ", type=" + type + ", qualityLevel=" + qualityLevel + ", price="
				+ price + ", noOfBeds=" + noOfBeds + "]";
	}

	public Room() {
		super();
	}

}
