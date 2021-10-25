import java.io.*;
import java.util.Scanner;

public class Checking implements Serializable{

	protected float balance = 0.0f;
	protected float chk = 0.0f;
	protected float with = 0.0f;

	public static void main(String[] args){
		Checking c = new Checking();
	}

	public Checking()
	{
		this.balance = 0.0f;
		this.chk = 0.0f;
		this.with = 0.0f;
	}

	public Checking(float amount)
	{
		this.balance = amount;
	}

	public float bal(){
		return balance;
	}
	
	public void getcBal(){
		if(balance == 0.0f){
			System.out.println("Checking account is empty!!\n");
		}
		else{
			System.out.format("$ %.2f%n", this.balance);
		}
	}
	

	public void deposit(float chk){
		this.chk = chk;
		if(chk < 0.0f){
			System.out.println("Cannot deposit negative ammount\n");
		}
		else{
			balance = balance + chk;
		}
	}
	
	public void withdraw(float withd){
		this.with = withd;
		if(with>balance){
			System.out.println("Balance too low !!!\n");
		}
		else if(with<0.0f){
			System.out.println("Cannot withdraw negative ammount!!\n");
		}
		else{
			balance = balance - with;
		}
	}
}

