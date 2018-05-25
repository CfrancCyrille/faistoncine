package myapp.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class ActorForm {

    private Long id;
    
    @NotEmpty
    private String name;
    
    @NotBlank
    private String surname;

  
    @NotBlank
    int actorAge; 
    
    @NotBlank
    String actorCountry; 


     public long getId() {
        return id;
    }

    public void setId(long idActor) {
        this.id = idActor;
    }

    public String getName() {
        return name;
    }

    public void setName(String actorName) {
        this.name = actorName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String actorSurname) {
        this.surname = actorSurname;
    }

    public int getAge() {
        return actorAge;
    }

    public void setAge(int actorAge) {
        this.actorAge = actorAge;
    }

    public String getCountry() {
        return actorCountry;
    }

    public void setCountry(String actorCountry) {
        this.actorCountry = actorCountry;
    }
}
