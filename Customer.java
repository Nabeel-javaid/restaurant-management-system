import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class Customer {

	//Restaurant r = new Restaurant();
	 Customer[] customer= new Customer[50];
	String Name;
	String Number;
	String Address;
	String Id;
	String Password;
	double Balance;
	int size=0;
	
	int count=0;
	Customer()
	{
	}

	public Customer[] getCustomer() {
		return customer;
	}

	public void setCustomer(Customer[] customer) {
		this.customer = customer;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getNumber() {
		return Number;
	}

	public void setNumber(String number) {
		Number = number;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}



	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	void initialize()
	{
		for (int i=0; i<50; i++)
		{
			this.customer[i]= new Customer();
		}
	}

	void createAccount(Customer obj)
	{
		
		for(int i=count;;)
		{
			//customer[i]= new Customer();
		
				
				String pass;
				Scanner input = new Scanner(System.in);
				System.out.println("-------------Account Registration-----------\n");
				System.out.println("Enter your name: ");
				obj.customer[i].Name= input.nextLine();
				System.out.println("Enter your id: ");
				obj.customer[i].Id= input.nextLine();
				System.out.println("Create a Password:");
				obj.customer[i].Password= input.nextLine();
				pass= obj.customer[i].Password;
				System.out.println("Confirm Password: ");
				obj.customer[i].Password= input.nextLine();
				while(!customer[i].Password.equals(pass))
				{
					System.out.println("Password doesnt match!!! \nConfirm password again");
					obj.customer[i].Password= input.nextLine();		
				}
				System.out.println("Enter your Number: ");
				obj.customer[i].Number=input.nextLine();
				System.out.println("Enter your Address: ");
				obj.customer[i].Address= input.nextLine();
				System.out.println("Enter an amount of balance to add to your account:");
				obj.customer[i].Balance=input.nextInt();
				count++;
				System.out.println("Accout has been created successfully");
				
				break;
			
		}
	}


	int login(String id)
	{
		String  pass;
		int Count =0;
		Scanner input = new Scanner(System.in);
		
		for(int i=0; i<count; i++)
		{
				if(customer[i].Id.equals(id))
				{
					System.out.println("Enter the password: ");
					pass = input.nextLine();
					if(customer[i].Password.equals(pass))
					{
						System.out.println("Welcome: ");
						System.out.println(customer[i].Name);
						return 1;
					}
					else
					{
						while(!customer[i].Password.equals(pass))
						{
							System.out.println("Incorrect Password!!! \nEnter password again.");
							pass = input.nextLine();
							Count++;
							if(Count==2)
							{
								System.out.println("You entered incorrect password 3 times!!!");
								return 0;
							}
						}
					}
				}

				else if(i==count-1)
				{
					System.out.println("Incorrect id--- ");
					return 0;
				}

		}
		return 2;
	}
	
	void viewFoodDetails(Restaurant r)
	{
		Scanner sc = new Scanner(System.in);
		r.initialize();
		System.out.println("Enter restaurant number to show food:" );
		int c = sc.nextInt();
		r.showFoodMenu(c);
	}

	void customerMenu()
	{
		System.out.println("1. View Food details\r\n"
				+ "2. Add to cart\r\n"
				+ "3. place order\r\n"
				+ "4. Cancel Order\r\n"
				+ "5. Update Cart\r\n"
				+ "6. Checkout\r\n"
				+ "7. Pay Cash on Delivery\r\n"
				+ "8. Check Food delivery status\n"
				+"Enter your choice:-");
	}
	

	void Read()
	{
		try {
		      File myobj = new File("CustomerData.txt");
		      
		     
		      
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
		
		FileReader obj = new FileReader("CustomerData.txt");
		Scanner reader = new Scanner(obj);
		int i = 0;
		while(reader.hasNext())
		{
			String data = reader.nextLine();
			String array [] = data.split(", ");
			
			customer[i].Name =array[0];
			
			customer[i].Number = array[1];

			customer[i].Address=array[2];

			customer[i].Id	=array[3];
			
			customer[i].Password=array[4];

			customer[i].Balance=Double.parseDouble(array[5]);
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
			  FileWriter writer = new FileWriter("CustomerData.txt");
			  PrintWriter buffer = new PrintWriter(writer);
			  for (int i =0; i<size; i++)
			  {
				  
					   
					  
					  writer.write(customer[i].Name+", ");
					  
					   writer.write(customer[i].Number+", " );
					   
					   writer.write(customer[i].Address+", ");

					   writer.write(customer[i].Id+", ");
					   
					   writer.write(customer[i].Password+", ");

					   writer.write(customer[i].Balance+", " );
										
										   						   
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
