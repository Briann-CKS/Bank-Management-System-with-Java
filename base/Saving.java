import java.io.*;
import java.util.Scanner;

public class Saving implements Serializable{

	protected float bal = 0.0f;
	protected float saving1 = 0.0f;
	protected float with = 0.0f;

	public static void main(String[] args){
		Saving s = new Saving();
	}

	public Saving()
	{
		this.bal = 0.0f;
		this.saving1 = 0.0f;
		this.with = 0.0f;
	}

	public Saving (float amount)
	{
		this.bal = amount;
	}	

	public float bal(){
		return bal;
	}
	
	public void getsBal(){
		if(bal == 0.0f){
			System.out.println("The account is empty\n");
		}
		else{
			System.out.format("$ %.2f%n", this.bal);
		}
	}
	

	public void deposit(float saving){
		this.saving1 = saving;

		if(saving1<0.0f){
			System.out.println("The amount you entered is negative\n");
		}

		else{
			bal = bal+saving1;
		}
	}
	
	
	public void withdraw(float with){
		this.with = with;

		if(with>bal){
			System.out.println("Account balance is low!!\n");
		}
	
		else if(with<0.0f){
			System.out.println("Cannot withdraw negative ammount!!\n");
		}
		
		else{
			bal = bal - with;
		}
	}
}	

