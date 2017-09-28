package monster.controller;

import monster.model.MarshmallowMonster;
import java.util.Scanner;
import monster.view.MonsterDisplay;

public class MonsterController
{
	private MonsterDisplay popup;
	
	public MonsterController()
	{
		popup = new MonsterDisplay();
	}
	
	public void start()
	{
//		int count = 0;
//		while (count < 10)
//		{
//			popup.displayText("Am I not the coolest?")
//			count -=2;
//		}
//		
//		for(int loop = 0; loop < 10; loop += 1)
//		{
//			popup.displayText("This is loop # " + (loop + 1) + " of ten");
//		}
		
		MarshmallowMonster basic = new MarshmallowMonster();
//		System.out.println(basic);
		MarshmallowMonster nelson = new MarshmallowMonster("Nelson", 2, 3, 0, true);
		popup.displayText(nelson.toString());
//		System.out.println(nelson);
		popup.displayText("I'm feeling hungry, I'm going to eat one of Nelson's arms");
		nelson.setArmCount(nelson.getArmCount() - 1);
		popup.displayText(nelson.toString());
		
		interactWithMonster(nelson);
	}
	
	private void interactWithMonster(MarshmallowMonster currentMonster)
	{
		Scanner myScanner = new Scanner(System.in);
		String response = popup.getResponse(currentMonster.getName() + " wants to know how many eyes you want to eat, please type in how many.");
		
		while(!isInteger(response))
		{
			popup.displayText("Grrr, type in a better answer next time");
			response = popup.getResponse("Type in a integer value!");
		}
		
		int consumed = 0;
		
		if(Integer.parseInt(response) > currentMonster.getEyeCount())
		{
			popup.displayText("I don't have that many eyes! Just eat all of them if you want that much.");
			consumed = currentMonster.getEyeCount();
		}
		else if (Integer.parseInt(response) < 0)
		{
			popup.displayText("You can't eat a negative amount of eyes! Just have none.");
			consumed = 0;
		}
		else
		{
			consumed = Integer.parseInt(response);	
		}
		currentMonster.setEyeCount(currentMonster.getEyeCount() - consumed);
		
		popup.displayText("I have " + currentMonster.getEyeCount() + " eye(s) now.");
		
		System.out.println(currentMonster);
		
		System.out.println("How many arms are you interested in eating?, I have " + currentMonster.getArmCount());
		consumed = myScanner.nextInt();
		
		 if(consumed == 0)
		 {
			 System.out.println("Not hungry? oh so sad...");
		 }
		 else if(consumed < 0)
		 {
			 System.out.println("Math is hard for you - it is impossible to eat a negative amount");
		 }
		 
		 else if (consumed - currentMonster.getArmCount() > 0)
		 {
			 System.out.println("You are not allowed to eat more than exist on me :/");
		 }
		 
		 else
		 {
			 currentMonster.setArmCount(currentMonster.getArmCount() - consumed);
			 System.out.println("Ok, now I have this many arms " + currentMonster.getArmCount());
		 }
		 
		 if (currentMonster.hasBloop() == true)
		 {
			 System.out.println("I still have a bloop or many bloops left for you to eat, would you like to eat them?(1 = Yes, 0 = No)");
			 int userResponse = myScanner.nextInt();
			 
			 if (userResponse == 0)
			 {
				 System.out.println("Aw, they are really tasty :(");
			 }
			 else if (userResponse == 1)
			 {
				 currentMonster.setBloop(false);
				 System.out.println("Thank you for eating all my bloops!");
			 }
			 else 
			 {
				 System.out.println("I wasn't asking that, but that's ok!");
			 }
		 }
		 
		 popup.displayText("Hi there, ready to play??");
		 String answer = popup.getResponse("What is the air speed of a coconut laden swallow?");
		 System.out.println(answer);
		 
		myScanner.close();
	}
	
	private boolean isInteger(String input)
	{
		boolean isInt = false;
		
		try
		{
			Integer.parseInt(input);
			isInt = true;
		}
		catch(NumberFormatException error)
		{
			popup.displayText("You did not type in a valid integer");
		}
		
		return isInt;
	}
	
	private boolean isDouble(String input)
	{
		boolean isDouble = false;
		
		try
		{
			Double.parseDouble(input);
			isDouble = true;
		}
		catch(NumberFormatException error)
		{
			popup.displayText("You did not type in a valid double");
		}
		
		return isDouble;
	}
}
