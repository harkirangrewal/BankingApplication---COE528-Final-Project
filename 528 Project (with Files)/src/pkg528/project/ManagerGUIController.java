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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hari
 */
public class ManagerGUIController implements Initializable {
    
    @FXML private TextField m_username;
    @FXML private PasswordField m_password;
    @FXML private Button addcustomer;
    @FXML private Button deletecustomer;
    @FXML private Button logoutbutton;
    @FXML private Label moutputlabel;
    
    public boolean CheckforInput(String username, String password)
    {

        //Check to see if there is something in the text field
        if(username != null && !username.isEmpty() && password != null && !password.isEmpty())
        {
            this.moutputlabel.setText("");
            return true;
        }
        else
        {
          this.moutputlabel.setText("Invalid Input, please try again");
          return false;  
        }  
    }
    
    public void addcustomerButtonPushed(ActionEvent event)
    {
        moutputlabel.setText("");
        String username = m_username.getText();
        String password = m_password.getText();
        
        boolean result = CheckforInput(username, password);
        
        if(result == true)
        {
            Customer c1 = new Customer(username, password);
            Manager m1 = new Manager("admin", "admin", "manager");
            boolean add = m1.AddCustomer(c1);
            //there is input in the username class
            //create a manager object 
            //add the customer to the arraylists
            if(add == true)
            {
              moutputlabel.setText("Sucessfully added a customer");
            }
            else if (add== false)
            {
               moutputlabel.setText("Error, customers cannot have the same username"); 
            }
          
        }
    }
    
    public void deletecustomerButtonPushed(ActionEvent event)
    {
        moutputlabel.setText("");
        String username = m_username.getText();
        String password = m_password.getText();
        
        boolean result = CheckforInput(username, password);
        
        //if there is input, the deletion is performed
        if(result == true)
        {
           Customer c2 = new Customer(username, password);
           Manager m2 = new Manager("admin", "admin", "manager");
           boolean delete = m2.DeleteCustomer(c2);
           
           if(delete == true)
           {
               this.moutputlabel.setText("Customer has been deleted");
           }
           else if (delete==false)
           {
               this.moutputlabel.setText("Error, this customer does not exist");
           }
           
            //create an instance of the manager class
            //call the deletecustomer method 
        }
    }
    
    public void logoutButtonPushed(ActionEvent event) throws IOException
    {
        //when the logout button is pushed, we go back to the main screen
        Parent bankappgui = FXMLLoader.load(getClass().getResource("BankAppGUI.fxml"));
        Scene maingui = new Scene(bankappgui);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(maingui);
        window.show(); 
        System.out.println("Sucessful logout");
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       moutputlabel.setText("");
        // TODO
    }    
    
}
