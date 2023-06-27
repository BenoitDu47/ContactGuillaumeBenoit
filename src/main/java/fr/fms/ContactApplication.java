package fr.fms;

import fr.fms.business.IBusinessImpl;
import fr.fms.dao.CategoryRepository;
import fr.fms.dao.ContactRepository;
import fr.fms.entities.Category;
import fr.fms.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContactApplication implements CommandLineRunner {
	@Autowired
	ContactRepository contactRepository;

	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	IBusinessImpl businessImpl;

	public static void main(String[] args) {
		SpringApplication.run(ContactApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		generateDatas();
	}

	private void generateDatas() {
		Category amis = categoryRepository.save(new Category("Amis"));
		Category divers = categoryRepository.save(new Category("Divers"));
		Category famille = categoryRepository.save(new Category("Famille"));
		Category travail = categoryRepository.save(new Category("Travail"));

		contactRepository.save(new Contact(null, "Macron", "Manu", "manumac@gmail.com", "4 rue des lois", "0120458547",amis));
		contactRepository.save(new Contact(null, "Sarkozy", "Nico", "nicSark75@gmail.com", "4 rue de la prison", "0545784532",amis));
		contactRepository.save(new Contact(null, "Johnson", "Boris", "BoJohn@free.com", "410 chemin du brexit", "0689523147",amis));
		contactRepository.save(new Contact(null, "Biden", "Joe", "joebid@usa.org", "150 place du pétrole", "0954783214",amis));

		contactRepository.save(new Contact(null, "Dupont", "Jean", "jean.dupont@example.com", "123 Rue de la Paix", "0123456789", divers));
		contactRepository.save(new Contact(null, "Dubois", "Marie", "marie.dubois@example.com", "456 Avenue du Soleil", "9876543210", divers));
		contactRepository.save(new Contact(null, "Lefebvre", "Sophie", "sophie.lefebvre@example.com", "789 Boulevard des Fleurs", "5678901234", divers));

		contactRepository.save(new Contact(null, "Smith", "John", "john.smith@example.com", "10 Main Street", "1234567890", famille));
		contactRepository.save(new Contact(null, "Johnson", "Sarah", "sarah.johnson@example.com", "20 Elm Avenue", "0987654321", famille));
		contactRepository.save(new Contact(null, "Brown", "Michael", "michael.brown@example.com", "30 Oak Drive", "9876543210", famille));
		contactRepository.save(new Contact(null, "Davis", "Emily", "emily.davis@example.com", "40 Pine Lane", "0123456789", famille));

		contactRepository.save(new Contact(null, "Martin", "Laura", "laura.martin@example.com", "50 Cedar Street", "9876543210", travail));
		contactRepository.save(new Contact(null, "Garcia", "Carlos", "carlos.garcia@example.com", "60 Maple Avenue", "0123456789", travail));
		contactRepository.save(new Contact(null, "Robinson", "Emma", "emma.robinson@example.com", "70 Oak Drive", "1234567890", travail));
		contactRepository.save(new Contact(null, "Bell", "Oliver", "oliver.bell@example.com", "80 Elm Avenue", "0987654321", travail));

	}

}
