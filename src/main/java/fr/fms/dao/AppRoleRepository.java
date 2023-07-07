package fr.fms.dao;

import fr.fms.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findByRolename(String rolename);     // renvoi à partir de rolemane l'objet AppRole correspondant

    AppRole save(AppRole role);
}
