package org.program;

import java.util.Scanner;

public class Buyer extends Person {

	Scanner scanner=new Scanner(System.in);
	public void showMenu() {

		System.out.println("Hello! Which kind of menu are you looking for?");
		System.out.println("Press 0 for Meat Product Menu");
		System.out.println("Press 1 for Produce Product Menu");
		int nProductCategory=scanner.nextInt();
		if(nProductCategory==0)
		{
            MeatProductMenu meatProductMenu=new MeatProductMenu();
			meatProductMenu.showMenu();
			meatProductMenu.showAddButton();
		}
		else if(nProductCategory==1)
		{
             ProduceProductMenu produceProductMenu=new ProduceProductMenu();
			 produceProductMenu.showMenu();
			 produceProductMenu.showAddButton();
		}

	}

	public ProductMenu CreateProductMenu() {
		return null;
	}

}
