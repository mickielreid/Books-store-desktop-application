package application;

public class AddRecordController {
	private String option =" ";
	
	
	public AddRecordController(String option) {
		this.option = option;
		
		if(option.equals("books") ) 
			BooksScence();
		else
			SalesScene();
			
		
	}
	
	private void BooksScence() {
		
		
	}

	private void SalesScene() {
	
		
	}

	
}
