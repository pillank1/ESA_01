package com.ssau.tk.esa1.dao;

import com.ssau.tk.esa1.model.Hero;
import jakarta.persistence.EntityManager;

import java.util.List;

public class HeroDao {

    public void create(Hero hero) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(hero);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Hero get(Long id) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Hero hero = entityManager.find(Hero.class, id);

        entityManager.getTransaction().commit();
        entityManager.close();
        return hero;
    }

    public List<Hero> getAll() {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        List<Hero> heroes = entityManager.createQuery("select h from Hero h", Hero.class).getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
        return heroes;
    }

    public void update(Long id, Hero newHeroData) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Hero hero = entityManager.find(Hero.class, id);
        if (hero != null) {
            hero.setNameHero(newHeroData.getNameHero());
            hero.setLevel(newHeroData.getLevel());
            hero.setClassHero(newHeroData.getClassHero());
            hero.setSpellCells(newHeroData.getSpellCells());
            hero.setPlayer(newHeroData.getPlayer());
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(Long id) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Hero hero = entityManager.find(Hero.class, id);
        if (hero != null) {
            entityManager.remove(hero);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
