package fr.fms.business;

import fr.fms.entities.Contact;
import fr.fms.entities.Category;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IBusiness {
    List<Category> findAllCategory();

    public Contact saveContact(Contact cont);

    public void deleteContact(Long id);

    List<Contact> findAllContact();

    Optional<Contact> readContact(Long id);

    Category saveCategory(Category c);

    void deleteCategory(Long id);

    Optional<Category> readCategory(Long id);

}
