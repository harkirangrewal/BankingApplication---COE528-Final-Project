/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg528.project;

import java.util.ArrayList;

/**
 *
 * @author hari
 */
public abstract class User {
     
    protected String username;
    protected String password;
    protected String role;
    static ArrayList<AccountFile> file = new ArrayList<>();
    
    
    public abstract boolean login();
    //Class will output to the user if the login was sucessful or not
    
    protected abstract void logout();
    //Class will output to the user if the logout was sucessful or not
    
}
