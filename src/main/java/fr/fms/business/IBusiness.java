package fr.fms.business;

import fr.fms.entities.Contact;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IBusiness {

    public Contact saveContact(Contact contact) throws Exception;

    public void deleteContact(Long id) throws Exception;


    List<Contact> findAll();

    Optional<Contact> readContact(Long id);
}
