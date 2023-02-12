package hotel;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import common.User;

public class Hotel {
	
	public static void main(String args[]) {
        try {
                String host = args[0];
                int port = Integer.parseInt(args[1]);
                User remote_obj = new UserFactory();

                String name = "//"+host+":"+port+"/RemoteAdder_complex";
             
                Registry registry = LocateRegistry.getRegistry(port);
                registry.rebind(name,(Remote) remote_obj);
            
                System.out.println("[4] Complex RemoteAdder Server is ready at "+name);

        } catch(Exception e) {
                System.out.println("[4] Complex RemoteAdder Server err: " + e.getMessage());
                e.printStackTrace();
        }
}

}
