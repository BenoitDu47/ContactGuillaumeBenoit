package fr.fms.business;

import fr.fms.entities.Contact;
import fr.fms.entities.Category;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IBusiness {
    List<Category> findAll();

    public Contact saveContact(Contact contact) throws Exception;

    public void deleteContact(Long id) throws Exception;

    List<Contact> findAll();

    Optional<Contact> readContact(Long id);

    Category saveCategory(Category c);

    void deleteCategory(Long id);

    Optional<Category> readCategory(Long id);

}
