package myapp.form;

public class UserForm {

	private Long id;
	private String firstname;
	private String lastname;
	private String username;
	private String password;

	public Long getId() {
		return id;
	}

	public UserForm setId(Long id) {
		this.id = id;
		return this;
	}

	public String getFirstname() {
		return firstname;
	}

	public UserForm setFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public String getLastname() {
		return lastname;
	}

	public UserForm setLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	public String getUsername() {
		return username;
	}

	public UserForm setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public UserForm setPassword(String password) {
		this.password = password;
		return this;
	}
}
