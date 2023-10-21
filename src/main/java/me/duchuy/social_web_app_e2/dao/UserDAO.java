package me.duchuy.social_web_app_e2.dao;

import me.duchuy.social_web_app_e2.models.User;

/**
 *
 * @author ADMIN
 */
public interface UserDAO {
    
    public String add(User user);
    
    public boolean isDuplicatedUser(String uEmail);
    
    public String isValidUser(String uEmail, String uPassword);
    
}
