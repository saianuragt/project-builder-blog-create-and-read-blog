//package dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import model.User;
//import utility.ConnectionManager;
//
//public class UserDAO implements UserDaoInterface {
//
//	public int signUp(User user) throws Exception {
//		String INSERT_USERS_SQL = "INSERT INTO USERS(email, password)VALUES(?,?)";
//
//		int result = 0;
//		try
//		{
//			Connection connection = ConnectionManager.getConnection();
//			// Step 2:Create a statement using connection object
//			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
//			preparedStatement.setString(1,user.getEmail());
//			preparedStatement.setString(2,user.getPassword());
//			System.out.println(preparedStatement);
//			// Step 3: Execute the query or update query
//			result = preparedStatement.executeUpdate();
//		} catch (SQLException e) {
//			System.out.println(e);
//		}
//		return result;
//	}
//	
//	public boolean loginUser(User user) throws Exception {
//		boolean status = false;
//		try{
//			Connection connection = ConnectionManager.getConnection();
//		
//				// Step 2:Create a statement using connection object
//		PreparedStatement preparedStatement = connection.prepareStatement("select * from users where email = ? and password = ? ");
//		
//			preparedStatement.setString(1, user.getEmail());
//			preparedStatement.setString(2, user.getPassword());
//
//			System.out.println(preparedStatement);
//			ResultSet rs = preparedStatement.executeQuery();
//			status = rs.next();
//
//		} catch (SQLException e) {
//			// process sql exception
//			System.out.println(e);
//		}
//		return status;
//	}
//
//}

package dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utility.ConnectionManager;
import model.User;

public class UserDAO implements UserDaoInterface{

	@Override
	public int signUp(User user) throws ClassNotFoundException, SQLException, Exception{
		// TODO Auto-generated method stub
		String email = user.getEmail();
		String password = user.getPassword();
			
		String sql = "insert into project_week5_1(EMAIL,PASSWORD)VALUES(?,?)";
		
		
		PreparedStatement st = ConnectionManager.getConnection().prepareStatement(sql);
		
		st.setString(1, email);
		st.setString(2, password);
		
		int result;
		return result = st.executeUpdate();
		
	}
		
	

	@Override
	public boolean loginUser(User user)throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String email = user.getEmail();
		String password = user.getPassword();
		try {
	
		ConnectionManager con = new ConnectionManager();
		Statement st = con.getConnection().createStatement();
		
		ResultSet rs = st.executeQuery("SELECT * FROM project_week5_1");
		
		while(rs.next()) {
			if(email.equals(rs.getString("EMAIL")) && password.equals(rs.getString("PASSWORD"))) {
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