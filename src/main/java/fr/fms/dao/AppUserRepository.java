package fr.fms.dao;

import fr.fms.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);         // à partir  du nom d'utilisateur, on retourne un objet

    AppUser save(AppUser user);


}
