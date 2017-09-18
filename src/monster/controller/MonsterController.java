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
		
		myScanner.close();
	}
}
