package org.program;

import java.util.Scanner;

public class Seller extends Person {

	Scanner scanner=new Scanner(System.in);
	public void showMenu() {

		System.out.println("Hello! Which kind of menu you are looking for?");
		System.out.println("Press 0 for Meat Product Menu Creation");
		System.out.println("Press 1 for Produce Product Menu Creation");
		int nProductCategory=scanner.nextInt();
		if(nProductCategory==0)
		{
			MeatProductMenu meatProductMenu=new MeatProductMenu();
			meatProductMenu.showMenu();
		}
		else if(nProductCategory==1)
		{
			ProduceProductMenu produceProductMenu=new ProduceProductMenu();
			produceProductMenu.showMenu();
		}
	}

	public ProductMenu CreateProductMenu() {
		return null;
	}

}
