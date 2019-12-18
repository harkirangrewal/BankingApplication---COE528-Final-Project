/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg528.project;

/**
 *
 * @author hari
 */
public class Account {
    
    protected double balance;
    protected String level;
    
    
    /*This class is a parent of the three level classes (Silver, Gold and Platinum)
    It provides methods for the child classes such as getters and setters, along with 
    an onlinepurchase method which is called from the parent when there is no definition 
    of the method in a child class or class object (the default definition is in this parent class
    */

    Account(double balance) {
        this.balance = balance; 
        if(this.balance < 10000)
        {
            this.level = "silver";
        }
        else if (this.balance >= 10000 && this.balance <20000)
        {
            this.level = "gold";
        }
        else if(this.balance >= 20000)
        {
            this.level = "platinum";
        }
    }
    
    public double getBalance()
    {
        return this.balance;
    }
    
    public void setBalance(double b)
    {
        this.balance = this.balance +b;
    }
    
    public String getlevel()
    {
        return this.level;
    }
    
    public void setlevel(String l)
    { 
        this.level = l;
    }
    
    public void UpdateLevel(double balance)
    {
        this.balance = balance; 
         if(this.balance < 10000)
        {
            this.level = "silver";
        }
        else if (this.balance >= 10000 && this.balance <20000)
        {
            this.level = "gold";
        }
        else if(this.balance >= 20000)
        {
            this.level = "platinum";
        }   
    }
    public double onlinepurchase(double amount)
    {
        double purchase;
        if("silver".equals(this.level))
        {
           //create an object of type silver
            //call the online purchase method of the silver object
            Silver s1 = new Silver(this.balance);
            purchase = s1.onlinepurchase(amount, balance);
            if(balance==purchase)
            {
                //the else statement of the onlinepurchase method ran
                System.out.println("There is not enough money to make this purchase");
            }
            this.balance = purchase;
            
        }
        else if("gold".equals(this.level))
        {
            //create an object of type gold 
            //call the online purchase method of the gold object
            Gold g1 = new Gold(this.balance);
            purchase = g1.onlinepurchase(amount, balance);
            if(balance == purchase)
            {
                //the else statement of the onlinepurchase method ran
                System.out.println("There is not enough moeny to make this purchase");
            }
            this.balance = purchase;
        }
        else if("platinum".equals(this.level))
        {
            //create an object of type platinum
            //call the online purchase method of the gold object
            Platinum p1 = new Platinum(this.balance);
            purchase = p1.onlinepurchase(amount, balance);
            if(balance == purchase)
            {
                System.out.println("There is not enough moeny to make this purchase");
            }
          this.balance = purchase;
        }

        return this.balance;                
    }
}
