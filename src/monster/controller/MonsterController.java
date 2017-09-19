package monster.controller;

import monster.model.MarshmallowMonster;
import java.util.Scanner;

public class MonsterController
{
	public void start()
	{
		MarshmallowMonster basic = new MarshmallowMonster();
		System.out.println(basic);
		MarshmallowMonster nelson = new MarshmallowMonster("Nelson", 2, 3, 0, true);
		System.out.println(nelson);
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
		myScanner.close();
	}
}
