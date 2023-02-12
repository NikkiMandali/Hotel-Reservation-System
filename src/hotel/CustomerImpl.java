package hotel;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import common.Customer;
import common.Database;
import common.Room;
import common.User;

public class CustomerImpl extends UnicastRemoteObject implements Customer {

	private static final long serialVersionUID = 1L;

	CustomerImpl() throws RemoteException {
		super();
	}

	public String book() {
		System.out.println("CustomerImpl server: got request from client to book ");
		System.out.println("-----------------------------------");
		if (Database.cart == null)
			return "Empty Cart";
		else
			return "Successful Purchase";
	}

	public void addToCart(Room p) {
		Database.cart.add(p);
		System.out.println("Room successfully added to cart ");
		System.out.println("-----------------------------------");
	}

	public List<Room> browseRooms() {
		System.out.println("Below are the available rooms");
		System.out.println("-----------------------------------");
		return Database.rooms;
	}

	@Override
	public User getUser(String userType) throws RemoteException {
		return null;
	}

}
