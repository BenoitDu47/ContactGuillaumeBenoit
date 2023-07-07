package fr.fms.web;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api")
public class ContactController {
    private static final String FOLDER = "C:\\Users\\PastorG\\Desktop\\Image\\";
    @Autowired
    IBusiness ibusiness;

    @GetMapping("/contacts")
    public List<Contact> contacts() throws Exception {
        return ibusiness.findAllContact();
    }


    @GetMapping(path = "/Imgcontacts/{id}")
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception {
        Contact Contact = ibusiness.getById(id).get();

        return Files.readAllBytes(Paths.get(Contact.getImage()));
    }

    @PostMapping("/contacts")
    public ResponseEntity<Contact> saveContact(@RequestParam("file") MultipartFile file, @RequestParam("contact") String contact) throws IOException {
        System.out.println(contact);
        Contact contac = new ObjectMapper().readValue(contact, Contact.class);
        String filePath = FOLDER + file.getOriginalFilename();
        Path path = Paths.get(filePath);
        Files.write(path, file.getBytes());
        contac.setImage(filePath);
        // file.transferTo(new File(FOLDER));
        Contact cont = ibusiness.saveContact(contac);
        if (Objects.isNull(cont)) {
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(cont.getId())
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










