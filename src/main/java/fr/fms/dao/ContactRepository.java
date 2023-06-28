package fr.fms.dao;

import fr.fms.entities.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Long> {
    Page<Contact> findByNameContains(String keyword, Pageable pageable);
    Page<Contact> findByCategoryId(Long idCat, Pageable pageable);

}
