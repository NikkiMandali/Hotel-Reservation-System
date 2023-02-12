package hotel;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import common.User;

public class UserFactory extends UnicastRemoteObject implements User {

	private static final long serialVersionUID = 1L;

	public UserFactory() throws RemoteException {
		super();
	}

	public User getUser(String userType) throws RemoteException {

		if (userType == null) {
			return null;
		}

		if (userType.equalsIgnoreCase("ADMIN")) {
			return new AdminImpl();
		} else if (userType.equalsIgnoreCase("CUSTOMER")) {
			return new CustomerImpl();
		} else if (userType.equalsIgnoreCase("EMPLOYEE")) {
			return new EmployeeImpl();
		}
		return null;
	}
}
