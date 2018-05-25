/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author DeeGree
 */
@Entity
public class Actor implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    long id;
    String name;
    String surname;
    int age;
    String actorCountry;

    public Actor() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getActorCountry() {
        return actorCountry;
    }

    public void setActorCountry(String actorCountry) {
        this.actorCountry = actorCountry;
    }

}
