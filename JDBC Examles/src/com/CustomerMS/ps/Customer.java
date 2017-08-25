package com.CustomerMS.ps;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

import com.Util.JdbcConnection;

public class Customer {

	Connection con = JdbcConnection.getConnection();
	// PreparedStatement ps=con.prepareStatement();
	java.sql.PreparedStatement ps;

	public String addCustomer(String custid, String name, String address,
			String contact) {
		String status = "";
		try {
			ps = con.prepareStatement("insert into Customer values(?,?,?,?)");
			ps.setString(1, custid);
			ps.setString(2, name);
			ps.setString(3, address);
			ps.setString(4, contact);
			int i = ps.executeUpdate();
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
		String status = "";
		try {
			ps = con.prepareStatement("update Customer set custaddress=?,custcontact=? where custid=?");
			ps.setString(1, address);
			ps.setString(2, contact);
			ps.setString(3, custid);
			int i = ps.executeUpdate();
			if (i != 0) {
				status = "Customer details updated successfully";
			} else {
				status = "Customer details not updated ";
			}
		} catch (Exception e) {
			e.printStackTrace();
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
			ps = con.prepareStatement(sql);
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				System.out.print(res.getString(1));
				System.out.print(res.getString(2));
				System.out.print(res.getString(3));
				System.out.println(res.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String deleteCustomer(String custId) {
		String status = "";
		try {
			ps = con.prepareStatement("delete from Customer where custid=?");
			ps.setString(1, custId);
			int i = ps.executeUpdate();
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
		try {
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    int ch = 0;
		    while (true) {
		        System.out.println("== Customer Management System ========= \n"
		                + "1. Add Customer \n "
		                + "2. Edit Customer details \n "
		                + "3. Delete Customer \n "
		                + "4. Display Customer's record \n "
		                + "5. Exit \n"
		                + "Enter Choice \n");
		        String str1 = br.readLine().toString();
		        ch = Integer.parseInt(str1);
		        switch (ch) {
		            case 1: {
		                System.out.println("Enter Customer Id");
		                String custId = br.readLine();
		                System.out.println("Enter Customer Name");
		                String custName = br.readLine();
		                System.out.println("Enter  Customer Address");
		                String custAddress = br.readLine();
		                System.out.println("Enter Customer Contact No.");
		                String custContact = br.readLine();
		                System.out.println(addCustomer(custId, custName, 
		           custAddress, custContact));

		                break;
		            }
		            case 2: {
		                System.out.println("Customer address and contact no and id");
		                System.out.println("Enter Customer Id");
		                String custId = br.readLine();
		                System.out.println("Enter New Address");
		                String custAddress = br.readLine();
		                System.out.println("Enter New Contact No.");
		                String custContact = br.readLine();
		                System.out.println(editCustomer(custId, custAddress,custContact));
		                break;
		            }
		            case 3: {
		                System.out.println("Enter Customer Id to delete from database");
		                String custId = br.readLine();
		                System.out.println(deleteCustomer(custId));
		                break;
		            }
		            case 4: {
		                System.out.println("Enter Customer Code to display record");
		                String custId = br.readLine();
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
		
		Customer c=new Customer();
		c.menuDisplay();
		
	}
}
