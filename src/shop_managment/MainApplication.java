package shop_managment;

import java.io.IOException;

import java.util.Scanner;

import product_managment.ProductManagment;
import user_managment.UserManagment;

public class MainApplication 
{
	public static void main(String [] args) throws IOException
	{
		Scanner r=new Scanner(System.in);
		boolean b = true;
		
		System.out.println("*****WELCOME TO LOGIN*****");
		System.out.println("\n");
		
		System.out.println("Enter login name:");
		String loginName=r.nextLine();
		
		System.out.println("Enter password:");
		String password=r.nextLine();
		
		if(!UserManagment.ValidateUserAndPassword(loginName, password))
		{
			System.out.println("!!!! LoGIN FAILED !!!!");
			return;
		}
			while(b==true)
			{
				System.out.println("*****WELCOME TO SHOP MANAGMENT*****");
				System.out.println("\n");
				
				System.out.println("What would you like to do:");
				System.out.println("1.Product managment");
				System.out.println("2.User managment");
				System.out.println("5.Quit");
				
				int option=r.nextInt();
				if(option==1)
				{
					ProductManagment.pmanagment();
					
				}
				else if(option==2)
				{
					UserManagment.umanagment();
				}
				else if(option==5)
				{
					break;
				}
				
			}
			
		}
}
		
		