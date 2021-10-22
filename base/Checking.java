import java.io.*;
import java.util.Scanner;

public class Checking implements Serializable{

	protected int balance = 0;
	protected int chk = 0;
	protected int with = 0;

	public static void main(String[] args){
		Checking c = new Checking();
	}

	public Checking(int amt)
	{
		this.balance = amt;
	}

	public int bal(){
		return balance;
	}
	

	public void getcBal(){
		if(balance == 0){
			System.out.println("Checking account is empty!!\n");
		}
		else{
			System.out.println("$ "+this.balance);
		}
	}
	

	public void deposit(int chk){
		this.chk = chk;
		if(chk < 0){
			System.out.println("Cannot deposit negative ammount\n");
		}
		else{
			balance = balance + chk;
		}
	}
	
	public void withdraw(int with){
		this.with = with;
		if(with>balance){
			System.out.println("Balance too low !!!\n");
		}
		else if(with<0){
			System.out.println("Cannot withdraw negative ammount!!\n");
		}
		else{
			balance = balance - with;
		}
	}
}

