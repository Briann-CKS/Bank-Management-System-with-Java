import java.io.*;
import java.util.Vector;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.FileInputStream;

public class User implements Serializable 
{	
	protected Saving sav; 
	protected Checking chk;
	
	protected int acnum=0;
	protected int pin = 0;
	protected String name;
	
	protected Vector v = null;
	
	public int acnum(){
		if(acnum == 0){
			System.out.println("Unknown Account number!!!!\n");
			return 0;
		}
		else{
			return this.acnum;
		}
	}	
	

	public static void main(String[] args){
		User u = new User();
	}
	

	public User(){
		sav = new Saving();
		chk = new Checking();
	}
	

	public void setName(String name){
		this.name = name;
	}
	
	public void setAcnum(int acnum){
		this.acnum = acnum;
	}
	

	public int pin(){
		if(pin==0){
			System.out.println("No pin set!!!\n");
			return 0;
		}
		else{
			return this.pin;
		}
	}  
	

	public void setPin(int pin){
		this.pin = pin;
	}
	

	public void userinfo(){
		System.out.println(this.name+" "+this.acnum+" "+this.pin);
	}
}

