package myapp.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class PersonaForm {
    private Long id;
    
    @NotEmpty
    private String lastname;
    
    @NotEmpty
    private String firstname;
    
    @NotBlank
    private String personality;

    @NotEmpty
    private String gender;
    
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPersonality() {
		return personality;
	}

	public void setPersonality(String personality) {
		this.personality = personality;
	}
}
