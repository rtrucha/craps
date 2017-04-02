//Trucha, Roger
//CS320 OOP
//Assignment 2

import java.util.Scanner;
import java.lang.Math.*;

public class CrapsGame
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
	
		int keepGoing = 1;
		int bank = 0;
		int bet = 0;
		int roll = 0;
		int point = 0;
		
		System.out.println("WELCOME TO THE GAME OF CRAPS");
		System.out.println("\nInstructions: ");
		System.out.println("Start the game by entering how much money to add in your bank.\n" +
									"You will then bet an amount.\n" +
									"\nIn the game of Craps, you will roll two dice.\n" +
									"If you roll 7 or 11, you win the bet amount.\n" +
									"Otherwise, if you roll 2 or 12 you lose the bet.\n" +
									"If you don't roll either of the above numbers, the amount is called the \n" +
									"point and you continue to roll.\n" +
									"During the point, if you roll 7 you lose.\n" +
									"Otherwise you roll again and the point changes to your next roll.\n" +
									"If your next roll matches the point, you win the amount bet.\n" +
									"And if you have money left in your bank, you may continue playing again.\n\n");
		
		System.out.print("How much money do you want to put in your bank? $");
		bank = keyboard.nextInt();
		
		while(bank != 0 && keepGoing == 1)
		{
			System.out.println("The amount in your bank is: $" + bank + "\n\n");
			
			System.out.print("How much are you willing to bet? $");
			bet = keyboard.nextInt();
			
			while(bet > bank)
			{
				System.out.println("\nSorry, you do not have that much in your bank.");
				System.out.println("Please bet up to $" + bank + "\n");
			
				System.out.print("\n\nHow much are you willing to bet? $");
				bet = keyboard.nextInt();				
			}
			
			Roll_Die_1();
			Roll_Die_2();
			roll = Roll_Die_1() + Roll_Die_2();
			
			System.out.println("\nYou rolled " + roll + "\n");
			
			if(roll == 2 || roll == 12)
			{
				System.out.println("Sorry, you lose $" + bet + "\n");
				bank -= bet;
				System.out.println("\nThe amount in your bank is: $" + bank + "\n\n");
			}

			else if(roll == 7 || roll == 11)
			{
				System.out.println("YOU WIN $" + bet + "\n");
				bank += bet;				
			}
			
			else
			{
				System.out.println("You did not win or lose on the first roll, going to the point...\n");
				point = roll;
				System.out.println("The point starts at " + point + "\n");
				
				while(roll != 7)
				{
					Roll_Die_1();
					Roll_Die_2();
					roll = Roll_Die_1() + Roll_Die_2();
					point = roll;


					System.out.println("\nYou rolled " + roll);
					System.out.println("The point is now " + point + "\n");				
									
					if(roll == 7)
					{
						System.out.println("Since you rolled 7 on the point, you lose $" + bet + "\n");
						bank -= bet;
						System.out.println("\nThe amount in your bank is: $" + bank + "\n\n");
						break;
				
					}
					
					Roll_Die_1();
					Roll_Die_2();
					roll = Roll_Die_1() + Roll_Die_2();	
					System.out.println("\nYou rolled " + roll + " this time.");
										
					if(roll == point)
					{
						System.out.println("\nYou hit the point with a roll of " + roll + "\n");						

						System.out.println("YOU WIN $" + bet + "\n");
						bank += bet;
						System.out.println("\nThe amount in your bank is: $" + bank + "\n\n");	
						break;
					}
					
					else
					{
						point = roll;
						System.out.println("The point is now " + point + "\n");	
		
						if(roll == 7)
						{
							System.out.println("Since you rolled 7 on the point, you lose $" + bet + "\n");
							bank -= bet;
							System.out.println("\nThe amount in your bank is: $" + bank + "\n\n");
							break;
						}
						
					}
					
				}
		
			}
			
			if(bank != 0)
			{		
				System.out.println("Do you wish to continue? ");
				System.out.print("Press 1 to continue or press any other integer to quit: ");
				keepGoing = keyboard.nextInt();
			}
			else
				keepGoing = 0;	
		}
		
		System.out.println("\nSorry, you have ended the game with $" + bank);
		System.out.println("See you next time when you have more money...");
		System.out.println("Press any key to quit game.");
	}



	public static int Roll_Die_1()
	{
		int d1 = 0;
		d1 = (int)(Math.random() * 6) + 1;
		return d1;
	}
	
	
	public static int Roll_Die_2()
	{
		int d2 = 0;
		d2 = (int)(Math.random() * 6) + 1;
		return d2;
	}	


//	public static int Add_Dice(int d1, int d2)
//	{
//		int sum = d1 + d2;
//		return sum;
//	}

}