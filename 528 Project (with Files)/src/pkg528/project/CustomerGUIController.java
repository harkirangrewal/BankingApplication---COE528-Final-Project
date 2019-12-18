/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg528.project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hari
 */
public class CustomerGUIController implements Initializable {

    @FXML private TextField deposit_amount;
    @FXML private Button deposit;
    @FXML private TextField withdraw_amount;
    @FXML private Button withdraw;
    @FXML private TextField c_username;
    @FXML private Button checkbalance;
    @FXML private TextField amount_onlinepurchase;
    @FXML private Button onlinepurchase;
    @FXML private Label outlabel;
    @FXML private Button clogout;
    
 
    public void depositButtonPushed() throws IOException
    {
        //get the text from the textfield
        double deposit = Double.parseDouble(deposit_amount.getText());
        
        if(deposit ==0)
        {
            outlabel.setText("Error, you must input a value to deposit");
        }
       else
        {
        Manager m1 = new Manager("admin", "admin", "manager");
        Customer c2 = m1.getcurrentcustomer();
        
        c2.depositbalance(deposit);
        
        boolean update = m1.UpdateCustomer(c2);
        if(update == true)
        {
          outlabel.setText("Sucessful deposit");
        }
        else
        {
         outlabel.setText("Error, please try again");   
        }
        } 
    }
    
    public void withdrawButtonPushed() throws IOException
    {
        double withdraw = Double.parseDouble(withdraw_amount.getText());
        
        if(withdraw == 0)
        {
           outlabel.setText("Error, you must input a value to withdraw"); 
        }
        
        else
        {
            Manager m1 = new Manager("admin", "admin", "manager");
            Customer c3 = m1.getcurrentcustomer();
            c3.withdrawbalance(withdraw);
            
            boolean update = m1.UpdateCustomer(c3);
            
        if(update == true)
        {
          outlabel.setText("Sucessful withdraw");
        }
        else
        {
         outlabel.setText("Error, please try again");   
        } 
        }
    }
    
    public void checkbalanceButtonPushed()
    {
        //we simply output the balance to the label
            Manager m1 = new Manager("admin", "admin", "manager");
            Customer c4 = m1.getcurrentcustomer();
            double balance = c4.getbalance();
            outlabel.setText("The current balance is $"+ balance+ "  ."); 

    }
    
    public void onlinepurchaseButtonPushed()
    {
        double amount = Double.parseDouble(amount_onlinepurchase.getText());
        
        if(amount == 0)
        {
          outlabel.setText("Error, you must input a value for purchasing");   
        }
        else
        {
        Manager m1 = new Manager("admin", "admin", "manager");
        Customer c5 = m1.getcurrentcustomer();
        boolean result = c5.onlinepurchase(amount);
        boolean update = m1.UpdateCustomer(c5);
        
        if(result == true && update == true)
        {
            outlabel.setText("Sucess! Purchase complete"); 
        }
        else
        {
          outlabel.setText("Error in completing purchase");
        }
        
        }
            //check to see if its empty or not
            //create a manager object
            //get the currentcustomer
            //call the online purchase method of the customer        
    }
    
    public void clogoutButtonPushed(ActionEvent event) throws IOException
    {
       Parent bankappgui1 = FXMLLoader.load(getClass().getResource("BankAppGUI.fxml"));
       Scene maingui1 = new Scene(bankappgui1);
       Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(maingui1);
        window.show(); 
        System.out.println("Sucessful logout");

    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
