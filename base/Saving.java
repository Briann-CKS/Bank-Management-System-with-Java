import java.io.*;
import java.util.Scanner;

public class Saving implements Serializable{

	protected float bal = 0.0f;
	protected float saving1 = 0.0f;
	protected int with = 0;

	public static void main(String[] args){
		Saving s = new Saving();
	}

	public Saving()
	{
		this.bal = 0.0f;
		this.saving1 = 0.0f;
		this.with = 0;
	}

	public Saving (float amt)
	{
		this.bal = amt;
	}	

	public float bal(){
		return bal;
	}
	
	public void getsBal(){
		if(bal == 0){
			System.out.println("The account is empty\n");
		}
		else{
			System.out.println("$ "+this.bal);
		}
	}
	

	public void deposit(float saving1){
		this.saving1 = saving1;

		if(saving1<0.0f){
			System.out.println("The amount you entered is negative\n");
		}

		else{
			bal = bal+saving1;
		}
	}
	
	
	public void withdraw(int with){
		this.with = with;

		if(with>bal){
			System.out.println("Account balance is low!!\n");
		}
	
		else if(with<0){
			System.out.println("Cannot withdraw negative ammount!!\n");
		}
		
		else{
			bal = bal - with;
		}
	}
}	

