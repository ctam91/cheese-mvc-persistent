package org.launchcode.models;

import org.launchcode.models.data.CheeseDao;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Menu {
    // Fields
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String name;

    @ManyToMany
    private List<Cheese> cheeses = new ArrayList<>();

    // Constructor

    public Menu() {
    }

    public Menu(String name) {
        this.name = name;
    }

    // Getter and Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cheese> getCheeses() {
        return cheeses;
    }

    public void addItem(Cheese item){
        cheeses.add(item);
    }

    public void deleteCheese(int cheeseId){
        cheeses.remove(cheeseId);
    }


}
