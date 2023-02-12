package hotel;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import common.Employee;
import common.User;


public class EmployeeImpl extends UnicastRemoteObject implements Employee {

	protected EmployeeImpl() throws RemoteException {
		super();
	}

	private static final long serialVersionUID = 1L;

	@Override
	public User getUser(String userType) throws RemoteException {
		return null;
	}

}
