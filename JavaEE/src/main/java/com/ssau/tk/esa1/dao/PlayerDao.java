package com.ssau.tk.esa1.dao;

import com.ssau.tk.esa1.model.Player;
import jakarta.persistence.EntityManager;

import java.util.List;

public class PlayerDao {
    public void create(Player player) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(player);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Player get(Long id) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Player player = entityManager.find(Player.class, id);

        entityManager.getTransaction().commit();
        entityManager.close();
        return player;
    }

    public List<Player> getAll() {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        List<Player> players = entityManager.createQuery("select p from Player p", Player.class).getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
        return players;
    }

    public void update(Long id, Player newPlayerData) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Player player = entityManager.find(Player.class, id);
        if (player != null) {

        }
        player.setFirstName(newPlayerData.getFirstName());
        player.setLastName(newPlayerData.getLastName());
        player.setBirthdate(newPlayerData.getBirthdate());
        player.setQuantityGames(newPlayerData.getQuantityGames());
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(Long id) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Player player = entityManager.find(Player.class, id);
        if (player != null) {
            entityManager.remove(player);
        }
        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
