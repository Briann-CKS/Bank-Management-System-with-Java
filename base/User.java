import java.io.*;
import java.util.Vector;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.FileInputStream;

public class User implements Serializable 
{	
	protected Saving sav; 
	protected Checking chk;
	
	protected int accnum=0;
	protected int pin = 0;
	protected String name;

	public User(int accountNumber, int pIN, Checking checkingAccount,Saving savingAccount, String name) 
	{ 
		super();
		this.accnum = accountNumber;
		this.pin = pIN;
		this.chk = checkingAccount;
		this.sav = savingAccount;
		this.name = name;	
	}
	
	public int accnum(){
		if(accnum == 0){
			System.out.println("Unknown Account number!!!!\n");
			return 0;
		}
		else{
			return this.accnum;
		}
	}	
	

	public static void main(String[] args){
		User user = new User();
	}
	

	public User(){
		sav = new Saving();
		chk = new Checking();
	}
	

	public void setName(String name){
		this.name = name;
	}
	
	public void setAcnum(int acnum){
		this.accnum = acnum;
	}

	public void setSav(float savv){
		Saving newSav = new Saving(savv);
                this.sav = newSav;
        }

	public void setChk(float chkk){
                Checking newCheck = new Checking (chkk);
                this.chk = newCheck;
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
		System.out.println(this.name+"\nAccount Number: "+this.accnum+"\nPin Number: "+this.pin);
		System.out.println("Saving balance: ");
		this.sav.getsBal();
		System.out.println("Checking balance: ");
		this.chk.getcBal();
		System.out.println(" ");
	}
}

