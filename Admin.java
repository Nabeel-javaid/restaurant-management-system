import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Admin {
private final int ID=1;
private final String Password="1";


void removeRestaurant(Restaurant r)
{
	Scanner sc = new Scanner(System.in);
	int n;
	System.out.println("1. Delete Restaurant");
	System.out.println("0. Exit");
	int choice = sc.nextInt();

	if(choice==1)
	{
	System.out.println("Enter restraunt number to delete:");
	n = sc.nextInt();
	n=n-1;
	for(int i=n; i<r.count; i++)
	r.restaurant[n]=r.restaurant[n+1];
	System.out.println(r.count);
	r.count--;
	}
}


void removeCustomers(Customer c)
{
	Scanner sc = new Scanner(System.in);
	int n;
	System.out.println("------------All customers details-------- ");
	
	System.out.println("1. Delete Restaurant");
	System.out.println("0. Exit");
	int choice = sc.nextInt();

	if(choice==1)
	{
	System.out.println("Enter customer number to delete:");
	n = sc.nextInt();
	n=n-1;
	for(int i=n; i<c.count; i++)
	c.customer[n]=c.customer[n+1];
	System.out.println(c.count);
	c.count--;
	}
	
	}

void manageRestaurantFood(Restaurant res)
{
	Scanner sc = new Scanner(System.in);
	int foodNum=0;
	res.showRestaurants();
	System.out.println("Choose a restaurant for which you want to manage food");
	int restaurant = sc.nextInt();
	System.out.println("1. Delete Restaurant food");
	System.out.println("1. Update Restaurant food");
	System.out.println("0. Exit");
	int choice = sc.nextInt();
	if(choice==1 || choice ==2)
	{
		res.showFoodMenu(restaurant);
		if (choice==1)
		System.out.println("Enter food number you want to delete");
		if (choice==2)
		System.out.println("Enter food number you want to delete");
		foodNum=sc.nextInt();
		
	}
	if(choice==1)
	{
		res.deleteFood(restaurant-1, foodNum-1);
	}
	if(choice==2)
	{
		res.update(restaurant-1, foodNum-1);
	}
	
	
	}

int login(int id, String pass)
{
	int count =0;
	while(id!=ID && pass.equals(Password)  )
	{
		if(count<3)
		{
			System.out.println("Incorrect id or password");
		}
		count++;
		if(count==3)
		{
			System.out.println("Three incorrect tries");
			return 0;
		}
	}
if(	id==ID && pass.equals(Password))
{
	System.out.println("Welcome");
	return 1;
	}
return 0;
}


void adminMenu()
{
	System.out.println(
			 "1. Manage Vendors\r\n"
			+ "2. Manage Vendors Products/Food\r\n"
			+ "3. Manage Customers\r\n"
			+ "4. Manage Food Order details\r\n"
			+ "5. Manage Payment details\r\n"
			+ "6. Manage Riders");
	}




}
