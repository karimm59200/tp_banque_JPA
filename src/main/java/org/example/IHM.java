package org.example;

import org.example.impl.AgenceDAOImpl;
import org.example.impl.ClientDAOImpl;
import org.example.impl.CompteDAOImpl;
import org.example.model.Agence;
import org.example.model.Client;
import org.example.model.Compte;

import javax.persistence.EntityManagerFactory;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class IHM {

    private static EntityManagerFactory entityManagerFactory;
    private static AgenceDAOImpl agenceDAO;
    private static ClientDAOImpl clientDAO;
    private static CompteDAOImpl compteDAO;

    public static void main() {
        entityManagerFactory = javax.persistence.Persistence.createEntityManagerFactory("banque");
        agenceDAO = new AgenceDAOImpl(entityManagerFactory);
        clientDAO = new ClientDAOImpl(entityManagerFactory);
        compteDAO = new CompteDAOImpl(entityManagerFactory);

        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println("1. Ajouter une agence");
            System.out.println("2. Ajouter un client");
            System.out.println("3. Ajouter un compte");
            System.out.println("0. Quitter");
            System.out.print("Votre choix: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addAgence(scanner);
                    break;
                case 2:
                    addClient(scanner);
                    break;
                case 3:
                    addCompte(scanner);
                    break;
                case 4:
                    System.out.println("Au revoir!");
                    break;
                default:
                    System.out.println("Choix invalide!");
            }
        } while (choice != 0);

    }

    private static void addAgence(Scanner scanner) {


        System.out.print("Adresse de l'agence: ");
        String adresse = scanner.nextLine();

        Agence agence = new Agence(adresse);
        agenceDAO.addAgence(agence);
        System.out.println("Agence ajoutée avec succès!");

    }

    private static void addClient (Scanner scanner){
        System.out.println("Nom du client: ");
        String nom = scanner.nextLine();

        System.out.println("Prénom du client: ");
        String prenom = scanner.nextLine();

        System.out.println("Date de naissance du client (dd.MM.yyyy: ");
        String dateNaissanceStr = scanner.nextLine();

        LocalDate dateNaissance = LocalDate.parse(dateNaissanceStr, DateTimeFormatter.ofPattern("dd.MM.yyyy"));



        Client client = new Client(nom, prenom, dateNaissance);
        clientDAO.addClient(client);
        System.out.println("Client ajouté avec succès!");

    }

    private static void addCompte (Scanner scanner){
        System.out.println("numéro de compte: ");
        String numero = scanner.nextLine();

        System.out.println("iban: ");
        String iban = scanner.nextLine();

        System.out.println("Solde du compte: ");
        double solde = scanner.nextDouble();

        System.out.println("Agence du compte: ");
        String agence = scanner.nextLine();

        System.out.println("Numéro du client: ");
        int idClient = scanner.nextInt();

        Compte compte = new Compte( numero, iban, solde, agence, idClient);
        compteDAO.addCompte(compte);
        System.out.println("Compte ajouté avec succès!");

    }
}

