package org.launchcode.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    // Fields
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String name;

    @OneToMany
    @JoinColumn(name = "category_id")
    private List<Cheese> cheeses = new ArrayList<>();

    public int getId() {
        return id;
    }

    // Constructors
    public Category(){

    }

    public Category(String name) {
        this.name = name;
    }

    // Getter and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

