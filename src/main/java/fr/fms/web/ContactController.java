package fr.fms.web;

import fr.fms.business.IBusiness;
import fr.fms.business.IBusinessImpl;
import fr.fms.dao.CategoryRepository;
import fr.fms.dao.ContactRepository;
import fr.fms.entities.Contact;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Controller
public class ContactController {
    @Autowired
    IBusiness ibusiness;

@GetMapping("/contacts")
    public List<Contact> contacts(){
    List<Contact> contacts;
    contacts = ibusiness.findAll();
    return contacts;
}
@PostMapping("/contacts")
    public Contact saveContact(@RequestBody Contact cont) throws Exception {
    return ibusiness.saveContact(cont);
}
@DeleteMapping("/contacts/{id}")
    public void deleteContact(@PathVariable("id") Long id) throws Exception {
    ibusiness.deleteContact(id);
}

@GetMapping("/contacts/{id}")
    public ResponseEntity<Contact>getContactById(@PathVariable("id") Long id){
        Optional<Contact> contact = ibusiness.readContact(id);
        if(contact.isPresent()){
            return new ResponseEntity<>(contact.get(), HttpStatus.OK);
        }
    return null;
}

}










