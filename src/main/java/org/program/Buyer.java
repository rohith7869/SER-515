package org.program;

import java.util.Scanner;

public class Buyer extends Person {

	Scanner scanner=new Scanner(System.in);
	public void showMenu(int userType) {


			System.out.println("Hello! Which kind of menu are you looking for?");
			System.out.println("Press 0 for Meat Product Menu");
			System.out.println("Press 1 for Produce Product Menu");
			int nProductCategory=scanner.nextInt();
			if(nProductCategory==0)
			{
				MeatProductMenu meatProductMenu=new MeatProductMenu();
				meatProductMenu.showMenu(userType);
				meatProductMenu.showAddButton(userType);
			}
			else if(nProductCategory==1)
			{
				ProduceProductMenu produceProductMenu=new ProduceProductMenu();
				produceProductMenu.showMenu(userType);
				produceProductMenu.showAddButton(userType);
			}



	}

	public ProductMenu CreateProductMenu() {
		return null;
	}

}
