package me.duchuy.social_web_app_e2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.duchuy.social_web_app_e2.models.User;
import me.duchuy.social_web_app_e2.utils.DBUtil;

/**
 *
 * @author ADMIN
 */
public class UserDAOImpl implements UserDAO{

    @Override
    public String add(User user) {
        String status = "Sorry, the email is already associated with an account.";
        
        boolean isDuplicated = isDuplicatedUser(user.getEmail());
        
        if (isDuplicated) {
            return status;
        }
        
        String query = "INSERT INTO users (uId, username, uEmail, uPassword) VALUES (?,?,?,?)";
        
        try (Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, user.getId());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            int result = ps.executeUpdate();
            if (result > 0) {
                status = "Registration Successful!";
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
    }
    
    @Override
    public boolean isDuplicatedUser(String uEmail) {
        String query = "SELECT * FROM users WHERE uEmail = ?";
        
        try (Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, uEmail);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public String isValidUser(String uEmail, String uPassword) {
        
        String uId = null;
        
        String query = "SELECT * FROM users WHERE uEmail = ? and uPassword = ?";
        
        try (Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, uEmail);
            ps.setString(2, uPassword);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                uId = rs.getString("uId");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return uId;
    }

    
    
}
