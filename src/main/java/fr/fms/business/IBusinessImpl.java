package fr.fms.business;

import fr.fms.dao.CategoryRepository;
import fr.fms.dao.ContactRepository;
import fr.fms.entities.Category;
import fr.fms.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IBusinessImpl implements IBusiness {
    @Autowired
    ContactRepository contactRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public void createContact(Contact contact) throws Exception {

    }

    @Override
    public void updateContact(Contact contact) throws Exception {

    }

    @Override
    public void saveContact(Contact contact) throws Exception {

    }

    @Override
    public void deleteContact(Long id) throws Exception {
        contactRepository.deleteById(id);
    }

    @Override
    public Contact findById(Long id) throws Exception {
        return null;
    }

    @Override
    public void createCategory(Category category) throws Exception {

    }

    @Override
    public void updateCategory(Category category) throws Exception {

    }

    @Override
    public void saveCategory(Contact category) throws Exception {

    }

    @Override
    public void deleteCategory(Long id) throws Exception {
        categoryRepository.deleteById(id);
    }

}
