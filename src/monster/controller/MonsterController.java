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
		int count = 0;
		while (count < 10)
		{
			popup.displayText("Am I not the coolest?")
			count -=2;
		}
		
		for(int loop = 0; loop < 10; loop += 1)
		{
			popup.displayText("This is loop # " + (loop + 1) + " of ten");
		}
		
		
		
		MarshmallowMonster basic = new MarshmallowMonster();
//		System.out.println(basic);
		popup.displayText(basic.toString());
		MarshmallowMonster nelson = new MarshmallowMonster("Nelson", 2, 3, 0, true);
//		System.out.println(nelson);
		System.out.println("I am feeling hungry, I am going to eat one of Nelson's arms");
		nelson.setArmCount(nelson.getArmCount() - 1);
		System.out.println(nelson);
		
		interactWithMonster(nelson);
	}
	
	private void interactWithMonster(MarshmallowMonster currentMonster)
	{
		Scanner myScanner = new Scanner(System.in);
		System.out.println(currentMonster.getName() + " wants to know how many eyes you want to eat, please type in how many");
		int consumed = myScanner.nextInt();
		currentMonster.setEyeCount(currentMonster.getEyeCount() - consumed);
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
}
