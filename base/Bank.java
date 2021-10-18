import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class Bank extends Admin implements Serializable{
	//main function
	public static void main(string[] args){
		Bank account = new Bank();
		Vector vec = null;

		try{
		FileInputStream file = new FileInputStream ("User.dat");
		ObjectInputStream input = new ObjectInputStream(file);
		vec = (Vector)input.readObject();

		in.close();
		} catch (IOException ex){
			vec = new Vector();
		} catch(ClassNotFoundException ex){
			System.out.println(ex.getMessage());
		}

		system.out.println(vec);
		account.main_Menu(vec);
		
	}

	public void main_Menu (Vector vec)
	{
		System.out.println("__________________________________________________________________\n");
		System.out.println("Enter your your Account number and Pin\n");
		System.out.println("Account No. :- ");
		Scanner input = new Scanner(System.in);
		int accNum  = input.nextInt();
		
		System.out.println("Pin No. :- ");
		int pinNum = input.nextInt(); 


		System.out.println("__________________________________________________________________\n");
		if(accNum == 0000)
		{
			if(pinNum == 12345)
			{
				this.admin_Menu(vec);
			}
		}
		
		for(int i=0; i < v.size(); i++)
		{
			user usr = new user();
			usr = (user)vec.get(i);
			int acc = usr.accNum();
			int pin = usr.pin();
		
			if(acc == accNum)
			{
				if(pin == pinNum)
				{
					this.userMenu(vec, usr);
				}
			}
		}
	}

	public void admin_Menu (Vector vec)
	{
		int choice;
		admin ad = new admin();
		System.out.println("\nEnter Choice\n1. Add User\n2. Delete User\n3. List User\n4. Apply Interest\n5. Exit\n");	
		Scanner input = new Scanner(System.in);
		choice = input.nextInt();
		if (choice == 1)
		{
			System.out.println("\nEnter User Account Number: ");
			Scanner accnum = new Scanner (System.in);
			accNum = accnum.nextInt();
			System.out.println("\nEnter User name : ");
			Scanner nam = new Scanner (System.in);
			name = nam.nextLine();
			System.out.println("\nEnter User pin :");
			Scanner pi = new Scanner(System.in);                                
			pin = pi.nextInt();
			vec.add(addu(accNum, name, pin));
			this.admin_Menu(vec);
		}

		else if (choice == 2)
		{
			System.out.println("\nEnter User account number to be deleted :");
			accNum = input.nextInt();
			deleteu(accNum, vec);
			this.admin_Menu(vec);
		}

		else if (choice == 3)
		{
			listu(vec);
			this.admin_Menu(vec);
		}

		else if (choice == 4)
		{
			addInterest(vec);
			this.admin_Menu(vec);
		}

		else
		{
			try{
				FileOutputStream file = new FileOutputStream(
















		








