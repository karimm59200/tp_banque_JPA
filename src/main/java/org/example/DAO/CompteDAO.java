package org.example.DAO;

import org.example.model.Compte;

public interface CompteDAO {

    void addCompte(Compte compte, Long idAgence, Long idClient);


}
