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
    CategoryRepository categoryRepository;

    @Override
    public List<Contact> findAllContact() {
        return contactRepository.findAll();
    }

    @Override
    public Optional<Contact> readContact(Long id) {
        return contactRepository.findById(id);
    }

    @Override
    public Contact saveContact(Contact cont) {
        return contactRepository.save(cont);
    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category saveCategory(Category c) {
        return categoryRepository.save(c);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Optional<Category> readCategory(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Optional<Contact> getById(Long id) {
        return contactRepository.findById(id);
    }
}
