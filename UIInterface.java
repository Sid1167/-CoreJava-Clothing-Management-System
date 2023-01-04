package CoreJavaProject;

import java.sql.SQLException;
import java.util.Scanner;


public class UIInterface {
	
	public static void StartApp() throws SQLException {
		System.out.println("*******// Wellcome to 51Clothing \\\\*******");
		Scanner s = new Scanner(System.in);
		while(true) {
			System.out.println("Sellect the operation you want to perform");
			System.out.println("1. Show all Clothing Details");
			System.out.println("2. Find Clothing by id");
			System.out.println("3. Find Clothing by name");
			System.out.println("4. Add Clothing");
			System.out.println("5. Update Clothing");
			System.out.println("6. Delete Clothing");
			System.out.println("7. Chat Bot");
			System.out.println("0. Quit");
			
			int choice = s.nextInt();
			if (choice==0) {
				System.out.println("********* Thank You *********");
				break;
			}
			else {
				int id, quantity;
				String name;
				double price;
				
				switch(choice){
					case 1:{
						System.out.println(DatabaseInterface.getAll());
						break;
					}
					case 2:{
						System.out.println("Provide the ID of the Clothing : ");
						id = s.nextInt();
						System.out.println(DatabaseInterface.getbyId(id));
						break;
					}
					case 3:{
						System.out.println("Provide the Name of the Clothing : ");
						name = s.next();
						System.out.println(DatabaseInterface.getbyName(name));
						break;
					}
					case 4:{
						System.out.print("Enter ID: ");
						id = s.nextInt();
						System.out.print("Enter Name: ");
						name = s.next();
						System.out.print("Enter Price: ");
						price = s.nextDouble();
						System.out.print("Enter Quantity: ");
						quantity = s.nextInt();
						System.out.println(DatabaseInterface.add(id, name, price, quantity));
						break;
					}
					case 5:{
						System.out.print("Provide the ID of the product to be updated: ");
						id = s.nextInt();
						System.out.println("Choose the detail to be updated:");
						System.out.println("1. Name");
						System.out.println("2. Price");
						System.out.println("3. Quantity");
						System.out.print("Enter Your Choice: ");
						int upChoice = s.nextInt();
						switch(upChoice) {
							case 1: System.out.print("Enter New Name: ");
									name = s.next();
									System.out.println(DatabaseInterface.updateName(id, name));
									break;
							case 2: System.out.print("Enter New Price: ");
									price = s.nextDouble();
									System.out.println(DatabaseInterface.updatePrice(id, price));
									break;
							case 3: System.out.print("Enter New Quantity: ");
									quantity = s.nextInt();
									System.out.println(DatabaseInterface.updateQuantity(id, quantity));
									break;
							default: System.out.println("\n\n *** WRONG CHOICE *** \n\n");
						}
						break;
					}
					case 6:{
						System.out.print("Provide the ID of the product to be deleted: ");
						id = s.nextInt();
						System.out.println(DatabaseInterface.delete(id));
						break;
					}
					case 7:{
						Scanner input = new Scanner(System.in);
						String cname;
						int cage;
						String ccity;
						String convo;
//						String h = "Help";
//						String b = "Bye";
						
						System.out.println("Hello, I am Emo your Friendly ChatBot ");
						System.out.println();
						System.out.println("What is your name?");
						cname = input.nextLine();
						System.out.println();
						System.out.println("Nice to meet you, " + cname + "! How old are you?");
						cage = input.nextInt();
						System.out.println();
						if(cage<35) {
							System.out.println("I see that you are still quite young at only " + cage + ".");
						}
						else {
							System.out.println("I see that you are " + cage + ".");
						}
						System.out.println();
						System.out.println("Where do you live?");
						System.out.println();
						input.nextLine();
						ccity = input.nextLine();
						System.out.println();
						System.out.println("Wow! I've always wanted to go to " + ccity + ".");
						System.out.println();
						System.out.println("How can i Help you ?");
						System.out.println();
//						System.out.println("............");
						s.nextLine();
						convo = s.nextLine();
						System.out.println("********* Sorry for the inconvenience *********");
						System.out.println("You can try Contacting us on our Email with your Order Details. \n51Clothing@gmail.com");
						/*
						if(convo == h) {
							System.out.println("You can try Contacting us on our Email \n51Clothing@gmail.com");
						}
						*/
						System.out.println();
						convo = s.nextLine();
						System.out.println("Thanks for chatting with me. Bye!");
						/*
						if(convo == b) {
							System.out.println("Thanks for chatting with me. Bye!");
						}
						*/
						System.out.println();
						input.close();
						break;
					}
					default:{
						System.out.println("Enter the correct choice ");				
						break;
					} 
				}
			}
		}
	}
}
