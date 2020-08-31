//package dao;
//
//import model.User;
//
//public interface UserDaoInterface {
//	int signUp(User user) throws Exception;
//	boolean loginUser(User user) throws Exception;
//}

package dao;


import java.sql.SQLException;

import model.User;

public interface UserDaoInterface{
	
	public int signUp(User user) throws ClassNotFoundException, SQLException, Exception;
	public boolean loginUser(User user) throws ClassNotFoundException, SQLException, Exception;
}