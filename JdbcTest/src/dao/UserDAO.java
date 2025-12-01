package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import db.DBConnection;
import entity.User;

public class UserDAO {
		
	/*
	public void save(User user) throws SQLException {
        String sql = "INSERT INTO users(name, email) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.executeUpdate();
            
        }
    }
	// guarda le varie operazioni integrando delete, find all( senza where) , insert per entità user 
    public User findById(int id) throws SQLException {
        String sql = "SELECT * FROM users WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setEmail(rs.getString("email"));
                return u;
            }
            return null;
        }
    }
	*/
	private Connection conn;		//classe che contiene operazioni sul database su entità user
	public UserDAO() {
		conn= DBConnection.getInstance().getConnection();
	}
	
	// ----------- CREATE -----------------
	public void insertUser(User user) {
		String sql = "INSERT INTO user(name, email) VALUES (?,?)";
		try (PreparedStatement stmt= conn.prepareStatement(sql)) {
			stmt.setString(1,  user.getName());
			stmt.setString(2, user.getEmail());
			stmt.executeUpdate();
			System.out.println("User inserito");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
															// ----------- READ by ID -------------
	public User getUserById( int id) {
		String sql = "SELECT * FROM user WHERE id= ?";
		User user= null;
		try(PreparedStatement stmt= conn.prepareStatement(sql)){
			stmt.setInt(1, id);
			ResultSet rs= stmt.executeQuery();
			if(rs.next()) {
				user = new User(
					rs.getInt("id"),
					rs.getString("name"),
					rs.getString("email")
				);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
															// ----------- CREATE -------------
	 public List<User> getAllUsers() {
	        String sql = "SELECT * FROM User";
	        List<User> users = new ArrayList<>();

	        try (Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery(sql)) {

	            while (rs.next()) {
	                User user = new User(
	                        rs.getInt("id"),
	                        rs.getString("name"),
	                        rs.getString("email")
	                );
	                users.add(user);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		return users;
	}
	 														// ----------- UPDATE -------------	
	public boolean updateUser(User user) {
		String sql = "UPDATE user SET name=?, email=? ";
		try (PreparedStatement stmt= conn.prepareStatement(sql)){
				stmt.setString(1, user.getName());
				stmt.setString(2, user.getEmail());
				stmt.setInt(3, user.getId());
	            return stmt.executeUpdate() > 0;
	            
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
															// ----------- DELETE -------------	
	public void deleteUser(int id) {
		String sql ="DELETE FROM user WHERE id=?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		    System.out.println("user eliminato");

		} catch (SQLException e) { e.printStackTrace(); }
	}
}
