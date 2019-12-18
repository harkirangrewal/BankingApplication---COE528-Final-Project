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
This class' methods and constructor are called when the 
account level is of type Silver
The onlinepurchase method makes an online purchase using the requirements 
of a Silver level account. 
*/
public class Silver extends Account {

    public Silver(double balance) {
        super(balance);
    }
    
    public double onlinepurchase(double amount,double balance)
    {
        double payment = amount +20;
       if(payment <= balance)
       {
           //if the customer can afford to make this purchase
           balance = balance - payment;
           return balance;
       }

        else
        {
         //falls in here if the payment will cause the customer as negative balance;
            return balance; 
        } 
    }
    
}
