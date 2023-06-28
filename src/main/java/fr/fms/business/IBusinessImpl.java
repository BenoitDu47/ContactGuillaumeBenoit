package fr.fms.business;

import fr.fms.dao.CategoryRepository;
import fr.fms.dao.ContactRepository;
import fr.fms.entities.Contact;
import fr.fms.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class IBusinessImpl implements IBusiness {
    @Autowired
    ContactRepository contactRepository;
    @Autowired

    CategoryRepository categoryRepository;public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public Optional<Contact> readContact(Long id) {
        return contactRepository.findById(id);
    }

    @Override
    public Contact saveContact(Contact contact) throws Exception {
        return contactRepository.save(contact);
    }
    @Override
    public void deleteContact(Long id) throws Exception {
        contactRepository.deleteById(id);

    CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category saveCategory(Category c) {
        return categoryRepository.save(c);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Optional<Category> readCategory(Long id) {
        return categoryRepository.findById(id);

    }
}
