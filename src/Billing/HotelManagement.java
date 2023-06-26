package Billing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.security.PublicKey;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class HotelManagement {
	static int billno=1;
	Scanner sc = new Scanner(System.in);
	Hotel h = new Hotel();
	User user;

	public void addUser() {
		System.out.println("ENTER THE USER NAME");
		String name = sc.nextLine();
		System.out.println("ENTER THE ADDRESS");
		String address = sc.next();
		System.out.println("ENTER THE PHONE NUMBER");
		long phone = sc.nextLong();

		user = new User(name, address, phone);
		System.out.println("USER ACCOUNT CREATED");
		chooseHotel();

	}

	public void chooseHotel() {

		System.out.println("CHOOSE\n 1.VEG-HOTEL 2.NON-VEG HOTEL");
		switch (sc.nextInt()) {
		case 1:
			h = new Veg();
			break;
		case 2:
			h = new NonVeg();
		default:
			break;
		}

		makeOrder();
	}

	public void makeOrder() {
		if (h instanceof Veg) {
			Veg v1 = (Veg) h;
			Boolean b = true;
			do {
				int sno = 1;

				System.out.println("----------------------------------------------------");
				System.err.println("SR.NO            FOOD NAME                  PRICE     ");
				System.out.println("----------------------------------------------------");
				System.out.println(sno++ + "                " + v1.food1 + "                   " + v1.price1);
				System.out.println(sno++ + "                " + v1.food2 + "                       " + v1.price2);
				System.out.println(sno++ + "                " + v1.food3 + "                       " + v1.price3);
				System.out.println(sno++ + "                " + v1.food4 + "                      " + v1.price4);
				System.out.println(sno++ + "                " + v1.food5 + "                 " + v1.price5);
				System.out.println(sno++ + "                " + v1.food6 + "       " + v1.price6);
				System.out.println(sno++ + "                " + v1.food7 + "                 " + v1.price7);
				System.out.println(sno++ + "                " + v1.food8 + "                    " + v1.price8);
				System.out.println("----------------------------------------------------");

				switch (sc.nextInt()) {
				case 1:
					System.out.println("ENTER THE QUANTITY");
					v1.qty1 += sc.nextInt();
					break;
				case 2:
					System.out.println("ENTER THE QUANTITY");
					v1.qty2 += sc.nextInt();
					break;
				case 3:
					System.out.println("ENTER THE QUANTITY");
					v1.qty3 += sc.nextInt();
					break;
				case 4:
					System.out.println("ENTER THE QUANTITY");
					v1.qty4 += sc.nextInt();
					break;
				case 5:
					System.out.println("ENTER THE QUANTITY");
					v1.qty5 += sc.nextInt();
					break;
				case 6:
					System.out.println("ENTER THE QUANTITY");
					v1.qty6 += sc.nextInt();
					break;
				case 7:
					System.out.println("ENTER THE QUANTITY");
					v1.qty7 += sc.nextInt();
					break;
				case 8:
					System.out.println("ENTER THE QUANTITY");
					v1.qty8 += sc.nextInt();
					break;

				default:

					break;
				}
				System.out.println("1. ORDER MORE 2.GENERATE BILL");
				if (sc.nextInt() == 2)
					b = false;

			} while (b);
			bill();
		}
		if (h instanceof NonVeg) {
			NonVeg v2 = (NonVeg) h;
			Boolean b = true;
			do {
				int sno = 1;
				System.out.println("----------------------------------------------------");
				System.err.println("SR.NO            FOOD NAME                  PRICE     ");
				System.out.println("----------------------------------------------------");
				System.out.println(sno++ + "                " + v2.food1 + "                   " + v2.price1);
				System.out.println(sno++ + "                " + v2.food2 + "                       " + v2.price2);
				System.out.println(sno++ + "                " + v2.food3 + "                       " + v2.price3);
				System.out.println(sno++ + "                " + v2.food4 + "                      " + v2.price4);
				System.out.println(sno++ + "                " + v2.food5 + "                 " + v2.price5);
				System.out.println(sno++ + "                " + v2.food6 + "       " + v2.price6);
				System.out.println(sno++ + "                " + v2.food7 + "                 " + v2.price7);
				System.out.println(sno++ + "                " + v2.food8 + "                    " + v2.price8);
				System.out.println(sno++ + "                " + v2.food9 + "            " + v2.price9);
				System.out.println(sno++ + "               " + v2.food10 + "              " + v2.price10);
				System.out.println("----------------------------------------------------");

				switch (sc.nextInt()) {
				case 1:
					System.out.println("ENTER THE QUANTITY");
					v2.qty1 += sc.nextInt();
					break;
				case 2:
					System.out.println("ENTER THE QUANTITY");
					v2.qty2 += sc.nextInt();
					break;
				case 3:
					System.out.println("ENTER THE QUANTITY");
					v2.qty3 += sc.nextInt();
					break;
				case 4:
					System.out.println("ENTER THE QUANTITY");
					v2.qty4 += sc.nextInt();
					break;
				case 5:
					System.out.println("ENTER THE QUANTITY");
					v2.qty5 += sc.nextInt();

					break;
				case 6:
					System.out.println("ENTER THE QUANTITY");
					v2.qty6 += sc.nextInt();
					break;
				case 7:
					System.out.println("ENTER THE QUANTITY");
					v2.qty7 += sc.nextInt();

					break;
				case 8:
					System.out.println("ENTER THE QUANTITY");
					v2.qty8 += sc.nextInt();
					break;
				case 9:
					System.out.println("ENTER THE QUANTITY");
					v2.qty9 += sc.nextInt();
					break;
				case 10:
					System.out.println("ENTER THE QUANTITY");
					v2.qty10 += sc.nextInt();
					break;

				default:
					break;
				}

				System.out.println("1. ORDER MORE 2.GENERATE BILL");
				if (sc.nextInt() == 2)
					b = false;
			} while (b);
			bill();
		}
	}

	public void bill() {
		int sno = 1;
		double sum = 0;
		if (h instanceof Veg) {
			Veg v1 = (Veg) h;
			System.out.println("--------------------------------------------------------------------------------");
			System.err.println("SR.NO            FOOD NAME                QUANTITY              PRICE     ");
			System.out.println("--------------------------------------------------------------------------------");

			if (v1.qty1 != 0) {

				System.out.println(sno++ + "                " + v1.food1 + "                   " + v1.qty1
						+ "                     " + (v1.qty1 * v1.price1));
				sum += (v1.price1 * v1.qty1);
			}
			if (v1.qty2 != 0) {

				System.out.println(sno++ + "                " + v1.food2 + "                       " + v1.qty2
						+ "                     " + (v1.qty2 * v1.price2));
				sum += (v1.price2 * v1.qty2);
			}
			if (v1.qty3 != 0) {

				System.out.println(sno++ + "                " + v1.food3 + "                       " + v1.qty3
						+ "                     " + (v1.qty3 * v1.price3));
				sum += (v1.price3 * v1.qty3);
			}
			if (v1.qty4 != 0) {

				System.out.println(sno++ + "                " + v1.food4 + "                      " + v1.qty4
						+ "                     " + (v1.qty4 * v1.price4));
				sum += (v1.price4 * v1.qty4);
			}
			if (v1.qty5 != 0) {

				System.out.println(sno++ + "                " + v1.food5 + "                 " + v1.qty5
						+ "                     " + (v1.qty5 * v1.price5));
				sum += (v1.price5 * v1.qty5);
			}
			if (v1.qty6 != 0) {

				System.out.println(sno++ + "                " + v1.food6 + "       " + v1.qty6 + "                     "
						+ (v1.qty6 * v1.price6));
				sum += (v1.price6 * v1.qty6);
			}
			if (v1.qty7 != 0) {

				System.out.println(sno++ + "                " + v1.food7 + "                 " + v1.qty7
						+ "                     " + (v1.qty7 * v1.price7));
				sum += (v1.price7 * v1.qty7);
			}
			if (v1.qty8 != 0) {

				System.out.println(sno++ + "                " + v1.food8 + "                    " + v1.qty8
						+ "                     " + (v1.qty8 * v1.price8));
				sum += (v1.price8 * v1.qty8);
			}

		}
		if (h instanceof NonVeg) {
			NonVeg v2 = (NonVeg) h;
			System.out.println("--------------------------------------------------------------------------------");
			System.err.println("SR.NO            FOOD NAME                 QUANTITY              PRICE     ");
			System.out.println("--------------------------------------------------------------------------------");

			if (v2.qty1 != 0) {

				System.out.println(sno++ + "                " + v2.food1 + "                   " + v2.qty1
						+ "                     " + (v2.qty1 * v2.price1));
				sum += (v2.price1 * v2.qty1);
			}
			if (v2.qty2 != 0) {

				System.out.println(sno++ + "                " + v2.food2 + "                       " + v2.qty2
						+ "                     " + (v2.qty2 * v2.price2));
				sum += (v2.price2 * v2.qty2);
			}
			if (v2.qty3 != 0) {

				System.out.println(sno++ + "                " + v2.food3 + "                       " + v2.qty3
						+ "                     " + (v2.qty3 * v2.price3));
				sum += (v2.price3 * v2.qty3);
			}
			if (v2.qty4 != 0) {

				System.out.println(sno++ + "                " + v2.food4 + "                      " + v2.qty4
						+ "                     " + (v2.qty4 * v2.price4));
				sum += (v2.price4 * v2.qty4);
			}
			if (v2.qty5 != 0) {

				System.out.println(sno++ + "                " + v2.food5 + "                 " + v2.qty5
						+ "                     " + (v2.qty5 * v2.price5));
				sum += (v2.price5 * v2.qty5);
			}
			if (v2.qty6 != 0) {

				System.out.println(sno++ + "                " + v2.food6 + "       " + v2.qty6 + "                     "
						+ (v2.qty6 * v2.price6));
				sum += (v2.price6 * v2.qty6);
			}
			if (v2.qty7 != 0) {

				System.out.println(sno++ + "                " + v2.food7 + "                 " + v2.qty7
						+ "                     " + (v2.qty7 * v2.price7));
				sum += (v2.price7 * v2.qty7);
			}
			if (v2.qty8 != 0) {

				System.out.println(sno++ + "                " + v2.food8 + "                    " + v2.qty8
						+ "                     " + (v2.qty8 * v2.price8));
				sum += (v2.price8 * v2.qty8);
			}
			if (v2.qty9 != 0) {

				System.out.println(sno++ + "                " + v2.food9 + "            " + v2.qty9
						+ "                     " + (v2.qty9 * v2.price9));
				sum += (v2.price9 * v2.qty9);
			}
			if (v2.qty10 != 0) {

				System.out.println(sno++ + "               " + v2.food10 + "              " + v2.qty10
						+ "                     " + (v2.qty10 * v2.price10));
				sum += (v2.price10 * v2.qty10);
			}

		}
		System.out.println("________________________________________________________________________________");
		System.out.println("TOTAL-------------------------------------------------------------" + sum);
		System.out.println("PLEASE ENTER THE TO AMOUNT TO PAY THE BILL");
		if (sc.nextDouble() >= sum) {
			System.err.println("PAYMENNT SUCESSFULL");
			try {
				writefile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			System.out.println("PAYMENT FAILED");
			bill();
		}

	}

	public void writefile() throws IOException {
		File file = new File("C:\\Users\\Sweetashdoll\\Desktop\\Billing");
		if (!(file.exists())) {
			file.mkdir();
			System.err.println("FOLDER CREATED");

		}
		File file2 = new File("C:\\Users\\Sweetashdoll\\Desktop\\Billing\\bill.txt");
		if (!(file2.exists())) {
			try {
				file2.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("FILE IS CREATED");

			}

		FileWriter fileWriter = new FileWriter(file2, true);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		try (BufferedWriter bufferedWriter = new BufferedWriter(printWriter)) {
			bufferedWriter.write("Bill No :" + "           " + billno++);
			bufferedWriter.newLine();
			bufferedWriter.write("Date :" + "         " + getDate());
			bufferedWriter.newLine();
			bufferedWriter.write("Time :" + "      " + getTime());
			bufferedWriter.newLine();
			bufferedWriter.write("Customer Name :" + "       " + user.name);
			bufferedWriter.newLine();

			int sno = 1;
			double sum = 0;
			if (h instanceof Veg) {
				Veg v1 = (Veg) h;
				bufferedWriter.write("----------------------------------------------------------------------------");
				bufferedWriter.newLine();
				bufferedWriter.write("SR.NO            FOOD NAME                QUANTITY              PRICE     ");
				bufferedWriter.newLine();
				bufferedWriter.write("--------------------------------------------------------------------------------");
				bufferedWriter.newLine();

				if (v1.qty1 != 0) {

					bufferedWriter.write(sno++ + "                " + v1.food1 + "                   " + v1.qty1
							+ "                     " + (v1.qty1 * v1.price1));
					sum += (v1.price1 * v1.qty1);
					bufferedWriter.newLine();
				}
				if (v1.qty2 != 0) {

					bufferedWriter.write(sno++ + "                " + v1.food2 + "                       " + v1.qty2
							+ "                     " + (v1.qty2 * v1.price2));
					sum += (v1.price2 * v1.qty2);
					bufferedWriter.newLine();
				}
				if (v1.qty3 != 0) {

					bufferedWriter.write(sno++ + "                " + v1.food3 + "                       " + v1.qty3
							+ "                     " + (v1.qty3 * v1.price3));
					sum += (v1.price3 * v1.qty3);
					bufferedWriter.newLine();
				}
				if (v1.qty4 != 0) {

					bufferedWriter.write(sno++ + "                " + v1.food4 + "                      " + v1.qty4
							+ "                     " + (v1.qty4 * v1.price4));
					sum += (v1.price4 * v1.qty4);
					bufferedWriter.newLine();
				}
				if (v1.qty5 != 0) {

					bufferedWriter.write(sno++ + "                " + v1.food5 + "                 " + v1.qty5
							+ "                     " + (v1.qty5 * v1.price5));
					sum += (v1.price5 * v1.qty5);
					bufferedWriter.newLine();
				}
				if (v1.qty6 != 0) {

					bufferedWriter.write(sno++ + "                " + v1.food6 + "       " + v1.qty6
							+ "                     " + (v1.qty6 * v1.price6));
					sum += (v1.price6 * v1.qty6);
					bufferedWriter.newLine();
				}
				if (v1.qty7 != 0) {

					bufferedWriter.write(sno++ + "                " + v1.food7 + "                 " + v1.qty7
							+ "                     " + (v1.qty7 * v1.price7));
					sum += (v1.price7 * v1.qty7);
					bufferedWriter.newLine();
				}
				if (v1.qty8 != 0) {

					bufferedWriter.write(sno++ + "                " + v1.food8 + "                    " + v1.qty8
							+ "                     " + (v1.qty8 * v1.price8));
					sum += (v1.price8 * v1.qty8);
					bufferedWriter.newLine();
				}

			}
			if (h instanceof NonVeg) {
				NonVeg v2 = (NonVeg) h;
				bufferedWriter.write("--------------------------------------------------------------------------------");
				bufferedWriter.newLine();
				bufferedWriter.write("SR.NO            FOOD NAME                 QUANTITY              PRICE     ");
				bufferedWriter.newLine();
				bufferedWriter.write("--------------------------------------------------------------------------------");
				bufferedWriter.newLine();

				if (v2.qty1 != 0) {

					bufferedWriter.write(sno++ + "                " + v2.food1 + "                   " + v2.qty1
							+ "                     " + (v2.qty1 * v2.price1));
					sum += (v2.price1 * v2.qty1);
					bufferedWriter.newLine();
				}
				if (v2.qty2 != 0) {

					bufferedWriter.write(sno++ + "                " + v2.food2 + "                       " + v2.qty2
							+ "                     " + (v2.qty2 * v2.price2));
					sum += (v2.price2 * v2.qty2);
					bufferedWriter.newLine();
				}
				if (v2.qty3 != 0) {

					bufferedWriter.write(sno++ + "                " + v2.food3 + "                       " + v2.qty3
							+ "                     " + (v2.qty3 * v2.price3));
					sum += (v2.price3 * v2.qty3);
					bufferedWriter.newLine();
				}
				if (v2.qty4 != 0) {

					bufferedWriter.write(sno++ + "                " + v2.food4 + "                      " + v2.qty4
							+ "                     " + (v2.qty4 * v2.price4));
					sum += (v2.price4 * v2.qty4);
					bufferedWriter.newLine();
				}
				if (v2.qty5 != 0) {

					bufferedWriter.write(sno++ + "                " + v2.food5 + "                 " + v2.qty5
							+ "                     " + (v2.qty5 * v2.price5));
					sum += (v2.price5 * v2.qty5);
					bufferedWriter.newLine();
				}
				if (v2.qty6 != 0) {

					bufferedWriter.write(sno++ + "                " + v2.food6 + "       " + v2.qty6
							+ "                     " + (v2.qty6 * v2.price6));
					sum += (v2.price6 * v2.qty6);
					bufferedWriter.newLine();
				}
				if (v2.qty7 != 0) {

					bufferedWriter.write(sno++ + "                " + v2.food7 + "                 " + v2.qty7
							+ "                     " + (v2.qty7 * v2.price7));
					sum += (v2.price7 * v2.qty7);
					bufferedWriter.newLine();
				}
				if (v2.qty8 != 0) {

					bufferedWriter.write(sno++ + "                " + v2.food8 + "                    " + v2.qty8
							+ "                     " + (v2.qty8 * v2.price8));
					sum += (v2.price8 * v2.qty8);
					bufferedWriter.newLine();
				}
				if (v2.qty9 != 0) {

					bufferedWriter.write(sno++ + "                " + v2.food9 + "            " + v2.qty9
							+ "                     " + (v2.qty9 * v2.price9));
					sum += (v2.price9 * v2.qty9);
					bufferedWriter.newLine();
				}
				if (v2.qty10 != 0) {

					bufferedWriter.write(sno++ + "               " + v2.food10 + "              " + v2.qty10
							+ "                     " + (v2.qty10 * v2.price10));
					sum += (v2.price10 * v2.qty10);
					bufferedWriter.newLine();
				}
				bufferedWriter.newLine();
				bufferedWriter.write("________________________________________________________________________________");
				bufferedWriter.newLine();
				bufferedWriter.write("TOTAL-------------------------------------------------------------" + sum);
				bufferedWriter.newLine();
				bufferedWriter.write("Thank You ! Visit Again" + (char) 2);
				bufferedWriter.newLine();
				bufferedWriter.write("________________________________________________________________________________");
				bufferedWriter.newLine();
				bufferedWriter.flush();
			}
		}

	}

	public String getDate() {
		String Date = "  ";
		LocalDate ld = LocalDate.now();
		Date += ld.getDayOfMonth() + " : ";
		Date += ld.getMonth() + " : ";
		Date += ld.getYear() + " : ";
		return Date;

	}

	public String getTime() {
		String Time = " ";
		LocalTime lt = LocalTime.now();
		Time += lt.getHour() + " : ";
		Time += lt.getMinute() + " :";
		Time += lt.getSecond() + " : ";
		return Time;
	}
}
