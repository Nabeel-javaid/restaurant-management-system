import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Rider {
	String Name;
	String Number;
	String Address;
	int ID;
	String Password;
	Restaurant r= new Restaurant();
	Rider[] rider = new Rider[50];
	int count =0;
	int size=0;
	
	void initialize()
	{
		for (int i=0; i<50; i++)
		{
			rider[i]= new Rider();
		}
	}

	void createAccount()
	{
		for(int i=count;;)
		{
				String pass;
				Scanner input = new Scanner(System.in);
				System.out.println("-------------Account Registration-----------\n");
				System.out.println("Enter your name: ");
				rider[i].Name= input.nextLine();
				System.out.println("Enter your id: ");
				rider[i].ID= input.nextInt();
				System.out.println("Create a Password:");
				rider[i].Password= input.nextLine();
				pass= rider[i].Password;
				System.out.println("Confirm Password: ");
				rider[i].Password= input.nextLine();
				while(!rider[i].Password.equals(pass))
				{
					System.out.println("Password doesn't match!!! \nConfirm password again");
					rider[i].Password= input.nextLine();		
				}
				System.out.println("Enter your Number: ");
				rider[i].Number=input.nextLine();
				System.out.println("Enter your Address: ");
				rider[i].Address= input.nextLine();
				count++;
				break;		
		}
	}


	int login()
	{
		int id;
		String pass;
		int Count=0;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your id");
		id = input.nextInt();

		for(int i=0; i<count; i++)
		{
			if(rider[i].ID==id)
			{
				System.out.println("Enter the Password: ");
				input.nextLine();
				pass = input.nextLine();
				if(rider[i].Password.equals(pass))
				{
					System.out.println("Welcome: ");
					return 1;
				}
				else
				{
					while(!rider[i].Password.equals(pass))
					{
						System.out.println("Incorrect Password!!! \nEnter Password again.");
						pass = input.nextLine();
						Count++;
						if(Count==2)
						{
							System.out.println("You entered incorrect Password 3 times!!!");
							return 0;
						}
					}
				}
			}

			else if(i==Count-1)
			{
				System.out.println("Incorrect id : ");
				return 0;
			}

		}
		return 2;
	}
	

	void Read()
	{
		try {
		      File myobj = new File("RiderData.txt");
		      
		     
		      
		      if (myobj.createNewFile()) {
		    	  //empty for the sake of else
		      } else {
		    	  // System.out.println("This file already exists.");
		      }
		    } 
			catch (IOException e) {
		      System.out.println("Error occurred.");
		      e.printStackTrace();
		    }
		
		
		//reading
		try {
		
		FileReader obj = new FileReader("RiderData.txt");
		Scanner reader = new Scanner(obj);
		int i = 0;
		while(reader.hasNext())
		{
			String data = reader.nextLine();
			String array [] = data.split(", ");
			
			rider[i].Name =array[0];
			
			rider[i].Number=array[1];

			rider[i].Address=array[2];

			rider[i].ID=(int) Double.parseDouble(array[3]);
			
			rider[i].Password=array[4];
			

			

			size++;
		    i++;
		}
		
		reader.close();
		
		}
		
		catch (FileNotFoundException a) {
			System.out.println("An error Occured ");
		    a.printStackTrace();
		}
	}
	
	//for writing on the file
	void Write()
	{
		try {
			  FileWriter writer = new FileWriter("RiderData.txt");
			  PrintWriter buffer = new PrintWriter(writer);
			  for (int i =0; i<size; i++)
			  {
				  
					   
					  
					  writer.write(rider[i].Name+", ");
					  
					   writer.write(rider[i].Number+", " );
					   
					   writer.write(rider[i].Address+", ");

					   writer.write(rider[i].ID+", ");
					   
					   writer.write(rider[i].Password+", ");

																				   						   
						   writer.write("\n");


				}
			 
			  
			  buffer.close();
			  }
			     catch (Exception e){
				 System.out.println("Error occured ");
			     e.printStackTrace();
			  }
	}

	
}
