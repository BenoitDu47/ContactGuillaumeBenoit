package fr.fms.business;

import fr.fms.entities.Category;
import fr.fms.entities.Contact;
import org.springframework.stereotype.Service;

@Service
public interface IBusiness {

    public void createContact(Contact contact) throws Exception;

    public void updateContact(Contact contact) throws Exception;

    public void saveContact(Contact contact) throws Exception;

    public void deleteContact(Long id) throws Exception;

    Contact findById(Long id) throws Exception;

    public void createCategory(Category category) throws Exception;

    public void updateCategory(Category category) throws Exception;

    public void saveCategory(Contact category) throws Exception;

    public void deleteCategory(Long id) throws Exception;

}
