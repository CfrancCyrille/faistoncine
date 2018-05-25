/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author DeeGree
 */
@Entity
public class Actor implements Serializable {

    @Id
    long idActor;
    String actorName; 
    String actorSurname;
    int actorAge; 
    String actorCountry; 

    public Actor() {
    }
    
     public long getIdActor() {
        return idActor;
    }

    public void setIdActor(long idActor) {
        this.idActor = idActor;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getActorSurname() {
        return actorSurname;
    }

    public void setActorSurname(String actorSurname) {
        this.actorSurname = actorSurname;
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
