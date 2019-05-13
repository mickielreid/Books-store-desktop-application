package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import javafx.scene.Node;

public class InitController implements Initializable{

	@FXML private ComboBox chOption;
	
	@FXML private RadioButton rdBooks;
	@FXML private RadioButton rdSales;
	
	public void ReRoute(ActionEvent e) throws IOException{
		
		String option = chOption.getValue().toString();
		String datbase = "" ;
		
		if(rdBooks.isSelected())
			datbase = "books";
		if(rdSales.isSelected())
			datbase = "sales" ;
		
		
		
		if(datbase.equals("books")) {
			switch(option) {
			
				case "View Record":
					
					break;
				case "Update Record":
	
					  Parent tableViewParent = FXMLLoader.load(getClass().getResource("UpdateBook.fxml"));
					  
				        Scene tableViewScene = new Scene(tableViewParent);
				        
				        //This line gets the Stage information
				        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
				        window.setTitle("Centennial college Update Book Database");
				        
				        window.setScene(tableViewScene);
				        window.show();
					break;
					
			
		    }//end switch
			
		}else {
			switch(option) {
			
			case "View Record":
				
				break;
			case "Update Record":
				Parent tableViewParent = FXMLLoader.load(getClass().getResource("UpdateSale.fxml"));
				  
		        Scene tableViewScene = new Scene(tableViewParent);
		        
		        //This line gets the Stage information
		        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		        window.setTitle("Centennial college Update Sales Database");
		        
		        window.setScene(tableViewScene);
		        window.show();
				break;
			}
			
			
		}
		
		
		
	}//end method
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		chOption.getItems().setAll("View Record","Update Record" ,"Delete Record", " Add Record", " Search for record" , " Calculate-SalesDate");
		chOption.setVisibleRowCount(5);
		chOption.setValue("View Record");
	}
	
	
	

}
