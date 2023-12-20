package com.mvc.example;

public class Contact {
    private long id;
    private String first_name;
    private String last_name;

    public Contact(long id, String first_name, String last_name) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
    }
    
    public long getId() {
        return id;
    }
    
    public String getFirstName() {
    	return first_name;
    }
    
    public String getLastName() {
    	return last_name;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }


}

