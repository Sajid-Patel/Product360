package com.jbk;

import java.util.List;
import java.util.Scanner;

import com.jbk.entity.Product;
import com.jbk.operation.Operation;
import com.jbk.utility.UserData;

public class Test {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Operation operation = new Operation();
		int choice;

		boolean wantToContinue = true;

		do {
			System.out.println("Press 1 to Add Product");
			System.out.println("Press 2 to Delete Product by Id");
			System.out.println("Press 3 to Get Product by Id");
			System.out.println("Press 4 to Update Product");
			System.out.println("Press 5 to Get All Products");
			System.out.println("Press 6 to Get All Products as per order");
			System.out.println("Press 7 to Get Limited Products");
			System.out.println("Press 8 to Get Product by Name");
			System.out.println("Press 9 to Get Product on given Ids");
			System.out.println("Press 10 to Get Product between Ids");
			System.out.println("Press 11 to Get Product count");
			System.out.println("Press 12 to Get Product Price by Min count");

			// Hibernate Query eg:
			System.out.println("Press 13 for Hibernate Query eg-1");

			System.out.println("Press 0 to exit");

			choice = scanner.nextInt();
			switch (choice) {
			case 0: {
				wantToContinue = false;
				break;
			}
			case 1: {
				Product product = UserData.getProductInfoFromUser();
				String msg = operation.addProduct(product);
				System.out.println(msg);
				break;
			}
			case 2: {
				System.out.println("Enter product Id");
				int productId = scanner.nextInt();
				String msg = operation.deleteProduct(productId);
				System.out.println(msg);
				break;
			}
			case 3: {
				System.out.println("Enter product Id");
				int productId = scanner.nextInt();
				Object obj = operation.getProductById(productId);
				System.out.println(obj);
				break;
			}
			case 4: {
				System.out.println("Enter product Id");
				int id = scanner.nextInt();
				Product product = UserData.getProductInfoFromUser();
				product.setProductId(id);
				String msg = operation.updateProduct(product);
				System.out.println(msg);
				break;
			}

			case 5: {
				List<Product> list = operation.getAllProducts();
				if (!list.isEmpty()) {
					for (Product product : list) {
						System.out.println(product);
					}
				} else {
					System.out.println("No record fount");
				}

				break;
			}

			case 6: {
				List<Product> list = operation.getAllProductsByOrder();
				if (!list.isEmpty()) {
					for (Product product : list) {
						System.out.println(product);
					}
				} else {
					System.out.println("No record fount");
				}

				break;
			}

			case 7: {
				List<Product> list = operation.getLimitedProducts();
				if (!list.isEmpty()) {
					for (Product product : list) {
						System.out.println(product);
					}
				} else {
					System.out.println("No record fount");
				}

				break;
			}

			case 8: {
				System.out.println("Enter product name");
				String name = scanner.next();
				List<Product> list = operation.getProductsByName(name);
				if (!list.isEmpty()) {
					for (Product product : list) {
						System.out.println(product);
					}
				} else {
					System.out.println("No record fount");
				}

				break;
			}
			case 9: {

				List<Product> list = operation.getProductsByIds();
				if (!list.isEmpty()) {
					for (Product product : list) {
						System.out.println(product);
					}
				} else {
					System.out.println("No record fount");
				}

				break;
			}

			case 10: {

				List<Product> list = operation.getProductsBetweenIds();
				if (!list.isEmpty()) {
					for (Product product : list) {
						System.out.println(product);
					}
				} else {
					System.out.println("No record fount");
				}

				break;
			}
			case 11: {

				long count = operation.productCount();
				System.out.println(count);

				break;
			}
			case 12: {

				double count = operation.productCountMin();
				System.out.println(count);

				break;
			}

			case 13: {
				List<Product> list = operation.queryEg1();
				if (!list.isEmpty()) {
					for (Product product : list) {
						System.out.println(product);
					}
				} else {
					System.out.println("No record fount");
				}

				break;
			}

			default:
				System.out.println("invalid choice");
				break;
			}

		} while (wantToContinue);
		System.out.println("App Terminated");
	}

}
