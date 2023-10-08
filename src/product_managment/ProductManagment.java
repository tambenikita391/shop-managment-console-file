package product_managment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryStream.Filter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ProductManagment
{
	static ArrayList<Product> al=new ArrayList<>();
	static Scanner r=new Scanner(System.in);
	
	public static void pmanagment() throws IOException
	{
		boolean b=true;
		while(b==true)
		{
			System.out.println("*****WELCOME TO PRODUCT MANAGMENT*****");
			System.out.println("\n");
			
			System.out.println("What would you like to do:");
			System.out.println("1.Add product");
			System.out.println("2.Edit product");
			System.out.println("3.Search product");
			System.out.println("4.delete product");
			System.out.println("5.Quit");
			
			int option=r.nextInt();
			if(option==1)
			{
				Addproduct();
			}
			else if(option==2)
			{
				System.out.println("Enter the name of product to edit:");
				r.nextLine();
				String en=r.nextLine();
				Editproduct(en);
			}
			else if(option==3)
			{
				System.out.println("Enter the name of product to search:");
				r.nextLine();
				String sn=r.nextLine();
				Searchproduct(sn);
			}
			else if(option==4)
			{
				System.out.println("Enter the namee of product to delete:");
				r.nextLine();
				String dn=r.nextLine();
				Deleteproduct(dn);
			}
			else if(option==5)
			{
				File f=new File("C:\\Users\\tambe\\eclipse-workspace\\Shop_User_Product_Login\\src\\PrpductMGMT\\product.txt");
				FileWriter fw=new FileWriter(f,true);
				BufferedWriter bw=new BufferedWriter(fw);
				
				for(Product p:al)
				{
					bw.write(p.productID+","+p.productname+","+p.price+","+p.quantity+","+p.category+"\n");
					
				}
				bw.close();
				fw.close();
				f=null;
				
				System.out.println("Program finished!!");
				b=false;
			}
			
		}
		
	}
	public static void Addproduct()
	{
		Product p = new Product();
		System.out.println("Enter product ID:");
		p.productID=r.nextLine();
		
		System.out.println("ENter product name:");
		p.productname=r.nextLine();
		
		System.out.println("Enter product price:");
		p.price=r.nextLine();
		
		System.out.println("Enter product quantity:");
		p.quantity=r.nextLine();
		
		System.out.println("Enter product category:");
		p.category=r.nextLine();
		
		al.add(p);
	}
	public static void Searchproduct(String name)
	{
		for(Product p:al)
		{
			if(p.productname.equalsIgnoreCase(name))
			{
				System.out.println("Product ID:"+p.productID);
				System.out.println("Product name:"+p.productname);
				System.out.println("Product price:"+p.price);
				System.out.println("Product quantity:"+p.quantity);
				System.out.println("Product category:"+p.category);
				return;
			}
		}
		System.out.println("Product not found!!");
	}
	public static void Deleteproduct(String name)
	{
		Iterator <Product> itr=al.iterator();
		while(itr.hasNext())
		{
			Product p=itr.next();
			if(p.productname.equalsIgnoreCase(name))
			{
				itr.remove();
				System.out.println(p.productname+" is removed!!");
				return;
			}
		}
		System.out.println("Product not found!!");
	}
	public static void Editproduct(String name)
	{
		for(Product p:al)
		{
			if(p.productname.equalsIgnoreCase(name))
			{
				System.out.println("New product ID:");
				p.productID=r.nextLine();
				
				System.out.println("New product name:");
				p.productname=r.nextLine();
				
				System.out.println("New product price:");
				p.price=r.nextLine();
				
				System.out.println("New product quantity:");
				p.quantity=r.nextLine();
				
				System.out.println("New product category:");
				p.category=r.nextLine();
				return;
				
			}
		}
		System.out.println("Product not found:");
	}
	public static void LoadIntoFile() throws IOException
	{
		File f=new File("C:\\Users\\tambe\\eclipse-workspace\\Shop_User_Product_Login\\src\\PrpductMGMT\\product.txt");
		FileReader fr=new FileReader(f);
		BufferedReader br=new BufferedReader(fr);
		
		String line=" ";
		while((line=br.readLine())!=null)
		{
			Product p=new Product();
			String [] array=line.split(",");
			
			if(array.length>4)
			{
			p.productID=array[0];
			p.productname=array[1];
			p.price=array[2];
			p.quantity=array[3];
			p.category=array[4];
			
			al.add(p);
			}
		}
		br.close();
		fr.close();
		f=null;
			
	}
	

}
