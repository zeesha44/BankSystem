package bank;
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors

import java.util.*;  

public class Register {
	public static String firstName;
	public static String lastName;
	public static String accountType;
	
	static Scanner in= new Scanner(System.in);
	
	public static void register(){
		System.out.println("enter first name");
		firstName= in.nextLine();
		System.out.println("enter last name");
		lastName= in.nextLine();
		System.out.println("enter Acount Type (Savings or Current)");
		accountType= in.nextLine();
		
		
		try {
			FileWriter myWriter = new FileWriter("bank.txt", true);
		      myWriter.write("Name: "+ firstName + ""+ lastName);
		      myWriter.write(" ");
		      myWriter.write(accountType);
		      myWriter.write(" ");
		      myWriter.close();
		   //   System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
	
	}	
}
