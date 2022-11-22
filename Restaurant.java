import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Restaurant {
	
	String restaurantName;
	String managerName;
	String telephoneNumber;
	String Email;
	String Address;
	private int loginID;
	private String Password;
	String[] foodItems= new String[50];
	int[] Price = new int[50];
	int[] Quantity = new int[50];
	int count=0;
	int []COUNT= new int[20];
	//Customer customer = new Customer();
	Customer[] c = new Customer[50];
	int size =0;

	Restaurant[] restaurant = new Restaurant[20];
	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public int getLoginID() {
		return loginID;
	}

	public void setLoginID(int loginID) {
		this.loginID = loginID;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String[] getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(String[] foodItems) {
		this.foodItems = foodItems;
	}

	String showAddress(int n)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter address number: ");
		n = sc.nextInt()-1;
		return restaurant[n].Address;
	}

	void initialize()
	{
		for(int i=0;i<20;i++)
		{

			restaurant[i] = new Restaurant();
			if (i>1)
			{
				COUNT[i]=0;
			}

		}
		COUNT[0]=15;
		COUNT[1]=15;
		restaurant[0].restaurantName="Quetta Restaurant";
		restaurant[0].managerName="Nabeel";
		restaurant[0].Address=" Main Road Chakwal";
		restaurant[0].telephoneNumber="03139999999";
		restaurant[0].Email=" ";
		restaurant[0].loginID=123456;
		restaurant[0].Password="123";

		restaurant[1].restaurantName="Butt restaurant";
		restaurant[1].managerName="Zain";
		restaurant[1].Address="GT Road Rawalpindi";
		restaurant[1].telephoneNumber="033288888888";
		restaurant[1].Email=" ";
		restaurant[1].loginID=654321;
		restaurant[1].Password="321";

		restaurant[0].foodItems[0]="Nihari";
		restaurant[0].foodItems[1]="Kabuli Kabab";
		restaurant[0].foodItems[2]="Haleem";
		restaurant[0].foodItems[3]="Biryani";
		restaurant[0].foodItems[4]="Karhai";
		restaurant[0].foodItems[5]="Korma";
		restaurant[0].foodItems[6]="Channy";
		restaurant[0].foodItems[7]="Palao";
		restaurant[0].foodItems[8]="Halwa Puri";
		restaurant[0].foodItems[9]="Kheer";
		restaurant[0].foodItems[10]="Kabab";
		restaurant[0].foodItems[11]="Sajji";
		restaurant[0].foodItems[12]="Chana Chaat";
		restaurant[0].foodItems[13]="Fruit Chaat";
		restaurant[0].foodItems[14]="Rice";
		restaurant[0].Price[0]=100;
		restaurant[0].Price[1]=120;
		restaurant[0].Price[2]=130;
		restaurant[0].Price[3]=135;
		restaurant[0].Price[4]=140;
		restaurant[0].Price[5]=105;
		restaurant[0].Price[6]=200;
		restaurant[0].Price[7]=300;
		restaurant[0].Price[8]=250;
		restaurant[0].Price[9]=2750;
		restaurant[0].Price[10]=175;
		restaurant[0].Price[11]=300;
		restaurant[0].Price[12]=135;
		restaurant[0].Price[13]=125;
		restaurant[0].Price[14]=170;
		restaurant[0].Quantity[0]=9;
		restaurant[0].Quantity[1]=22;
		restaurant[0].Quantity[2]=21;
		restaurant[0].Quantity[3]=12;
		restaurant[0].Quantity[4]=13;
		restaurant[0].Quantity[5]=14;
		restaurant[0].Quantity[6]=15;
		restaurant[0].Quantity[7]=31;
		restaurant[0].Quantity[8]=25;
		restaurant[0].Quantity[9]=27;
		restaurant[0].Quantity[10]=17;
		restaurant[0].Quantity[11]=30;
		restaurant[0].Quantity[12]=13;
		restaurant[0].Quantity[13]=12;
		restaurant[0].Quantity[14]=17;

		restaurant[1].foodItems[0]="  Nihari";
		restaurant[1].foodItems[1]="  Kabuli Kabab";
		restaurant[1].foodItems[2]="  Haleem";
		restaurant[1].foodItems[3]="  Biryani";
		restaurant[1].foodItems[4]="  Karhai";
		restaurant[1].foodItems[5]="  Korma";
		restaurant[1].foodItems[6]="  Channy";
		restaurant[1].foodItems[7]="  Palao";
		restaurant[1].foodItems[8]="  Halwa Puri";
		restaurant[1].foodItems[9]="  Kheer";
		restaurant[1].foodItems[10]="  Kabab";
		restaurant[1].foodItems[11]="  Sajji";
		restaurant[1].foodItems[12]="  Chana Chaat";
		restaurant[1].foodItems[13]="  Fruit Chaat";
		restaurant[1].foodItems[14]="   Rice";
		restaurant[1].Price[0]=1000;
		restaurant[1].Price[1]=1200;
		restaurant[1].Price[2]=1300;
		restaurant[1].Price[3]=1350;
		restaurant[1].Price[4]=1400;
		restaurant[1].Price[5]=1058;
		restaurant[1].Price[6]=2070;
		restaurant[1].Price[7]=3006;
		restaurant[1].Price[8]=2503;
		restaurant[1].Price[9]=27450;
		restaurant[1].Price[10]=1275;
		restaurant[1].Price[11]=3200;
		restaurant[1].Price[12]=1335;
		restaurant[1].Price[13]=1425;
		restaurant[1].Price[14]=1750;
		restaurant[1].Quantity[0]=9;
		restaurant[1].Quantity[1]=22;
		restaurant[1].Quantity[2]=21;
		restaurant[1].Quantity[3]=12;
		restaurant[1].Quantity[4]=13;
		restaurant[1].Quantity[5]=14;
		restaurant[1].Quantity[6]=15;
		restaurant[1].Quantity[7]=31;
		restaurant[1].Quantity[8]=25;
		restaurant[1].Quantity[9]=27;
		restaurant[1].Quantity[10]=17;
		restaurant[1].Quantity[11]=30;
		restaurant[1].Quantity[12]=13;
		restaurant[1].Quantity[13]=12;
		restaurant[1].Quantity[14]=17;
		count =2;
	}


	void showRestaurants()
	{
		for(int i=0; i<count; i++)
		{
			System.out.println("Restaurant Name: "+ restaurant[i].restaurantName);
			System.out.println("Manager name: "+ restaurant[i].managerName);
			System.out.println("Address: "+ restaurant[i].Address);
			System.out.println("---------------------------------\n");
		}
	}

	void CreateAccount()
	{
		Scanner input = new Scanner(System.in);

		String Password,confirmpassword;
		for(int i=count;;)
		{
			System.out.println("Enter your restaurant name");
			restaurant[i].restaurantName= input.nextLine();
			System.out.println("Enter manager name:");
			restaurant[i].managerName= input.nextLine();
			System.out.println("Enter you Email Address");
			restaurant[i].Email=input.nextLine();
			System.out.println("Enter your phone number");
			restaurant[i].telephoneNumber=input.nextLine();
			restaurant[i].loginID  = (int)((Math.random() * 456000)+34567);
			System.out.println("Create your Password");
			Password= input.nextLine();
			System.out.println("Confirm your Password");
			confirmpassword = input.nextLine();
			while(!Password.equals(confirmpassword))
			{
				System.out.println("Password donot match!!! Try again");
				System.out.println("Create your Password");
				Password= input.nextLine();
				System.out.println("Confirm your Password");
				confirmpassword = input.nextLine();
			}
			System.out.println("Enter your Address: ");
			restaurant[i].Address= input.nextLine();
			System.out.println("Your Login id is: "+ restaurant[i].loginID);

			restaurant[i].Password = confirmpassword;
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
			if(restaurant[i].loginID==id)
			{
				System.out.println("Enter the Password: ");
				input.nextLine();
				pass = input.nextLine();
				if(restaurant[i].Password.equals(pass))
				{
					System.out.println("Welcome: ");
					return 1;
				}
				else
				{
					while(!restaurant[i].Password.equals(pass))
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
	


	void addFood()
	{
		Scanner inp = new Scanner(System.in);
		System.out.println("Enter restraunt number: ");
		int restNum = inp.nextInt()-1;	
		//cus.customer[0].setName("tayyab");

		for(int j=COUNT[restNum];;)
		{
			System.out.println("Enter the name of the food");
			inp.nextLine();
			restaurant[restNum].foodItems[j]=inp.nextLine();
			System.out.println("Enter its price: ");
			restaurant[restNum].Price[j]=inp.nextInt();
			COUNT[restNum]++;
			break;
		}
	}


	void deleteFood(int restNum, int foodNum)
	{
		

		for(int j=foodNum;;)
		{
			restaurant[restNum].foodItems[j]=restaurant[restNum].foodItems[j+1];
			restaurant[restNum].Price[j]=restaurant[restNum].Price[j+1];
			COUNT[restNum]--;
			break;
		}
	}

	void update(int restNum, int foodNum)
	{
		Scanner input = new Scanner(System.in);

		if(foodNum<COUNT[restNum])
		{
			System.out.println("Enter new Name of the Food");
			input.nextLine();
			restaurant[restNum].foodItems[foodNum]=input.nextLine();
			System.out.println("Enter its price: ");
			restaurant[restNum].Price[foodNum]= input.nextInt();	
		}
		else
		{
			System.out.println("Entered food number exceeds the available foods");
		}
	}
	
	

	void showFoodMenu(int n)
	{
		n=n-1;
		for(int j=0; j<COUNT[n]; j++)
		{
			System.out.println(j+1 + ". " +restaurant[n].foodItems[j]+"\t\tPrice: " + restaurant[n].Price[j]+ " Rs.\t\t Quantity:" +restaurant[n].Quantity[j]);
		}
	}


	
	void deleteRestaurant()
	{
		count--;
	}
	

	
	void restaurantMenu()
	{
		System.out.println(
				"1. Add Food details\r\n"
				+ "2. Update Food details\r\n"
				+ "3. Delete Food\r\n"
				+ "4. Check food order\r\n"
				+ "5. Update food delivery status\r\n"
				+ "6. Calculate Bills");
	}




	void Read()
	{
		try {
		      File myobj = new File("RestaurantData.txt");
		      
		     
		      
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
		
		FileReader obj = new FileReader("RestaurantData.txt");
		Scanner reader = new Scanner(obj);
		int i = 0;
		while(reader.hasNext())
		{
			String data = reader.nextLine();
			String array [] = data.split(", ");
			
			restaurant[i].managerName =array[0];
			
			restaurant[i].telephoneNumber=array[1];

			restaurant[i].Address=array[2];

			restaurant[i].loginID=(int) Double.parseDouble(array[3]);
			
			restaurant[i].Password=array[4];
			
			restaurant[i].restaurantName =array[5];

			

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
			  FileWriter writer = new FileWriter("RestaurantData.txt");
			  PrintWriter buffer = new PrintWriter(writer);
			  for (int i =0; i<size; i++)
			  {
				  
					   
					  
					  writer.write(restaurant[i].managerName+", ");
					  
					   writer.write(restaurant[i].telephoneNumber+", " );
					   
					   writer.write(restaurant[i].Address+", ");

					   writer.write(restaurant[i].loginID+", ");
					   
					   writer.write(restaurant[i].Password+", ");

					   writer.write(restaurant[i].restaurantName+", " );
										
										   						   
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