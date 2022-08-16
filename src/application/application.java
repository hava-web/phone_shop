package application;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import config.DBhelper;
import module.execute;
import module.product;
import module.store;

final class application {
	private final static int THEM_SAN_PHAM = 1;
	private final static int TIM_KIEM_THEO_LOAI = 2;
	private final static int SAP_XEP_THEO_GIA_TANG_DAN = 3;
	private final static int SAN_PHAM_HET_HAN = 4;
	private final static int THOAT = 5;

	public static void main(String[] args) {
		store myStore = new execute("myStore");
		Scanner in = new Scanner(System.in);
		int option = -1;
		do {
			try {
				System.out.println("----------------Toy Store----------------");
				System.out.println("1. Add product");
				System.out.println("2. Search product");
				System.out.println("3. Order by price");
				System.out.println("4. Take producs that was expired");
				System.out.println("5. Exit");
				System.out.println();
				System.out.print("Enter you select: ");

				option = Integer.parseInt(in.nextLine());

				switch (option) {

				case THEM_SAN_PHAM:
					
					product t1 = new product();

					System.out.print("\t Name of product: ");
					t1.setName(in.nextLine());

					System.out.print("\t Type of product: ");
					t1.setName(in.nextLine());

					System.out.print("\t Price of product: ");
					t1.setPrice(Double.parseDouble(in.nextLine()));

					System.out.print("\t Import date: ");
					SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
					Date parsed = format.parse(in.nextLine());
					t1.setImportDate(new java.sql.Date(parsed.getTime()));

					myStore.insertProduct(t1);

					break;

				case TIM_KIEM_THEO_LOAI:
					System.out.print("Search by type: ");
					String keyword = in.nextLine();
					product t2 = myStore.searchProductByType(keyword);
					if (t2 == null) {
						System.out.println("\t Product by type");
						break;
					}
					System.out.println(t2);
					break;

				case SAP_XEP_THEO_GIA_TANG_DAN:
					List<product> list1 = myStore.orderByASC();
					if (list1.isEmpty()) {
						System.out.println("\t Products list");
						break;
					}

					for (product t3 : list1) {
						System.out.println(t3);
					}
					break;

				case SAN_PHAM_HET_HAN:
					List<product> list2 = myStore.listExpiration();
					if (list2.isEmpty()) {
						System.out.println("\t Products list");
						break;
					}
					for (product t4 : list2) {
						System.out.println(t4);
					}
					break;

				case THOAT:
					System.out.println("\t ThoÃ¡t khá»�i chÆ°Æ¡ng trÃ¬nh");
					break;

				default:
					System.out.println("\t Lá»±a chá»�n khÃ´ng há»£p lá»‡");
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (option != THOAT);

		
		try {
			in.close();
			DBhelper.getDefaultInstance().getConnection().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
