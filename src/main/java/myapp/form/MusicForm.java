package myapp.form;

import javax.validation.constraints.NotEmpty;

public class MusicForm {
	
	private Long id;
	
	@NotEmpty
	private String title;
	
	@NotEmpty
	private String author;
	
	@NotEmpty
	private String interpreter;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getInterpreter() {
		return interpreter;
	}

	public void setInterpreter(String interpreter) {
		this.interpreter = interpreter;
	}
	
	
}
