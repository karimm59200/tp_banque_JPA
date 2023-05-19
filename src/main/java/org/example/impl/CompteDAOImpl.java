package org.example.impl;

import org.example.DAO.CompteDAO;
import org.example.model.Agence;
import org.example.model.Client;
import org.example.model.Compte;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

public class CompteDAOImpl implements CompteDAO {

    private EntityManagerFactory entityManagerFactory;

    public CompteDAOImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void addCompte(Compte compte, Long idAgence, Long idClient) {
EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Agence agence = entityManager.find(Agence.class, idAgence);
        Client client = entityManager.find(Client.class, idClient);
        compte.setAgence(agence);
        client.getComptes().add(compte);
        compte.getClients().add(client);
        entityManager.persist(compte);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
