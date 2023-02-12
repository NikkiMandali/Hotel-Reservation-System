package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

import common.Admin;
import common.Customer;
import common.Room;
import common.User;
import hotel.UserFactory;

public class Client {

	public static void main(String args[]) {
		try {
			// String host = args[0];
			// int port = Integer.parseInt(args[1]);

			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			Scanner readObj = new Scanner(System.in);

			// String name = "//"+host+":"+port+"/RemoteAdder_complex";
			// Registry registry = LocateRegistry.getRegistry(host, port);
			// User stub = (User)registry.lookup(name);
			User stub = new UserFactory();
			// System.out.println("Found server object at "+name);

			int i = 0;
			
			while (i != 4) {
				
				System.out.println("Select from below which describes you the best\n");
				System.out.println("1. Customer 2. Admin 3. Employee 4. Exit\n");
				i = readObj.nextInt();
				switch (i) {

				case 1:
					int j = 0;
					while (j != 3) {
						System.out.println("Select one of the option below\n");
						System.out.println("1. Browse Rooms 2. Make a Reservation 3. Back\n");
						j = readObj.nextInt();

						switch (j) {
						case 1:
							List<Room> items = ((Customer) stub.getUser("CUSTOMER")).browseRooms();
							System.out.println("Below are the available rooms in the hotel");
							System.out.println(items);
							int k = 0;
							while (k != 2) {
								System.out.println("Select one of the option below\n");
								System.out.println("1. Add to cart 2. Back\n");
								k = readObj.nextInt();

								switch (k) {
								case 1:
									Room x = new Room();
									System.out.println("Enter the room number to be added? \n");
									int y = reader.read();
									for (Room temp : items) {
										if (temp.roomNumber == y)
											x = temp;
									}
									((Customer) stub.getUser("CUSTOMER")).addToCart(x);
									System.out.println("------ Room added to cart successfully------ \n");
									break;
								case 2:
									break;
								default:
									System.out.println("Wrong Option");
								}
							}
							break;
						case 2:
							String purch = ((Customer) stub.getUser("CUSTOMER")).book();
							System.out.println(purch);
							System.out.println("------ Thank you ------ \n");
							break;
						case 3:
							break;
						default:
							System.out.println("Wrong Option");
						}
					}
					break;
				case 2:
					int m = 0;
					while (m != 4) {
						System.out.println("Select one of the option below\n");
						System.out.println("1. Add Room 2. Delete Room 3. Update Room 4. Back\n");
						m = readObj.nextInt();

						switch (m) {
						case 1:
							System.out.println("Enter Room Number");
							int roomNum = reader.read();
							System.out.println("Enter Type");
							String type = reader.readLine();
							System.out.println("Enter Description");
							String desc = reader.readLine();
							System.out.println("Enter Quality Level");
							String qv = reader.readLine();
							System.out.println("Enter Price");
							double price = readObj.nextDouble();
							System.out.println("Enter Number of Beds");
							int numBeds = reader.read();
							
							((Admin) stub.getUser("ADMIN")).addRoom(new Room(roomNum, type, desc, qv, price, numBeds));
							System.out.println("------ Room added successfully------ \n");
							break;
						case 2:
							System.out.println("Enter the number of the room to be deleted? \n");
							int title1 = reader.read();
							((Admin) stub.getUser("ADMIN")).deleteRoom(title1);
							System.out.println("------ Room deleted successfully------ \n");
							break;
						case 3:
							System.out.println("Enter the number of the room to be updated? \n");
							int roomNum1 = reader.read();
							System.out.println("Enter Latest Type");
							String type1 = reader.readLine();
							System.out.println("Enter Latest Description");
							String desc1 = reader.readLine();
							System.out.println("Enter Latest Quality Level");
							String qv1 = reader.readLine();
							System.out.println("Enter Latest Price");
							double price1 = readObj.nextDouble();
							System.out.println("Enter Latest Beds in the room \n");
							int numBeds1 = reader.read();
							((Admin) stub.getUser("ADMIN")).updateRoom(roomNum1,
									new Room(roomNum1, type1, desc1, qv1, price1, numBeds1));
							System.out.println("------ Room Updated successfully------ \n");
							break;
						case 4:
							break;
						default:
							System.out.println("Wrong Option");
						}
					}
					break;
					
				case 3:
					
					
				case 4:
					break;
					
				default:
					System.out.println("Wrong Option");

				}
			}
			
		} catch (Exception e) {
			System.out.println("Client err : " + e.getMessage());
			e.printStackTrace();
		}
	}
}
