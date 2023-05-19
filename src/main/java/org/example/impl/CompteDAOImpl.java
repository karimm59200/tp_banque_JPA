package org.example.impl;

import org.example.DAO.CompteDAO;
import org.example.model.Compte;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class CompteDAOImpl implements CompteDAO {

    private EntityManagerFactory entityManagerFactory;

    public CompteDAOImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void addCompte(Compte compte) {
EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(compte);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
