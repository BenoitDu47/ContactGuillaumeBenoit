package fr.fms;

import fr.fms.business.AccountService;
import fr.fms.business.AccountServiceImpl;
import fr.fms.business.IBusinessImpl;
import fr.fms.dao.CategoryRepository;
import fr.fms.dao.ContactRepository;
import fr.fms.entities.AppRole;
import fr.fms.entities.AppUser;
import fr.fms.entities.Category;
import fr.fms.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class ContactApplication implements CommandLineRunner {
    private static final String FOLDER = "C:\\Users\\PastorG\\Desktop\\Image";
    @Autowired
    ContactRepository contactRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    AccountServiceImpl accountServiceImpl;
    public static void main(String[] args) {
        SpringApplication.run(ContactApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //generateDatas();
       // generateUsersRoles();
    }

    private void generateDatas() {
        Category amis = categoryRepository.save(new Category("Amis"));
        Category divers = categoryRepository.save(new Category("Divers"));
        Category famille = categoryRepository.save(new Category("Famille"));
        Category travail = categoryRepository.save(new Category("Travail"));

        contactRepository.save(new Contact(null, "Macron", "Manu", "manumac@gmail.com", "4 rue des lois", "0120458547", FOLDER, amis));
        contactRepository.save(new Contact(null, "Sarkozy", "Nico", "nicSark75@gmail.com", "4 rue de la prison", "0545784532", FOLDER, amis));
        contactRepository.save(new Contact(null, "Johnson", "Boris", "BoJohn@free.com", "410 chemin du brexit", "0689523147", FOLDER, amis));
        contactRepository.save(new Contact(null, "Biden", "Joe", "joebid@usa.org", "150 place du pétrole", "0954783214", FOLDER, amis));
        contactRepository.save(new Contact(null, "Dupont", "Jean", "jean.dupont@example.com", "123 Rue de la Paix", "0723456789", FOLDER, divers));
        contactRepository.save(new Contact(null, "Dubois", "Marie", "marie.dubois@example.com", "456 Avenue du Soleil", "0476543210", FOLDER, divers));
        contactRepository.save(new Contact(null, "Lefebvre", "Sophie", "sophie.lefebvre@example.com", "789 Boulevard des Fleurs", "0378901234", FOLDER, divers));
        contactRepository.save(new Contact(null, "Smith", "John", "john.smith@example.com", "10 Main Street", "0234567890", FOLDER, famille));
        contactRepository.save(new Contact(null, "Johnson", "Sarah", "sarah.johnson@example.com", "20 Elm Avenue", "0487654321", FOLDER, famille));
        contactRepository.save(new Contact(null, "Brown", "Michael", "michael.brown@example.com", "30 Oak Drive", "0176543210", FOLDER, famille));
        contactRepository.save(new Contact(null, "Davis", "Emily", "emily.davis@example.com", "40 Pine Lane", "0323456789", FOLDER, famille));
        contactRepository.save(new Contact(null, "Martin", "Laura", "laura.martin@example.com", "50 Cedar Street", "0876543210", FOLDER, travail));
        contactRepository.save(new Contact(null, "Garcia", "Carlos", "carlos.garcia@example.com", "60 Maple Avenue", "0123456789", FOLDER, travail));
        contactRepository.save(new Contact(null, "Robinson", "Emma", "emma.robinson@example.com", "70 Oak Drive", "0234567890", FOLDER, travail));
        contactRepository.save(new Contact(null, "Bell", "Oliver", "oliver.bell@example.com", "80 Elm Avenue", "0687654321", FOLDER, travail));
    }
    private void generateUsersRoles() {
        accountServiceImpl.saveUser(new AppUser(null, "papa", "12345", new ArrayList<>()));
        accountServiceImpl.saveUser(new AppUser(null, "mama", "12345", new ArrayList<>()));
        accountServiceImpl.saveRole(new AppRole(null, "ADMIN"));
        accountServiceImpl.saveRole(new AppRole(null, "USER"));
        accountServiceImpl.addRoleToUser("papa", "ADMIN");
        accountServiceImpl.addRoleToUser("papa", "USER");
        accountServiceImpl.addRoleToUser("mama", "USER");
    }
}
