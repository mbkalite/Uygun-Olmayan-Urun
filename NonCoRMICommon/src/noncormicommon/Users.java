/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noncormicommon;

import java.io.Serializable;

/**
 *
 * @author mkaplan
 */
public class Users implements Serializable{
    int UserId;
    String UserName, Password, UserRole;

        public Users() {
    }
    public Users(int UserId, String UserName, String Password, String UserRole) {
        this.UserId = UserId;
        this.UserName = UserName;
        this.Password = Password;
        this.UserRole = UserRole;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getUserRole() {
        return UserRole;
    }

    public void setUserRole(String UserRole) {
        this.UserRole = UserRole;
    }
    
    
}
