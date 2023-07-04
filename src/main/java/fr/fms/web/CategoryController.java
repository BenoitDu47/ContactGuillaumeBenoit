package fr.fms.web;

import fr.fms.business.IBusiness;
import fr.fms.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    IBusiness business;

    @GetMapping("/categories")
    public List<Category> categories() throws Exception {
        List<Category> categories;
        categories = business.findAllCategory();
        return categories;
    }

    @PostMapping("/categories")
    public ResponseEntity<Category> saveCategory(@RequestBody Category c) {
        Category category = business.saveCategory(c);
        if(Objects.isNull(category)) {
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(category.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/categories/{id}")
    public void deleteCategory(@PathVariable("id") Long id) {
        business.deleteCategory(id);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") Long id) {
        Optional<Category> category = business.readCategory(id);
        return category.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
