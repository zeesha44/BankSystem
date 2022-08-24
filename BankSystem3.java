
package bank;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors

import java.util.*;  
import java.text.DecimalFormat;


public class BankSystem3 {
	
	//private static double amount;
	private static double balance;
	private static double withdraw;
	private static double deposit;
	static Scanner in= new Scanner(System.in);
	static DecimalFormat df = new DecimalFormat("#");
	
	
	public static void menu(){
		 
		 
		
		class Account extends Register{
			

		public void Balance(){
		//	Balance b = new Balance; 
			//Scanner in = new Scanner(System.in);
			//double balance = 0;
			df.setMaximumFractionDigits(8);
			System.out.println(firstName + "  " + lastName);
			System.out.println(("YOUR ACCOUNT BALANCE IS ")+ df.format(balance));
			System.out.println("enter 1 to return to menu ");
			int x= in.nextInt();
			while(x==1){
				menu();
			}
			
			
			
			
		}
		public double Deposit(){
			//double balance = 0;
			//amount;
			//Scanner in = new Scanner(System.in);
			df.setMaximumFractionDigits(10);
			System.out.println("enter amount");
			deposit = in.nextInt();
			if ( accountType.equalsIgnoreCase("savings")) {
				 if (deposit > 200000) {
						System.out.println("You can not Deposite more than a 200,000");
					}
			}
			else {balance = balance+deposit;}
			try {
			      FileWriter myWriter = new FileWriter("bank.txt", true);
			      myWriter.write("Amount Deposited: "+deposit+ " Account balance: "+balance);
			      myWriter.write(" ");
			      myWriter.close();
			    } catch (IOException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			    }
			System.out.println("CURRENT BALANCE IS "+ df.format(balance));
			System.out.println("enter 1 to return to menu");
			int x = in.nextInt();
			while(x==1){
				menu();
			}
			
			return balance;
			
		}
		public void Withdrawal(){
			
			df.setMaximumFractionDigits(8);
			System.out.println("enter amount");
			withdraw= in.nextInt();
			 if ( accountType.equalsIgnoreCase("savings")) {
				 if (withdraw > 100000) {
						System.out.println("You can not withdraw more than a 100,000");
					}
				 else if(withdraw>balance){
				System.out.println("ERROR  INSUFFICIENT BALANCE");
				
					
				}
			}
			else{
				balance = balance-withdraw;
				System.out.println("CURRENT BALANCE IS "+ df.format(balance));
				try {
				      FileWriter myWriter = new FileWriter("bank.txt", true);
				      myWriter.write("Amount Withdrawn "+withdraw+  " Account balance: "+balance);
				      myWriter.write(" ");
				      myWriter.close();
				    } catch (IOException e) {
				      System.out.println("An error occurred.");
				      e.printStackTrace();
				    }
			}
			System.out.println("enter 1 to return to menu ");
			int x= in.nextInt();
			while(x==1){ 
				menu();
			}
		}
			public void Overview(){
				
				try {
				      File myObj = new File("bank.txt");
				      Scanner myReader = new Scanner(myObj);
				      while (myReader.hasNextLine()) {
				        String data = myReader.nextLine();
				        System.out.println(data);
				      }
				      myReader.close();
				    } catch (FileNotFoundException e) {
				      System.out.println("An error occurred.");
				      e.printStackTrace();
				    }

			}
			
		}
			
		
		
		Account a = new Account();
		 
		
		Scanner in= new Scanner(System.in);
		System.out.println("1......CHECK BALANCE");
		System.out.println("2......DEPOSIT");
		System.out.println("3......WITHDRAW");
		System.out.println("4......OVERVIEW");
		System.out.println("choose an option");
		int choice= in.nextInt();
		switch(choice){
		
		case 1:
			a.Balance();
			break;
		case 2:
			a.Deposit();
			break;
		case 3:
			a.Withdrawal();
			break;
		case 4:
			a.Overview();
			break;
		default:
            System.out.println("Wrong input");
            break;
			
		}
		
	}
	
	public BankSystem2() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		      File myObj = new File("bank.txt");
		      if (myObj.createNewFile()) {
		       // System.out.println("File created: " + myObj.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		Register.register();
		menu();
		

	}

}
