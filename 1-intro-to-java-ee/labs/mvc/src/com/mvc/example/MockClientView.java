package com.mvc.example;

public class MockClientView {
	
	private Controller contactController;
	
	public static void main(String[] args) {
		
		MockClientView mockClient = new MockClientView();
		
		mockClient.contactController = new Controller();
		
		mockClient.AddAContact("101", "Sam", "Lim");
		mockClient.AddAContact("102", "James", "Teo");
		
		mockClient.displayFirstLast("101");
		mockClient.displayFirstLast("102");
		
	}
	
	void displayFirstLast(String id) {
		String myContact = contactController.findAContact(id);
		System.out.println(myContact);
	}
	
	void AddAContact(String id, String first_name, String last_name) {
		contactController.AddAContact(id, first_name, last_name);
	}
	
	

}
