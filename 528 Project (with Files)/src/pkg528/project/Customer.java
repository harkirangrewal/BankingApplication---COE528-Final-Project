/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg528.project;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 *
 * @author hari
 */

/*Overview: Class is used to represent and perform operations for the customer 
and account class such as logging in, logging out, depositing money, withdrawing
money and completing online purchases, this class is also mutable
*/

/*Abstraction Function: AF(c) is an abstract customer B where B name is 
Customer.name, B password Customer.password, B role is B.role, B balance is 
Customer.balance and B account is Customer.account.
This class is implemented in the manager class through the use of an arraylist
to control the operations and keep track of the customers in the banking appliation. 
Hence, c is the number of customer objects in the ArrayList of customers
*/

/*Rep Invariant: RI(c) is true if the username, password and role are non-empty, 
 non-negative strings, the balance is a double and non-negative or non-zero, 
and the object a is of class type Account and not null.
All the instance variables are protected except for the object of class type Account
*/

public class Customer extends User{
    
    protected double balance;
   // public File customer;
    Account a = new Account(100);

    //REQUIRES: username and password be Strings that are not empty or null
    //MODIFIES: the input parameters do not change
    //EFFECTS: this method is a constructor, sets initial values of class 
    // class variables, according to input parameters given
    public Customer (String username, String password)
    {
        this.username = username;
        this.password = password;
        this.balance = 100;
        //each time a new customer is created, a file with all its info should be made too
        //this.MakeFile(username, password, balance);   

    }
    
    //REQUIRES: n/a
    //MODIFIES: n/a
    //EFFECTS: checks the role from the constructor, if it is customer, returns true 
    // if is not valid for a user, returns false
      public boolean login()
    {
        if(this.role.equals("customer"))
     {
         return true;
     }
     else
     {
         return false;
     }
    }
      
      
    //REQURIES: N/A
    //MODIFIES: N/A
    //EFFECTS: When called, sets all the instance variable strings to empty 
    // and sets the balance to zero  
      public void logout()
    {
        this.username = "";
        this.password = "";
        this.role = "";
        this.balance =0;
    }
    
    //REQUIRES: a double representing the amount to deposit, that is non-negative
    //MODIFIES: The input is used to perform operations and modify other values
      //but is not modified itself
      //EFFECTS: this method takes the amount to deposit, adds it to the class's 
      //balance, then adds it to the account object's balance, and updates the
      // balance in the account class, updates the level (according to the new balance)
   public void depositbalance(double amount) throws IOException
   {
       System.out.println("In deposit balance");
       this.balance += amount;
       double a_balance = a.getBalance();
       a_balance += amount;
       a.setBalance(a_balance);
       a.UpdateLevel(a_balance);
       
       //Balance is updated in the file
       File file = new File("./Customers\\" + username + ".txt");
       Path path = file.toPath();
       ArrayList<String> newLines = new ArrayList<>();
            for(String line : Files.readAllLines(path)){
                if(line.contains("Balance: "))
                    newLines.add(line.replace("Balance: " + amount, "Balance: " + a_balance));
                else
                    newLines.add(line);
            }
            Files.write((path), newLines);      
       System.out.println("Updated all balances");
   }
   
   
   //REQUIRES: a double representing the amount to withdraw, that is non-negative
   //MODIFIES: The input is used to perform operations and modify other values, 
   // but is not modified itself
   //EFFECTS: this method first checks to see if the amount to withdraw is less 
   //than the balance, and then goes on to subtracting the amount from the customer 
   // class' balance, the account object's balance, sets the balance of the account
   // object, and updates the level of the account object, according to the new balance 
   public void withdrawbalance(double amount) throws IOException
   {
       if(this.balance < amount)
       {
           System.out.println("Error, there is not enough money in the account");
       }
       
       else
       {
           this.balance -= amount;
           double a_balance2= a.getBalance();
           a_balance2 -= amount;
           a.setBalance(a_balance2);
           a.UpdateLevel(a_balance2);
           
           File file = new File("./Customers\\" + username + ".txt");
          Path path = file.toPath();
           //Balance is again updated in the files
            ArrayList<String> newLines = new ArrayList<>();
            for(String line : Files.readAllLines(path)){
                if(line.contains("Balance: "))
                    newLines.add(line.replace("Balance: " + amount, "Balance: " + a_balance2));
                else
                    newLines.add(line);
            }
            Files.write((path), newLines);
           
       }
       
      
   }
   
   //REQUIRES: n/a
   //MODIFIES: n/a
   //EFFECTS: when called, this method returns the class's balance
   public double getbalance()
   {
       return this.balance;
   } 
    
    //REQUIRES: a double representing the amount to make the online purchase for, 
   // that is a non-negative amount
   //MODIFIES: the amount input is used to change various instance variables of
   // of the classes, but does not itself change in value
   //EFFECTS: the method first performs the following check: if the amount to 
   // make the online purchase is less than $50, return back to the user. Otherwise,
   // the onlinepurchase method is called from the account object. This method 
   // returns a double (purchase) that is checked to see if the purchase was made 
   //successfully or not. If purchase is the same as the balance, this means that
   // the purchase was not completed sucessfully. Otherwise, the balances are updated 
   // with the purchase variable, the balance in the account object is set, the 
   // level of the account object is updated and true is returned to indicate thaat 
   // the purchase was completed sucessfully. If the purchase was unsucessful, the 
   // booelan value of false is returned by the method. 
   public boolean onlinepurchase(double amount)
   {
      if(amount < 50)
      {
          return false;
      }
      
        double purchase = a.onlinepurchase(amount);
       
        if(balance == purchase)
        {
            //this means that there was not enough money to make the purchase
            return false;
        }
        else
        {
            this.balance = purchase;
            a.setBalance(purchase);
            a.UpdateLevel(purchase);
            return true; 
        }  
   }
   
   //Implementing the abstraction function as follows:
    @Override
   public String toString()
   { 
       return username +" "+ password + " " + role + " "+ balance;
   }
   
   //Implementing the repok function as follows:
   public boolean repok()
   {
       if(username == null || username.isEmpty() || password == null || password.isEmpty() || role == null || role.isEmpty() || balance <=0 || a == null || !(a instanceof Account))
       {
          return false; 
       }
      return true;
   }
   
}
            //MIGHT NOT NEED THIS FUNCTION
        /*public void MakeFile(String username, String password, double balance)
    {
        //unless the balance is given, it should be $100
        File customer = new File("Customer" + username + ".txt");
        //now we have to fill the file with given parameters
        
        try
        {
            BufferedWriter out = new BufferedWriter(new FileWriter(customer));
            out.write(username);
            out.newLine();
            out.write(password);
            out.newLine();
            out.write(String.valueOf(balance+100));
            out.newLine();
            
            out.close(); 
        }
        
        catch (IOException ex)
        {
            System.out.print("Error creating a new customer account");
        }
        
    }*/
    
        

