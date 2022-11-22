import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Scanner;
public class Order {
	Order order[]= new Order[50];
	int orderNumber;
	String addedFoods[]= new String[10];
	int count[] = new int[10];
	int restaurantNumber;
	String customerDetails;
	String Cart;
	int restaurantNum;
	int foodNumber;
	int foodQuantity;
	double Payment;
	boolean paid= false;
	int size=0;
	void initialize()
	{
		for (int i=0; i<50; i++)
		{
			this.order[i]= new Order();
		}
	}

	void orderTime()
	{
		int starttime=15;
		starttime=starttime+LocalDateTime.now().getMinute();
		Scanner sc = new Scanner(System.in);
		System.out.println("press any key: ");
		sc.nextLine();
		int endtime=LocalDateTime.now().getMinute();
		if(endtime>=starttime)
		{System.out.println("Order done ");}
		else
		{
			System.out.println(starttime-endtime+" minutes left");}
	}



	void addTOCart(Customer cus, Restaurant res, String id, int num, int foodNum, int quantity)
	{
		double bill, totalBill=0;
		Scanner sc = new Scanner(System.in);
		
		int add=1;
		while(add==1) {
			
			System.out.println(res.restaurant[num-1].Quantity[foodNum-1]);
			System.out.println(res.restaurant[num-1].foodItems[foodNum-1]);
			res.restaurant[num-1].Quantity[foodNum-1]=res.restaurant[num-1].Quantity[foodNum-1]-quantity;
			System.out.println(res.restaurant[num-1].Quantity[foodNum-1]);
			for(int i=0; i<cus.count; i++)
			{
				if(cus.customer[i].Id.equals(id))
				{   	 num=order[i].restaurantNum;
				order[i].foodNumber=foodNum-1;
				order[i].foodQuantity=quantity;
				order[i].addedFoods[count[i]]=res.restaurant[num-1].foodItems[foodNum-1];
				bill=(quantity)*(res.restaurant[num-1].Price[foodNum-1]);
				totalBill=totalBill+bill;
				count[i]++;
				}
			}

			System.out.println("Do you want to add more food?");
			add=sc.nextInt();

		}
		System.out.println("Total amount:  " +totalBill);

	}

	void Checkout(Customer cus, Restaurant res, String id)
	{
		for(int i=0; i<cus.count; i++)
		{
			if(cus.customer[i].Id.equals(id))
			{ 
				order[i].orderNumber=(int)((Math.random() * 456000)+34567);
				System.out.println("Order placed: ");
				System.out.println("Your order number is: "+ order[i].orderNumber);
				System.out.println("Your total bill is "+ (order[i].foodQuantity)*(res.restaurant[order[i].restaurantNum-1].Price[order[i].foodNumber-1]) + " Rs.");
			}
		}
	}


	void placeOrder(Customer cus, Restaurant res, String id, int num, int foodNum, int quantity)
	{
		Scanner sc = new Scanner(System.in);

		res.restaurant[num-1].Quantity[foodNum-1]=res.restaurant[num-1].Quantity[foodNum-1]-quantity;
		for(int i=0; i<cus.count; i++)
		{
			if(cus.customer[i].Id.equals(id))
			{
				order[i].paid=false;
				order[i].orderNumber=(int)((Math.random() * 456000)+3411567);
				System.out.println("Order placed: ");
				System.out.println("Your order number is: "+ order[i].orderNumber);
				System.out.println(res.restaurant[num-1].foodItems[foodNum-1]);
				double bill=(quantity)*(res.restaurant[num-1].Price[foodNum-1]);
				System.out.println("Your total bill is "+bill + " Rs.");
				System.out.println("1. Pay bill now");
				System.out.println("2. Pay bill on cash");
				int pay=sc.nextInt();
				if(pay==1)
				{
					if(cus.customer[i].Balance-bill<0) 
					{
						System.out.println("Balance not enough");
					}
					else
					{
						System.out.println(cus.customer[i].Balance);
						cus.customer[i].Balance=cus.customer[i].Balance-bill;
						System.out.println(cus.customer[i].Balance);
						System.out.println("Your order has been placed");
					order[i].paid=true;
					}
				}				
				else if(pay==2)
				{
					System.out.println("Your order has been placed, cash will be payed on delivery");
					order[i].paid=false;
				}
			}
		}
	}


	void cancelOrder(Customer cus, Restaurant res, String id,  int num, int foodNum, int quantity)
	{
		if(num==0 || foodNum==0 || quantity==0)
		{
			System.out.println("No order found");
		}

		else
		{ 
			Scanner sc = new Scanner(System.in);
			res.restaurant[num-1].Quantity[foodNum-1]=res.restaurant[num-1].Quantity[foodNum-1]+quantity;
			for(int i=0; i<cus.count; i++)
			{
				if(cus.customer[i].Id.equals(id))
				{
					//order[i].paid=false;
					order[i].orderNumber=0;
					System.out.println("Your order has been canceled");
					double bill=(quantity)*(res.restaurant[num-1].Price[foodNum-1]);	

					if(order[i].paid==true)
					{
						cus.customer[i].Balance=cus.customer[i].Balance+bill;
						System.out.println("You have got your money back");
						System.out.println("Your balance is: "+cus.customer[i].Balance);
					}


				}
			}
		}
	}

	

	void Read()
	{
		try {
		      File myobj = new File("OrderData.txt");
		      
		     
		      
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
		
		FileReader obj = new FileReader("OrderData.txt");
		Scanner reader = new Scanner(obj);
		int i = 0;
		while(reader.hasNext())
		{
			String data = reader.nextLine();
			String array [] = data.split(", ");
			
			order[i].orderNumber =(int)Double.parseDouble(array[0]);
			
			order[i].restaurantNumber = (int)Double.parseDouble (array[1]);

			order[i].restaurantNum=(int)Double.parseDouble(array[2]);

			order[i].foodNumber	=(int)Double.parseDouble(array[3]);
			
			order[i].foodQuantity=(int)Double.parseDouble(array[4]);

			order[i].Payment=Double.parseDouble(array[5]);
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
			  FileWriter writer = new FileWriter("OrderData.txt");
			  PrintWriter buffer = new PrintWriter(writer);
			  for (int i =0; i<size; i++)
			  {
				 
					   writer.write(order[i].orderNumber+ ", ");
					  
					  writer.write(order[i].restaurantNumber+", ");

					   writer.write(order[i].restaurantNum+", ");

					   writer.write(order[i].foodNumber+", ");

					   writer.write(order[i].foodQuantity+", " );
				
					   writer.write(order[i].Payment +", " );
										
						   writer.write(order[i].paid+", ");
						   
						 //  writer.write(Deduction[i]+", ");
						   						   
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
