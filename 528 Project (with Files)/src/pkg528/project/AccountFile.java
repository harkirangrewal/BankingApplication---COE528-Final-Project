/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg528.project;

import java.io.*;
import java.nio.file.Path;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hari
 */
public class AccountFile {
    
    protected String username;
    protected String password;
    protected double balance;
    
    //Constructor when individual input parameters are passed
    //Is never used in the program but it still defined for the general case
        public AccountFile(String username, String password, double balance)
    {
         //we initialize values
        this.username = username;
        this.password = password;
        this.balance = balance;
    }
        
    //Initializes values of the object and creates a file for the respective customer
    public AccountFile (Customer c) 
    {
        this.username = c.username;
        this.password = c.password;
        this.balance = 100;
        try {
            boolean success = CreateFile(c);
        } catch (IOException ex) {
            Logger.getLogger(AccountFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //The method below is called in the constructor to create a file of each customer
    public boolean CreateFile(Customer a) throws IOException
   {
       File file = new File("./Customers\\" + a.username + ".txt");
        if(file.exists())
        {
            System.out.println("Error, this account file already exists");
            return false; 
        }
        
        else
        {
            file.getParentFile().mkdirs();
            file.createNewFile();
            
            FileWriter write = new FileWriter(file);
            write.write("Username: " + a.username + "\n" + "Password: " + a.password + "\n" + "Balance: " + this.balance); 
            write.flush();
            write.close();
            System.out.println("Sucess, a file has been made for the customer");
            return true;
        }
   }
  
    public boolean UpdateFile(String username, String password, double balance) throws IOException
    {
        File file = new File("./Customers\\" + username + ".txt");
        if(!file.exists())    
            return false;
        else
        {
            FileWriter write = new FileWriter(file);
            write.write("Username: " + username + "\n" + "Password: " + password + "\n" + "Balance: " + balance); 
            write.flush();
            write.close();   
            return true;
        }
    }
    
  
    public String getUsername()
    {
        return this.username;
    }
    
    public void SetUsername(String u)
    {
        this.username = u;
    }
    
    public String getPassword()
    {
        return this.password;
    }
    
    public void setPassword(String p)
    {
        this.password = p;
    }
    
    public double getBalance()
    {
        return this.balance;
    }
    
    public void setBalance(double b)
    {
        this.balance = b;
    }
   

    /*public void CreateAccount(String username, String password, String balance, double accountnum, String level)
    {
        //we create a file for the account
        File account = new File("Account" + accountnum + ".txt");
        //now we have to fill the file with the given parameters
        
       try
       {
          BufferedWriter out = new BufferedWriter(new FileWriter(account));
          out.write(username);
          out.newLine();
          out.write(password);
          out.newLine();
          out.write(balance);
          out.newLine();
          out.write(level);
          
         out.close();
       }
            
       catch (IOException ex)
       {
        System.out.println("Error creating the account file." );
       }
    }*/
    
   
 }
    
