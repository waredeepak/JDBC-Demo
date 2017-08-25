package com.StoreImage;
import java.io.FileInputStream;
import java.sql.*;

import com.Util.JdbcConnection;

public class ImageStoreDataBase {
	public static void main(String[] args) {

		try {
			Connection con = JdbcConnection.getConnection();

			PreparedStatement ps = con
					.prepareStatement("insert into image values(?,?)");
			ps.setString(1, "sonoo");

			FileInputStream fin = new FileInputStream("d:\\deepak.jpg");
			ps.setBinaryStream(2, fin, fin.available());
			int i = ps.executeUpdate();
			System.out.println(i + " records affected");

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}