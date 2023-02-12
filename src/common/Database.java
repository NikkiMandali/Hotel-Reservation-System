package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Database {

	public static List<Room> rooms = new CopyOnWriteArrayList<>(
			Arrays.asList(new Room(1, "Suite", "King Suite", "King sized room with a beach view", 10000.0, 1)));
	public static List<Room> cart = new ArrayList<>();

}
