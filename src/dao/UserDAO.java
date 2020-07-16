package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import utility.ConnectionManager;
import model.User;

public class UserDAO implements UserDaoInterface{

	@Override
	public void signUp(User user) {
		// TODO Auto-generated method stub
		String email = user.getEmail();
		String password = user.getPassword();
		String date = (user.getDate().toString());
		
		ConnectionManager cm = new ConnectionManager();
		
		String sql = "insert into USERDATA(EMAIL_USER,PASSWORD_USER,DATE_USER)VALUES(?,?,?)";
		
		try {
		PreparedStatement st = cm.getConnection().prepareStatement(sql);
		
		st.setString(1, email);
		st.setString(2, password);
		st.setString(3, date);
		
		st.executeUpdate();
		cm.getConnection().close();
		
		}catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public boolean loginUser(User user) {
		// TODO Auto-generated method stub
		String email = user.getEmail();
		String password = user.getPassword();
		try {
	
		ConnectionManager con = new ConnectionManager();
		Statement st = con.getConnection().createStatement();
		
		ResultSet rs = st.executeQuery("SELECT * FROM USERDATA");
		
		while(rs.next()) {
			if(email.equals(rs.getString("EMAIL_USER")) && password.equals(rs.getString("PASSWORD_USER"))) {
				con.getConnection().close();
				return true;
			}

		}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
		
	
}