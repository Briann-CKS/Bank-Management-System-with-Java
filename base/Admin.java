import java.io.*;
import java.lang.Math;
import java.util.Vector;
import java.util.Scanner;

public class Admin extends User implements Serializable {

	protected int acnum;
	protected int pin;
	protected String name = " ";

	public static void main(String[] args){
		Admin a = new Admin();
	}

	public User addu(int acnum, String name, int pin){
		User u = new User();
		u.setName(name);
		u.setPin(pin);
		u.setAcnum(acnum);

		u.userinfo();
		return u;}	

	public void deleteu(int acnum, Vector v){
		for(int i=0; i<v.size(); i++){
			User u = new User();
			u = (User)v.get(i);
			int cbal = u.chk.bal();
			int sbal = u.sav.bal();
			if (cbal != 0 || sbal != 0){
				System.out.println("Account is not empty, unable to delete!!!!\n");
			}
			else if(acnum ==u.acnum()){
				v.remove(i);
				System.out.println("User "+u.name+" has been deleted!!");
			}
		}
	}
	
	public void listu(Vector v){
		System.out.println("Current users are :\n");
		for(int i=0; i<v.size(); i++){
			User u = new User();
			u =(User)v.get(i);
			u.userinfo();
		}
	}
	
	public void addinterest(Vector v){
		System.out.println("\n Enter the interest rate : ");
		Scanner input = new Scanner(System.in);
		float interest = input.nextFloat();
		System.out.println("\n Enter duration : ");
		int time = input.nextInt();
		for(int i=0; i<v.size(); i++){
			User u = new User();
			u = (User)v.get(i);
			int sbal = u.sav.bal();
			float nbal = (float)sbal*(1-(interest*(float)time));
			u.sav.deposit((int)nbal);
		}
	}
}

