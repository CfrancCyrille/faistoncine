package myapp.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class ScenarioForm {

    private Long id;
    
    @NotEmpty
    private String name;
    
    @NotBlank
    private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
