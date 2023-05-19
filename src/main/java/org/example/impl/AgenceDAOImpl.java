package org.example.impl;

import org.example.DAO.AgenceDAO;
import org.example.model.Agence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class AgenceDAOImpl  implements AgenceDAO {

    private EntityManagerFactory entityManagerFactory;

    public AgenceDAOImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
    @Override
    public boolean addAgence(Agence agence) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(agence);
        transaction.commit();
        entityManager.close();

    }
}
