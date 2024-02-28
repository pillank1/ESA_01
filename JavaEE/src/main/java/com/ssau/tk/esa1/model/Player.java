package com.ssau.tk.esa1.model;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "_player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private LocalDate birthdate;

    private Integer quantityGames;


    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Hero> heroes = new HashSet<>();


    public Player() {
    }

    public Player(String firstName, String lastName, LocalDate birthdate, Integer quantityGames) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.quantityGames = quantityGames;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Integer getQuantityGames() {
        return quantityGames;
    }

    public void setQuantityGames(Integer quantityGames) {
        this.quantityGames = quantityGames;
    }

    public Set<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(Set<Hero> heroes) {
        this.heroes = heroes;
    }
}
