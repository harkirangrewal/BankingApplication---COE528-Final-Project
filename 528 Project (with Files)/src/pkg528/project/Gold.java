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
account level is of type Gold.
The onlinepurchase method makes an online purchase using the requirements 
of a Gold level account. 
*/
public class Gold extends Account {
    
        public Gold(double balance) {
        super(balance);
    }
        
    public double onlinepurchase(double amount, double balance)
    {
        double payment = amount + 10;
        if(payment <= balance)
        {
            //if the customer can afford to make the purchase 
            balance = balance-payment;
            return balance;
        }
        
        else
        {
            //if the customer cannot afford to make the purchase
            return balance;
        }
    }
    
}
