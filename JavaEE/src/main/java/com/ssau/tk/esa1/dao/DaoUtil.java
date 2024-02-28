package com.ssau.tk.esa1.dao;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DaoUtil {
    private static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("postgres-game");

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public static void refresh() {
        entityManagerFactory.close();
        entityManagerFactory = Persistence.createEntityManagerFactory("postgres-game");
    }
}
