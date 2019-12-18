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

/*This class is a child of the Account class.
It is used when the account is of the platinum level.
The onlinepurchase method performs a purchase using the attributes of a 
platinum account.
*/
public class Platinum extends Account {
    
    public Platinum(double balance)
    {
        super(balance);
    }

    
    public double onlinepurchase(double amount, double balance)
    {
       if(amount <= balance)
       {
           //if the customer can afford to make this purchase
           balance = balance - amount;
           return balance;
       }

        else
        {
         //falls in here if the payment will cause the customer as negative balance;
            return balance; 
        } 
    }
}
