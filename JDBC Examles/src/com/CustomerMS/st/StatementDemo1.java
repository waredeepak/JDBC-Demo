package com.CustomerMS.st;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class StatementDemo1 {

	Connection con;
	Statement stmt;

	public StatementDemo1() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager
					.getConnection("jdbc:mysql://localhost/JDBC1?user=root&password=root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String addCustomer(String custId, String name, String address,
			String contact) {
		String status = "", sql = "insert into Customer(custId,custName)values('"
				+ custId + "','" + name + "')";
		if (address.trim().length() != 0) {
			sql = "insert into Customer(custId,custName,custAddress)values('"
					+ custId + "','" + name + "','" + address + "')";
		}
		if (contact.trim().length() != 0) {
			sql = "insert into Customer(custId,custName,custAddress,custContact)values('"
					+ custId
					+ "','"
					+ name
					+ "','"
					+ address
					+ "','"
					+ contact
					+ "')";
		}
		try {
			stmt = con.createStatement();
			int i = stmt.executeUpdate(sql);
			if (i != 0) {
				status = "Inserted";
			} else {
				status = "Not Inserted";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public String editCustomer(String custid, String address, String contact) {
		String status = "", sql = "";
		if (address.trim().length() != 0) {
			sql = "update Customer set custAddress='" + address
					+ "' where custId='" + custid + "'";
		}
		if (contact.trim().length() != 0) {
			sql = "update Customer set custcontact='" + contact
					+ "' where custId='" + custid + "'";
		}
		if ((contact.trim().length() != 0) && (address.trim().length() != 0)) {
			sql = "update Customer set custAddress='" + address
					+ "',custcontact='" + contact + "' where custId='" + custid
					+ "'";
		}
		if (sql.trim().length() == 0) {
			status = "Please provide new values";
		} else {
			try {
				stmt = con.createStatement();
				int i = stmt.executeUpdate(sql);
				if (i != 0) {
					status = "Customer details updated successfully";
				} else {
					status = "Customer details not updated ";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return status;
	}

	public void searchCustomer(String custid) {
		String sql = "";
		if (custid.trim().length() == 0) {
			sql = "select * from Customer";
		} else {
			sql = "select * from Customer where custid='" + custid + "'";
		}
		try {
			stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(sql);
			while (res.next()) {
				System.out.print(res.getString(1));
				System.out.print("\t" + res.getString(2));
				System.out.print("\t" + res.getString(3));
				System.out.println("\t" + res.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String deleteCustomer(String custId) {
		String status = "";
		String sql = "delete from Customer where custid='" + custId + "'";
		try {
			stmt = con.createStatement();
			int i = stmt.executeUpdate(sql);
			if (i != 0) {
				status = "Customer details deleted";
			} else {
				status = "Customer details not deleted";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public void menuDisplay() {
		String custId = "", custName = "", custAddress = "", custContact = "";
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			int ch = 0;
			while (true) {
				System.out.println("=== Customer Management System ======= \n"
						+ "1. Add Customer \n "
						+ "2. Edit Customer details \n "
						+ "3. Delete Customer \n "
						+ "4. Display Customer's record \n " + "5. Exit \n"
						+ "Enter Choice \n");
				String str1 = br.readLine().toString();
				ch = Integer.parseInt(str1);
				switch (ch) {
				case 1: {
					// Customer Id can be left blank
					do {
						System.out
								.println("Enter Customer Id [ It can not be left blank ]");
						custId = br.readLine();
					} while (custId.trim().length() == 0);

					// Customer name can be left blank
					do {
						System.out.println("Enter Customer Name");
						custName = br.readLine();
					} while (custName.trim().length() == 0);

					System.out.println("Enter  Customer Address or Enter ]");
					custAddress = br.readLine();
					System.out.println("Enter Customer Contact No. or Enter ]");
					custContact = br.readLine();
					System.out.println(addCustomer(custId, custName,
							custAddress, custContact));
					break;
				}
				case 2: {
					System.out.println("Customer address and contact no.");
					do {
						System.out.println("Enter Customer Id");
						custId = br.readLine();
					} while (custId.trim().length() == 0);

					System.out.println("Enter New Address or Enter ]");
					custAddress = br.readLine();
					System.out.println("Enter New Contact No. or Enter ]");
					custContact = br.readLine();
					System.out.println(editCustomer(custId, custAddress,
							custContact));
					break;
				}
				case 3: {
					do {
						System.out.println("Enter Customer Id to delete");
						custId = br.readLine();
					} while (custId.trim().length() == 0);
					System.out.println(deleteCustomer(custId));
					break;
				}
				case 4: {
					System.out.println("Enter Customer Id or Enter]");
					custId = br.readLine();
					searchCustomer(custId);
					break;
				}
				case 5: {
					System.exit(0);
				}
				default:
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		StatementDemo1 obj = new StatementDemo1();
		obj.menuDisplay();

	}
}
