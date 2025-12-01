package service;

import java.sql.SQLException;
import java.util.List;

import dao.UserDAO;
import entity.User;

public class UserService {			
	
	private UserDAO userDAO = new UserDAO();
	
	
	 public void createUser(User u) {
	        userDAO.insertUser(u);
	    }
	
	public void createUser(String name, String email) {
        User u = new User(name, email);
        userDAO.insertUser(u);
	}
	public User getProfile(int id) throws SQLException {
        return userDAO.getUserById(id);
	}
	public List<User> getUsers() {
		return userDAO.getAllUsers();
	}

	public void removeUser(int id) {
        userDAO.deleteUser(id);
	}

}
