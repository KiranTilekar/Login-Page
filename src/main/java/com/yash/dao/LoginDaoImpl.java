package com.yash.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yash.model.Login;

public class LoginDaoImpl implements LoginDao{

	@Override
	public boolean authenticateUser(Login user) {
		
		String query = "SELECT * FROM login WHERE username=? AND password=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return true;
            } else {
                return false;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

	}

	@Override
	public void registerUser(Login user) {
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "INSERT INTO login(username,password) VALUES(?,?)";
		
		try (
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {

	            pstmt.setString(1, user.getUsername());
	            pstmt.setString(2, user.getPassword());
	            pstmt.executeUpdate();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
		
		}
	
	
	
	
	}
