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

	public User addu(int acnum, String name, int pin, float savv, float chkk){
		User u = new User();
		u.setName(name);
		u.setPin(pin);
		u.setAcnum(acnum);
		u.setSav(savv);
		u.setChk(chkk);
		u.userinfo();
		return u;
	}	

	public void deleteu(int acnum, Vector v){
		int counter =0;
		for(int i=0; i<v.size(); i++){
			User u = new User();
			u = (User)v.get(i);
			counter++;
			if(acnum ==u.acnum()){
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
		System.out.println("\n Enter the interest rate (float) : ");
		Scanner input = new Scanner(System.in);
		float interest = input.nextFloat();
		System.out.println("\n Enter period (months) : ");
		int time = input.nextInt();
		for(int i=0; i<v.size(); i++){
			User u = new User();
			u = (User)v.get(i);
			float sbal = u.sav.bal();
			float nbal = sbal*(1+(interest*(float)time/12));
			u.sav.deposit(nbal);
		}
	}
}

