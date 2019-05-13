package application;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdateController {

	private String option = "";
	
	//dec for books
	@FXML private TextField txtKey;
	@FXML private TextField txtAuthor;
	@FXML private TextField txtTitle;
	@FXML private TextField txtPrice;
	@FXML private TextField txtType;
	@FXML private TextField txtSubject;
	@FXML private Label errMain;
	
	@FXML private Label lblUpdate;
	
	//declartion fro Sales
	
	@FXML private TextField stxtPrice;
	@FXML private TextField txtQty;
	
	@FXML private DatePicker date;
	
	@FXML private Label lblResponce;
	@FXML private Label errDate;
	
	
    @FXML
	private void UpdateBook() {
		//database connection
	 Connection conn = null;
     Statement stmt = null;
	 ResultSet rs = null;
     PreparedStatement psmt = null;
		
		//taking fx inputs in to variables
		int key = 0;
		String author ="" ;
		String title= "" ;
		double price = 0;
		String type= "" ;	
		String subject = "";
		
		//validating the key
				if(txtKey.getText().equals(""))
					errMain.setText("Key must have a value");
				else
					key = Integer.parseInt(txtKey.getText()) ;
		
		//assign values to variables if the field is empity the database will be cleared 
		
		if(txtPrice.getText().equals("") || txtAuthor.getText().equals("") || txtTitle.getText().equals("")  || txtType.getText().equals("")  || txtSubject.getText().equals("")    ) {}
		else {
			price = Double.parseDouble(txtPrice.getText()); 
			author = txtAuthor.getText();
			title = txtTitle.getText();
			type = txtType.getText();	
			subject = txtSubject.getText();
		} 
		
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String connectionUrl = "jdbc:mysql://localhost:3306/centennial_bookstore_db";
			String connectionUser = "root";			
			String connectionPassword = "password";
				
			conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			
			psmt = conn.prepareStatement("UPDATE books SET TITLE=? , AUTHOR=?  , PRICE=?  , TYPE=?  , SUBJECT=?   where BOOKCODE=?");
			
	        
	        psmt.setString(1, title);
	        psmt.setString(2, author);
	        psmt.setDouble(3, price);
	        psmt.setString(4, type);
	        psmt.setString(5, subject);
	        psmt.setInt(6, key);
	        
	        int row= psmt.executeUpdate();
			
	        lblUpdate.setText(row + " row updated");
			
			
			
		}
		catch (Exception exe) {
			   exe.printStackTrace();
			   System.out.println(exe.toString());
		     }
		
		
		
		
	}//end method
    
    public void UpdateSales() {
    	 Connection conn = null;
         Statement stmt = null;
    	 ResultSet rs = null;
         PreparedStatement psmt = null;
         
         //dclartion
         double price = 0;
         int qty = 0;
         String sdate = "";
         
         LocalDate dt = date.getValue();
         
         sdate = dt.toString();
         
         System.out.println(sdate);
       
         
    }
	
	
	
}//end class
