/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg528.project;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author hari
 */
public class Manager extends User {
    
    private static ArrayList<Customer> customer = new ArrayList<>();
    static ArrayList<AccountFile> file = new ArrayList<>();
    protected static Customer currentcustomer =  new Customer("a", "b");
    //Create an ArrayList to store all of the customers and their respective files
    //Made as static final as each array value should be the same for all classes and will not change (final)
    
    public Manager(String username, String password, String role)
    {
     this.username = username;
     this.password = password;
     this.role = role;
    }
  
    
    /*The getcurrentcustomer() and setcurrentcustomer() methods are used in the 
    GUI system when wanting to save the customer's information during the 
    switch between the login() and actions GUI of the customer
    */
    public Customer getcurrentcustomer()
    {
        return currentcustomer;
    }
    
    public void setcurrentcustomer(Customer u)
    {
        currentcustomer = u;
    }
    
    //Check to see if the inputs are valid for a manager, and then perform the login of a manager
    public boolean login()
    {
     if(this.username.equals("admin") && this.password.equals("admin") && this.role.equals("manager"))
     {
         //The given inputs are valid for a manager
         return true;
     }
     else
     {
         return false;
     }

    }
    
     protected void logout()
     {
         this.username = "";
         this.password = "";
         this.role = "";
         System.out.println("Sucessful logout");
     }
     
     
     /*When adding a customer, a customer is added to the respective customer 
     arraylist, as well as the accountfile arraylist (which creates a new file with the customer's information)
     Once a customer has been sucessfully added into the system, a message is outputted 
     */
     public boolean AddCustomer(Customer a)
     {   
         if(customer.isEmpty())
         {
            // System.out.println("In if statement");
             customer.add(a);
             AccountFile f1 = new AccountFile(a);
             file.add(f1);
             System.out.println("Sucess! A customer has been added");
             return true;
         }
         
         //Search for the customers first
         /*for(int i=0; i < customer.size(); i++)
         {
             if(!(a.username.equals(customer.get(i).username)))
             {
                 //if the customer does not exist in the array, we add them to the array
                 customer.add(a);
                 AccountFile f1 = new AccountFile(a);
                 file.add(f1);
                 System.out.println("Sucess! A customer has been added");
             }   
         }*/
         
          for(int i=0; i < customer.size(); i++)
         {
             if((a.username.equals(customer.get(i).username)))
             {
                 //if the customer exists in the array, error
                 System.out.println("A Customer cannot be added");
                 return false;
             } 
             else
             {
                 customer.add(a);
                 AccountFile f1 = new AccountFile(a);
                 file.add(f1);
                 System.out.println("Sucess! A customer has been added");
                 return true;
             }
                  
         }
          
          return false;
     }
     
     public boolean DeleteCustomer(Customer b)
     {
         for(int j=0; j<customer.size(); j++)
         {
             System.out.println("In for loop");
             if(b.username.equals(customer.get(j).username))
             {
                 System.out.println("In if statement");
                 //if the customer exists in the arraylist, you have to remove it
                 customer.remove(b);
                 AccountFile f2 = new AccountFile(b);
                 file.remove(f2);
                 System.out.println("The customer has been deleted");
                 return true;
             }
             
             else
             {
                 //if customer does not exist in the arraylist 
                 return false;
             }
         }
         
         return false;
     }
     
    public boolean UpdateCustomer(Customer h)
    {
        AccountFile f2 = new AccountFile(h);
        for(int i=0; i<customer.size(); i++)
        {
             if(h.username.equals(customer.get(i).username))
             {
                customer.set(i,h);
                file.set(i, f2);
                 return true;
             }
         } 
        
        return false;
    }
     
     public boolean SearchCustomer(Customer c)
     {
         //System.out.println("In search method");
         if(customer.isEmpty())
         {
            System.out.println("Customer arraylist is empty");
         }
         for(int i=0; i<customer.size(); i++)
         {
             //System.out.print("In for loop");
             if(c.username.equals(customer.get(i).username))
             {
                System.out.println("In if statement, return true");
                 //if the customer exists
                 return true;
             }
         }
         
         //if the loop runs through and the if statement does not fall into, return false
         System.out.print("Return false");
         return false;
     }
     
     /*
     public boolean CheckCustomer(String username, String password, double balance)
     {
         Customer c1 = new Customer(username, password);
         boolean ans = c.contains(c1);
         
         if(ans == true)
         {
             return true;
         }
         
         else
         {
             return false;
         }
     }
     */

     
     
    
    
}
