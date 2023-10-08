package user_managment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class UserManagment {
	static ArrayList<User> al=new ArrayList<>();
	
	static
	{
		try {
			LoadDataToFile1();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public static void umanagment() throws IOException
	{
		Scanner r=new Scanner(System.in);
		boolean b=true;
		
		while(b==true)
		{
			System.out.println("******WELCOME TO USER MANAGMENT*****");
			System.out.println("\n");
			System.out.println("What would you like to do:");
			
			System.out.println("1.Add user");
			System.out.println("2.Edit user");
			System.out.println("3.Search user");
			System.out.println("4.Delete user");
			System.out.println("5.Quit");
			
			int option=r.nextInt();
			if(option==1)
			{
				Adduser();
			}
			else if(option==2)
			{
				System.out.println("ENter the name of user to edit:");
				r.nextLine();
				String en=r.nextLine();
				Edituser(en);
			}
			else if(option==3)
			{
				System.out.println("ENter the name of user to search:");
				r.nextLine();
				String sn=r.nextLine();
				Searchuser(sn);
			}
			else if(option==4)
			{
				System.out.println("Enter the name of user to delete:");
				r.nextLine();
				String dn=r.nextLine();
				Deleteuser(dn);
			}
			else if(option==5)
			{
				File f=new File("C:\\Users\\tambe\\eclipse-workspace\\Shop_User_Product_Login\\src\\UserMGMT\\User.txt");
				FileWriter fw=new FileWriter(f,true);
				BufferedWriter bw=new BufferedWriter(fw);
				for(User u:al)
				{
					bw.write(u.username+","+u.login+","+u.password+","+u.password2+","+u.role+"\n");
				}
				bw.close();
				fw.close();
				f=null;
				
				System.out.println("Program finished!!");
				b=false;
				
			}
		}
		
		
	}

	public static void Adduser()
	{
		Scanner r=new Scanner(System.in);
		User u=new User();
		
		System.out.println("Enter username:");
		u.username=r.nextLine();
		
		System.out.println("Enter login name:");
		u.login=r.nextLine();
		
		System.out.println("Enter password:");
		u.password=r.nextLine();
		
		System.out.println("Enter cofirm password:");
		u.password2=r.nextLine();
		
		System.out.println("Enter user role:");
		u.role=r.nextLine();
		
		al.add(u);
	}
	public static void Searchuser(String name)
	{
		for(User u:al)
		{
			if(u.username.equalsIgnoreCase(name))
			{
				System.out.println("Username:"+u.username);
				System.out.println("Login name:"+u.login);
				System.out.println("Password:"+u.password);
				System.out.println("Confirm password:"+u.password2);
				return;
			}
		}
		System.out.println("User not found!!");
	}
	public static void Deleteuser(String name)
	{
		Iterator<User> itr=al.iterator();
		while(itr.hasNext())
		{
			User u=itr.next();
			if(u.username.equalsIgnoreCase(name))
			{
				itr.remove();
				System.out.println(u.username+" is deleted successfully");
				return;
			}
		}
		System.out.println("User not found!!");
	}
	public static void Edituser(String name)
	{
		Scanner r=new Scanner(System.in);
		for(User u:al)
		{
			if(u.username.equalsIgnoreCase(name))
			{
				System.out.println("New Username:");
				u.username=r.nextLine();
				
				System.out.println("New login name:");
				u.login=r.nextLine();
				
				System.out.println("New password:");
				u.password=r.nextLine();
				
				System.out.println("New cofirm password:");
				u.password2=r.nextLine();
				
				System.out.println("New User role:");
				u.role=r.nextLine();
				return;
			}
		}
		System.out.println("User not found!!");
	}
	public static void LoadDataToFile1() throws IOException
	{
		File f=new File("C:\\Users\\tambe\\eclipse-workspace\\Shop_User_Product_Login\\src\\UserMGMT\\User.txt");
		FileReader fr=new FileReader(f);
		BufferedReader br=new BufferedReader(fr);
		
		String line=" ";
		while((line=br.readLine())!=null)
		{
			User u=new User();
			String [] userarray=line.split(",");
			
			if(userarray.length>4)
			{
			u.username=userarray[0];
			u.login=userarray[1];
			u.password=userarray[2];
			u.password2=userarray[3];
			u.role=userarray[4];
			
			al.add(u);
			
		}
		}
		
		br.close();
		fr.close();
		f=null;
		
	}
	public static boolean ValidateUserAndPassword(String loginName,String password)
	{
		Iterator<User> i = al.iterator();
		
		while(i.hasNext())
		{
			User u = i.next();
			if(u.login.equalsIgnoreCase(loginName) && u.password.equalsIgnoreCase(password))
			{
				return true;
			}
		}
		return false;
		
	}
	

}

