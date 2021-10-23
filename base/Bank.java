import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class Bank extends Admin implements Serializable{

	public static Vector<User> v = new Vector<User>();
	//main function
	public static void main(String[] args){
		Bank acc = new Bank();
                acc.mainMenu(v);
	}

	public Bank()
	{
		loadUser();
	}

	public void saveUserA(User u, Vector v)                 
        {
                try{
		int counter = 0;
                FileOutputStream file=new FileOutputStream("Users.dat");
                ObjectOutputStream out=new ObjectOutputStream(file);
                for(int i=0; i<v.size(); i++)
		{
              		User usr = new User();
        	     	usr = (User)v.get(i);
                 	int acc = usr.acnum();
                        int pin = usr.pin();
			if(u.acnum() == acc)
			{
        	        	v.set(i, u);
				break;
                	}
		}
		out.writeObject(v);
                out.close();
                file.close();
		} catch(Exception e){
                        System.out.println(e.getMessage());
                }
        }


	@SuppressWarnings("unchecked")		
	public void loadUser()
	{
		try{
		FileInputStream file=new FileInputStream("Users.dat");
		ObjectInputStream in=new ObjectInputStream(file);
				
		v = (Vector)in.readObject();
		
		in.close();
		}catch(IOException e){
			v = new Vector();
		}catch(ClassNotFoundException e){
			System.out.println(e.getMessage());
		}
	}
		

	// main menu
	public void mainMenu(Vector v){
		
		System.out.println("__________________________________________________________________\n");
		System.out.println("Enter your your Account number and Pin\n");
		System.out.println("Account No. :- ");
		Scanner input = new Scanner(System.in);
		int acnum  = input.nextInt();

		System.out.println("Pin No. :- ");
		int pinnum = input.nextInt();

		System.out.println("__________________________________________________________________\n");
		if(acnum == 00000){
			if(pinnum == 12345){
				this.admin_menu(v);
			}
		}
		
		for(int i=0; i<v.size(); i++){
			User usr = new User();
			usr = (User)v.get(i);
			int acc = usr.acnum();
			int pin = usr.pin();

			if(acc == acnum){
				if(pin == pinnum){
					this.userMenu(v, usr);
				}
			}
		}
                System.out.println("No valid user with this account!");
	}

	// admin menu
	public void admin_menu(Vector v){
                int choice;
		boolean keep_going = true;
		Admin a = new Admin();

		while(keep_going)
		{
			System.out.println("Welcome to the Admin Menu");
                	System.out.println("\nEnter Choice \n1. Add User\n2. Delete User\n3. List User\n4. Apply Interest\n5. Exit\n");
                	Scanner input = new Scanner(System.in);
                	choice = input.nextInt();
		
			if (choice == 1)
			{
				System.out.println("\nEnter User Account number :");
				Scanner acn = new Scanner(System.in);
				acnum = acn.nextInt();
				System.out.println("\nEnter User name :");
				Scanner nam = new Scanner(System.in);
				name = nam.nextLine();
				System.out.println("\nEnter User pin :");
				Scanner pi = new Scanner(System.in);                                
				pin = pi.nextInt();
				System.out.println("\nEnter User Saving account balance :");
                	        Scanner sa = new Scanner(System.in);
                       		float savv = sa.nextFloat();
				System.out.println("\nEnter User Checking account balance :");
                        	Scanner ch = new Scanner(System.in);
                        	float chkk = ch.nextFloat();
				v.add(addu(acnum, name, pin, savv, chkk));
			}

			else if (choice == 2)
			{
				System.out.println("\nEnter User account number to be deleted :");
				acnum = input.nextInt();
				deleteu(acnum, v);
			}

			else if (choice == 3)
			{
				listu(v);
			}
	
			else if (choice == 4)
			{
				addinterest(v);
			}
	
			else if (choice == 5)
			{
				try{
				FileOutputStream file=new FileOutputStream("Users.dat");
				ObjectOutputStream out=new ObjectOutputStream(file);
				out.writeObject(v);
				out.close();
				file.close();
				} catch(Exception e){
					System.out.println("IOException Caught");
				}
				keep_going = false;
				System.exit(0);
			}

			else
			{
				System.out.println("Not a valid option!");
				keep_going = false;
				System.exit(0);
			}
		}
	}

	// user menu
	public void userMenu(Vector v, User u){
                int acType;
                int choice;
		boolean keep_going = true;

		while(keep_going)
		{	
			System.out.println("Welcome "+u.name+"!");
	                System.out.println("\nEnter Choice\n1. Checking\n2. Savings\n3. Exit\n");
        	        Scanner input = new Scanner(System.in);
                	acType = input.nextInt();

			if (acType == 1)
			{
				System.out.println("\nChecking account : \n");
                        	System.out.println("Enter Choice\n1. Deposit\n2. Withdraw\n3. Check Balance\n4. Exit\n");
                       		choice = input.nextInt();
			
				if (choice == 1)
				{
					System.out.println("How much would you like to deposit?\n");
                        	        float dep = input.nextFloat();
                                	u.chk.deposit(dep);
				}
			
				else if (choice == 2)
				{
					System.out.println("How much would you like to withdraw?\n");
                                	float with = input.nextFloat();
                                	u.chk.withdraw(with);
				}

				else if (choice == 3)
				{
					System.out.println("Current checking balance :- \n");
                	                u.chk.getcBal();
				}

				else if (choice == 4)
				{
					saveUserA(u, v);
				}
			
				else
				{
					System.out.println("Not a valid option!");
				}
			}	
	
			else if(acType == 2) 
			{
				System.out.println("\nSavings account : \n");
                        	System.out.println("Enter Choice\n1. Deposit\n2. Withdraw\n3. Check Balance\n4. Exit\n");
                        	choice = input.nextInt();
			
				if (choice == 1)
				{
					System.out.println("How much would you like to deposit?\n");
                        	        float dep = input.nextFloat();
                                	u.sav.deposit(dep);
				}
	
				else if (choice == 2)
				{
					System.out.println("How much would you like to withdraw?\n");
                        	        float with = input.nextFloat();
                                	u.sav.withdraw(with);
				}

				else if (choice == 3)
				{
					System.out.println("Current savings balance :- \n");
                                	u.sav.getsBal();
				}

				else if (choice == 4)
				{
					saveUserA(u, v);		
				}
			
				else
                        	{       
					System.out.println("Not a valid option!");
                        	}

			}
			else if (acType == 3)
                	{
				saveUserA(u,v);
				keep_going = false;
				System.exit(0);
        	        }

                	else
               		{
                        	System.out.println("Not a valid option!");
				saveUserA(u,v);
				keep_going = false;
                        	System.exit(0);
                	}
		}
	}
}



