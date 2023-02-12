package hotel;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import common.Admin;
import common.Database;
import common.Room;
import common.User;

public class AdminImpl extends UnicastRemoteObject implements Admin {

	private static final long serialVersionUID = 1L;

	AdminImpl() throws RemoteException {
		super();
	}

	public void addRoom(Room p) {
		Database.rooms.add(p);
		System.out.println("Room successfully added to database ");
		System.out.println("-----------------------------------");
	}

	public void deleteRoom(int n) {
		for (Room temp : Database.rooms) {
			if (temp.roomNumber == n)
				Database.rooms.remove(temp);
		}
		System.out.println("Room successfully deleted from database");
		System.out.println("-----------------------------------");
	}

	public void updateRoom(int n, Room q) {
		deleteRoom(n);
		addRoom(q);
		System.out.println("Room successfully updated in the database ");
		System.out.println("-----------------------------------");
	}

	@Override
	public User getUser(String userType) throws RemoteException {
		return null;
	}

}
