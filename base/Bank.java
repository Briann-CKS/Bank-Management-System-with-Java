import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class Bank extends Admin implements Serializable{

	public static Vector<User> vec = new Vector<User>();
	
	public static void main(String[] args){
		Bank account = new Bank();
                account.mainMenu(vec);
	}

	public Bank()
	{
		loadUser();
	}

	public void saveUserA(User u, Vector v)                 
        {
                try{
		int counter = 0;
                FileOutputStream user_file=new FileOutputStream("Users.dat");
                ObjectOutputStream out=new ObjectOutputStream(user_file);
                for(int i=0; i<vec.size(); i++)
		{
              		User user = new User();
        	     	user = (User)vec.get(i);
                 	int acc = user.accnum();
                        int pin = user.pin();
			if(u.accnum() == acc)
			{
        	        	vec.set(i, u);
				break;
                	}
		}
		out.writeObject(vec);
                out.close();
                user_file.close();
		} catch(Exception e){
                        System.out.println(e.getMessage());
                }
        }


	@SuppressWarnings("unchecked")		
	public void loadUser()
	{
		try{
		FileInputStream user_file = new FileInputStream("Users.dat");
		ObjectInputStream inputS = new ObjectInputStream(user_file);
				
		vec = (Vector)inputS.readObject();
		
		inputS.close();
		}catch(IOException e){
			vec = new Vector();
		}catch(ClassNotFoundException e){
			System.out.println(e.getMessage());
		}
	}
		

	// main menu
	public void mainMenu(Vector v){
		
		System.out.println("__________________________________________________________________\n");
		System.out.println("Please enter your your Account Number and Pin\n");
		System.out.println("Account No. : ");
		Scanner input = new Scanner(System.in);
		int accnum  = input.nextInt();

		System.out.println("Pin No. : ");
		int pinnum = input.nextInt();

		System.out.println("__________________________________________________________________\n");
		if(accnum == 00000){
			if(pinnum == 12345){
				this.admin_menu(vec);
			}
		}
		
		for(int i=0; i<vec.size(); i++){
			User user = new User();
			user = (User)vec.get(i);
			int acc = user.accnum();
			int pin = user.pin();

			if(acc == accnum){
				if(pin == pinnum){
					this.userMenu(vec, user);
				}
			}
		}
                System.out.println("Sorry, no valid user with this account!");
	}

	// admin menu
	public void admin_menu(Vector v){
                int choice;
		boolean keep_going = true;
		Admin ad = new Admin();

		while(keep_going)
		{
			System.out.println("Welcome to the Admin Menu");
                	System.out.println("\nPlease Enter your Choice \n1. Add User\n2. Delete User\n3. List User\n4. Apply Interest\n5. Exit\n");
                	Scanner input = new Scanner(System.in);
                	choice = input.nextInt();
		
			if (choice == 1)
			{
				System.out.println("\nEnter User Account number :");
				Scanner accn = new Scanner(System.in);
				accnum = accn.nextInt();
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
				v.add(adduser(accnum, name, pin, savv, chkk));
			}

			else if (choice == 2)
			{
				System.out.println("\nEnter User account number to be deleted :");
				accnum = input.nextInt();
				deleteuser(accnum, vec);
			}

			else if (choice == 3)
			{
				listuser(vec);
			}
	
			else if (choice == 4)
			{
				addinterest(vec);
			}
	
			else if (choice == 5)
			{
				try{
				FileOutputStream user_file = new FileOutputStream("Users.dat");
				ObjectOutputStream outputS = new ObjectOutputStream(user_file);
				outputS.writeObject(vec);
				outputS.close();
				user_file.close();
				} catch(Exception e){
					System.out.println(e.getMessage());
				}
				keep_going = false;
				System.exit(0);
			}

			else
			{
				System.out.println("Sorry, this is not a valid option!");
				keep_going = false;
				System.exit(0);
			}
		}
	}

	// user menu
	public void userMenu(Vector v, User u){
                int accType;
                int choice;
		boolean keep_going = true;

		while(keep_going)
		{	
			System.out.println("Welcome "+u.name+"!");
	                System.out.println("\nPlease enter your Choice\n1. Checkings Account\n2. Savings Account\n3. Exit\n");
        	        Scanner input = new Scanner(System.in);
                	accType = input.nextInt();

			if (accType == 1)
			{
				System.out.println("\nCheckings account : \n");
                        	System.out.println("Please enter your Choice\n1. Deposit\n2. Withdraw\n3. Check Balance\n4. Exit\n");
                       		choice = input.nextInt();
			
				if (choice == 1)
				{
					System.out.println("How much would you like to deposit?\n");
                        	        float depos = input.nextFloat();
                                	u.chk.deposit(depos);
				}
			
				else if (choice == 2)
				{
					System.out.println("How much would you like to withdraw?\n");
                                	float withd = input.nextFloat();
                                	u.chk.withdraw(withd);
				}

				else if (choice == 3)
				{
					System.out.println("Current checking balance is : \n");
                	                u.chk.getcBal();
				}

				else if (choice == 4)
				{
					saveUserA(u, v);
				}
			
				else
				{
					System.out.println("Sorry this is not a valid option!");
				}
			}	
	
			else if(accType == 2) 
			{
				System.out.println("\nSavings account : \n");
                        	System.out.println("Please enter your Choice\n1. Deposit\n2. Withdraw\n3. Check Balance\n4. Exit\n");
                        	choice = input.nextInt();
			
				if (choice == 1)
				{
					System.out.println("How much would you like to deposit?\n");
                        	        float depos = input.nextFloat();
                                	u.sav.deposit(depos);
				}
	
				else if (choice == 2)
				{
					System.out.println("How much would you like to withdraw?\n");
                        	        float withd = input.nextFloat();
                                	u.sav.withdraw(withd);
				}

				else if (choice == 3)
				{
					System.out.println("Current savings balance is : \n");
                                	u.sav.getsBal();
				}

				else if (choice == 4)
				{
					saveUserA(u, v);		
				}
			
				else
                        	{       
					System.out.println("Sorry this is not a valid option!");
                        	}

			}
			else if (accType == 3)
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



