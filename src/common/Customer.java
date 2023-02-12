package common;
import java.rmi.*;
import java.util.List;

public interface Customer extends User{

        public String book() throws RemoteException;
        public List<Room> browseRooms() throws RemoteException;
        public void addToCart(Room p) throws RemoteException;
}

