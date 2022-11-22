import java.util.Scanner;

public class Main {
	Restaurant r = new Restaurant();
	static void mainMenu()
	{
		System.out.println("Perss 1. Customer");
		System.out.println("Press 2. Rider");
		System.out.println("Press 3. Restaurant");
		System.out.println("Press 4. Admin");	
		System.out.println("Press 0. Exit");
	}


	static void loginOrSignupMenu()
	{
		System.out.println("Press 1. Login");
		System.out.println("Press 2. Signup");
		System.out.println("Press 0. Exit");
	}





	public static void main(String[] args) {

		Restaurant res = new Restaurant();
		Customer cus = new Customer();
		Admin admin = new Admin();
		Rider rider = new Rider();
		Order order = new Order();
		Scanner sc = new Scanner(System.in);
		cus.initialize();
		res.initialize();
		order.initialize();
		rider.initialize();
		

		mainMenu();
		int Choice = sc.nextInt();
		while (Choice!=0) {
			res.Read();
			cus.Read();
			rider.Read();
			order.Read();
			if (Choice==1) {
				System.out.println("-----------Customer-----------");
				loginOrSignupMenu();
				int ch1 = sc.nextInt();
				while (ch1!=0) {
					
					if(ch1==1)
					{
						System.out.println("******Customer login menu******");
						System.out.println("Enter your id: ");
						sc.nextLine();
						String id = sc.nextLine();
						if(cus.login(id)==1)
						{
							cus.customerMenu();
							int CH1= sc.nextInt();
							int restaurantNum=0;
							int foodNum=0;
							int quantity=0;
							while(CH1!=0)
							{


								if(CH1==1)
								{	
									res.showRestaurants();
									System.out.println("Enter restaurant number to show food menu: ");
									restaurantNum=sc.nextInt();
									res.showFoodMenu(restaurantNum);
								}
								if(CH1==2)
								{
									//order.addTOCart(cus, res, id);
								}
								if(CH1==3)
								{
									System.out.println("Enter food number to add it to cart:");
									foodNum= sc.nextInt();
									System.out.println("Enter its quantity:");
									quantity = sc.nextInt();
									order.placeOrder(cus, res, id, restaurantNum, foodNum, quantity);
								}
								if(CH1==4)
								{
									order.cancelOrder(cus, res, id, restaurantNum, foodNum, quantity);
								}
								if(CH1==5)
								{

								}
								if(CH1==6)
								{

								}
								if(CH1==7)
								{

								}
								if(CH1==8)
								{

								}

								cus.customerMenu();
								CH1= sc.nextInt();
							}
						}

					}
					else if(ch1==2)
					{
						System.out.println("Customer sign up");
						cus.createAccount(cus);
						//break;
					}
					loginOrSignupMenu();
					ch1 = sc.nextInt();
				}

			}

			else if (Choice==2) {
				System.out.println("---------Rider---------");
				loginOrSignupMenu();
				int CH2=sc.nextInt();
				while(CH2!=0)
				{
					if(CH2==1)
					{
						rider.login();
					}
					if(CH2==2)
					{
						rider.createAccount();
					}
				}
				int ch2 = sc.nextInt();
			}

			else if (Choice==3) {
				System.out.println("---------Restaurant---------");
				//Scanner inp = new Scanner(System.in);
				loginOrSignupMenu();
				int ch3=sc.nextInt();
				while(ch3!=0)
				{


					if(ch3==2)
					{
						res.CreateAccount();
					}

					else if(ch3==1)
					{
						if(res.login()==1)
						{
							res.restaurantMenu();
							int CH3 = sc.nextInt();

							while (CH3!=0) {
								if (CH3 == 1) {
									res.addFood();
								}
								if (CH3 == 2) {
									int restNum,foodNum;
									Scanner input = new Scanner(System.in);
									System.out.println("Enter restraunt number: ");
									restNum = input.nextInt()-1;
									System.out.println("Enter the Food number you want to update");
									foodNum=input.nextInt()-1;
									res.update(restNum, foodNum);
								}
								//is it working
								if (CH3 == 3) {
									int restNum;
									int foodNum;
									Scanner input = new Scanner(System.in);
									System.out.println("Enter restraunt number: ");
									restNum = input.nextInt()-1;		
									System.out.println("Enter the food number to delete");
									foodNum = input.nextInt()-1;		
									res.deleteFood(restNum, foodNum);
								}
								if (CH3 == 7) {
									res.showRestaurants();
								}
								if (CH3 == 8) {
									res.deleteRestaurant();
								}
								if (CH3 == 9) {
									System.out.println("Enter restaurant number to show food:");
									int c = sc.nextInt();
									res.showFoodMenu(c);
								} 
								res.restaurantMenu();
								CH3 = sc.nextInt();
							}
						}

					}


					loginOrSignupMenu();
					ch3=sc.nextInt();

				}
				//int choice = sc.nextInt();

			}

			else if (Choice==4) {

				System.out.println("---------Admin---------");
				System.out.println("1. Login");
				System.out.println("0. Exit");
				int ch4=sc.nextInt();
				while(ch4!=0)
				{
					if(ch4==1)
					{System.out.println("Enter id");
					int id = sc.nextInt();
					System.out.println("Enter pass");
					sc.nextLine();
					String pass= sc.nextLine();

					if(admin.login(id, pass)==1)
					{
						System.out.println("Welcome");
						admin.adminMenu();
						int CH4=sc.nextInt();
						while(CH4!=0)
						{
							if(CH4==1)
							{
								admin.removeRestaurant(res);
							}
							if(CH4==2)
							{
								admin.manageRestaurantFood(res);
							}
							if(CH4==3)
							{
								admin.removeCustomers(cus);
							}
							if(CH4==4)
							{
							}
							if(CH4==5)
							{
							}
							if(CH4==6)
							{
							}
							admin.adminMenu();
							CH4=sc.nextInt();
						}


					}
					}
					System.out.println("---------Admin---------");
					System.out.println("1. Login");
					System.out.println("0. Exit");
					ch4=sc.nextInt();

				}
			}
			mainMenu();
			Choice = sc.nextInt();
			
			res.Write();
			cus.Write();
			rider.Write();
			order.Write();

		} 


	}

}

