package fr.fms.web;

import fr.fms.business.IBusiness;
import fr.fms.entities.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    IBusiness business;

    @GetMapping("/category")
    public List<Category> categories() throws Exception {
        List<Category> categories;
        categories = business.findAll();
        return categories;
    }

    @PostMapping("/category")
    public Category saveCategory(@RequestBody Category c){
        return business.saveCategory(c);
    }

    @DeleteMapping("/category/{id}")
    public void deleteCategory(@PathVariable("id") Long id){
        business.deleteCategory(id);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") Long id){
        Optional<Category> category = business.readCategory(id);
        return category.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
