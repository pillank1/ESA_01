package com.ssau.tk.esa1.model;

import jakarta.persistence.*;

@Entity
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameHero;

    private Integer level;

    private String classHero;

    private Integer spellCells;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    public Hero() {
    }

    public Hero(String nameHero, Integer level, String classHero, Integer spellCells) {
        this.nameHero = nameHero;
        this.level = level;
        this.classHero = classHero;
        this.spellCells = spellCells;
    }

    public Hero(String nameHero, Integer level, String classHero, Integer spellCells, Player player) {
        this.nameHero = nameHero;
        this.level = level;
        this.classHero = classHero;
        this.spellCells = spellCells;
        this.player = player;
    }

    public Long getId() {
        return id;
    }

    public String getNameHero() {
        return nameHero;
    }

    public void setNameHero(String nameHero) {
        this.nameHero = nameHero;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getClassHero() {
        return classHero;
    }

    public void setClassHero(String classHero) {
        this.classHero = classHero;
    }

    public Integer getSpellCells() {
        return spellCells;
    }

    public void setSpellCells(Integer spellCells) {
        this.spellCells = spellCells;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
