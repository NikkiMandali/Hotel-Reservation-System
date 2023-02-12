package common;
import java.rmi.*;

public interface Admin extends User {
	
	public void addRoom(Room p) throws RemoteException;
	public void deleteRoom(int n) throws RemoteException;
	public void updateRoom(int n, Room q) throws RemoteException;
}
