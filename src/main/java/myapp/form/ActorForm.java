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


     public long getIdActor() {
        return id;
    }

    public void setIdActor(long idActor) {
        this.id = idActor;
    }

    public String getActorName() {
        return name;
    }

    public void setActorName(String actorName) {
        this.name = actorName;
    }

    public String getActorSurname() {
        return surname;
    }

    public void setActorSurname(String actorSurname) {
        this.surname = actorSurname;
    }

    public int getActorAge() {
        return actorAge;
    }

    public void setActorAge(int actorAge) {
        this.actorAge = actorAge;
    }

    public String getActorCountry() {
        return actorCountry;
    }

    public void setActorCountry(String actorCountry) {
        this.actorCountry = actorCountry;
    }
}
