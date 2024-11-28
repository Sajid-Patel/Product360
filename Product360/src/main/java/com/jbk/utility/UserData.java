package com.jbk.utility;

import java.util.Scanner;

import com.jbk.entity.Product;

public class UserData {
	public static Product getProductInfoFromUser() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Product Name");
		String productName = scanner.nextLine();

		System.out.println("Enter Product Qty");
		int productQty = scanner.nextInt();

		System.out.println("Enter Product Price");
		double productPrice = scanner.nextDouble();

		System.out.println("Enter Product MFG Date");
		String mfgDate = scanner.next();

		System.out.println("Enter Product Exp Date");
		String expDate = scanner.next();
		Product product = new Product(productName, productQty, productPrice, mfgDate, expDate);

		return product;
	}

}
