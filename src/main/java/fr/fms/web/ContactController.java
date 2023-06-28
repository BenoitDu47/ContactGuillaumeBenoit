package fr.fms.web;


import fr.fms.business.IBusiness;
import fr.fms.business.IBusinessImpl;
import fr.fms.dao.CategoryRepository;
import fr.fms.dao.ContactRepository;
import fr.fms.entities.Category;
import fr.fms.entities.Contact;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@RestController
@RequestMapping("/api")
@Controller
public class ContactController {
    @Autowired
    IBusiness ibusiness;

    @GetMapping("/contacts")
    public List<Contact> contacts() {
        List<Contact> contacts;
        contacts = ibusiness.findAllContact();
        return contacts;
    }

    @PostMapping("/contacts")
    public ResponseEntity<Contact> saveContact(@RequestBody Contact cont) {
        Contact contact = ibusiness.saveContact(cont);
        if (Objects.isNull(contact)) {
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(contact.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/contacts/{id}")
    public void deleteContact(@PathVariable("id") Long id) throws Exception {
        ibusiness.deleteContact(id);
    }

    @GetMapping("/contacts/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable("id") Long id) {
        Optional<Contact> contact = ibusiness.readContact(id);
        return contact.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElse(null);
    }

}










