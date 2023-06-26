package Billing;

import java.util.Scanner;

public class HotelDriver {
	public static void main(String[] args) {
		HotelManagement hm = new HotelManagement();
		Scanner scanner = new Scanner(System.in);
		Boolean flag = true;

		do {
			System.err.println("CHOOSE\n 1.ADD-USER\n 2.CHOOSE HOTEL\n 3.MAKE ORDER\n 4.BILL\n 5.EXIT ");
			switch (scanner.nextInt()) {
			case 1:
				hm.addUser();
				break;
			case 2:
				hm.chooseHotel();
				break;
			case 3:
				hm.makeOrder();
				break;
			case 4:
				hm.bill();
				break;
			case 5:
				return;

			default:
				break;
			}

		} while (flag);
	}
}
