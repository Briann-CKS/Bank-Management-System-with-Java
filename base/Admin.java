import java.io.*;
import java.lang.Math;
import java.util.Vector;
import java.util.Scanner;

public class Admin extends User implements Serializable {

	protected int accnum;
	protected int pin;
	protected String name = " ";

	public static void main(String[] args){
		Admin a = new Admin();
	}

	public User adduser(int accnum, String name, int pin, float savv, float chkk){
		User u = new User();
		u.setName(name);
		u.setPin(pin);
		u.setAcnum(accnum);
		u.setSav(savv);
		u.setChk(chkk);
		u.userinfo();
		return u;
	}	

	public void deleteuser(int accnum, Vector vec){
		int counter =0;
		for(int i=0; i<vec.size(); i++){
			User user = new User();
			user = (User)vec.get(i);
			counter++;
			if(accnum == user.accnum()){
				vec.remove(i);
				System.out.println("User "+user.name+" has been deleted!!");
			}
		}
	}
	
	public void listuser(Vector vec){
		System.out.println("Current users are :\n");
		for(int i=0; i<vec.size(); i++){
			User user = new User();
			user =(User)vec.get(i);
			user.userinfo();
		}
	}
	
	public void addinterest(Vector vec){
		System.out.println("\n Enter the interest rate (float) : ");
		Scanner input = new Scanner(System.in);
		float interest = input.nextFloat();
		System.out.println("\n Enter period (months) : ");
		int time = input.nextInt();
		for(int i=0; i<vec.size(); i++){
			User user = new User();
			user = (User)vec.get(i);
			float sbal = user.sav.bal();
			float depo = sbal*(1+(interest*((float)time/12))) - sbal;
			user.sav.deposit(depo);
		}
	}
}

