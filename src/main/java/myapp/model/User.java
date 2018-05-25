package myapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    
    
    public User() {
		// TODO Auto-generated constructor stub
	}
    
    public Long getId() {
		return id;
	}
    
    public void setId(Long id) {
		this.id = id;
	}
    
    public String getFirstname() {
		return firstname;
	}
    
    public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
    
    public String getLastname() {
		return lastname;
	}
    
    public void setLastname(String lastname) {
		this.lastname = lastname;
	}
    
    public String getUsername() {
		return username;
	}
    
    public void setUsername(String username) {
		this.username = username;
	}
    
    public String getPassword() {
		return password;
	}
    
    public void setPassword(String password) {
		this.password = password;
	}
    
   
}
