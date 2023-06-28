package fr.fms.business;

import fr.fms.entities.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IBusiness {
    List<Category> findAll();

    Category saveCategory(Category c);

    void deleteCategory(Long id);

    Optional<Category> readCategory(Long id);
}
