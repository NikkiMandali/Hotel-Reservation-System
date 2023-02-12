package common;

import java.rmi.RemoteException;
import java.rmi.Remote;

public interface User extends Remote {
	
	public User getUser(String userType) throws RemoteException;

}
