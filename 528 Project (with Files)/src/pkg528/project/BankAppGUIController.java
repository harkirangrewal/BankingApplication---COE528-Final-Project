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
 *
 * @author hari
 */
public class BankAppGUIController implements Initializable {
    
    @FXML private TextField usernametext;
    @FXML private PasswordField passwordtext;
    @FXML private TextField roletext;
    @FXML private Button loginmanager;
    @FXML private Button logincustomer;
    @FXML private Label outputlabel;
    //Need @FXML tag, private, type and name
    //only import java fx classes
    
    //Returns true if all textfields have a value, returns false otherwise
   
    //Method is passed three string as an input, and checks to see if the strings are empty or not
    public boolean CheckforInput(String s1, String s2, String s3)
    {
        if(s1 != null && !s1.isEmpty() && s2 != null && !s2.isEmpty() && s3!= null && !s3.isEmpty())
        {
            this.outputlabel.setText("");
            return true;
        }
        
        else
        {
            this.outputlabel.setText("Invalid input, please try again");
            return false;
        }  
        
    }
    
    
    public void loginmanagerButtonPushed(ActionEvent event) throws IOException 
    {
        //Setting up for changing to the manager window
        Parent managergui = FXMLLoader.load(getClass().getResource("ManagerGUI.fxml"));
        Scene managerscene = new Scene(managergui);
        //Getting the stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        //Getting the inputs from the user
        String username = usernametext.getText();
        String password = passwordtext.getText();
        String role = roletext.getText();
        role = role.toLowerCase();
        
        
        //Checking to make sure the textfields all have values
        boolean input = CheckforInput(username, password, role);
        
        if(input == true)
        {
            //if the textfields are valid, a manager object is created
            Manager m1 = new Manager(username, password, role);
            //the login function is called to check if the paramaters are appropriate for a login
            boolean loginsucess = m1.login();
            if(loginsucess == true)
            {
               System.out.println("Sucessful login");
                window.setScene(managerscene);
                window.show(); 
            }
            
            else
            {
              this.outputlabel.setText("Invalid, you are not a manager");
            }
        }
    }

    public void logincustomerButtonPushed(ActionEvent event) throws IOException
    {
        System.out.println("In customer button method");
        //In the interface, we will be looking through the list of files (Accessible in manager class)
        //To search and see if there exists a customer with the crentials given
        //Before searching through the files, we must check to see if the appropirate role is given to login
         //Setting up for changing to the customer gui
        Parent customergui = FXMLLoader.load(getClass().getResource("CustomerGUI.fxml"));
        Scene customerscene = new Scene(customergui);
        //getting the stage info
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        String username = usernametext.getText();
        String password = passwordtext.getText();
        String role = roletext.getText();
        role = role.toLowerCase();
        
        boolean input = CheckforInput(username, password, role);
       
        if(input == true)
        {
            
            //first check that the appropirate role is given
            if(role.equals("customer"))
            {  
                System.out.println("Role checked.");
                Manager m1 = new Manager("admin", "admin", "manager");
                System.out.println("Manager made");
                Customer c1 = new Customer(username, password);
                System.out.println("Customer made");
                
                boolean result = m1.SearchCustomer(c1);
                if(result == true)
                {
                    System.out.print("Search is true");
                    //if the customer exists in the application
                    m1.setcurrentcustomer(c1);
                    System.out.println("Sucessful login");
                    window.setScene(customerscene);
                    window.show();
                }
             }
             else
              {
                 this.outputlabel.setText("Invalid, you are not a customer");
                
              }
        }
    }
    
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        outputlabel.setText("");
        // TODO
    }    
    
}
