package fr.fms.business;

import fr.fms.dao.AppRoleRepository;
import fr.fms.dao.AppUserRepository;
import fr.fms.entities.AppRole;
import fr.fms.entities.AppUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service @Transactional @Slf4j
public class AccountServiceImpl  implements AccountService{
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private AppRoleRepository appRoleRepository;

    @Autowired
    public BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public AppUser saveUser(AppUser user) {
        String hashPW = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(hashPW);
        log.info("Sauvegarde d'un nouvel utilisateur {} en base", user);
        return appUserRepository.save(user);
    }

    @Override
    public AppRole saveRole(AppRole role) {
        log.info("Sauvegarde d'un rôle en base");
        return appRoleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        AppRole role = appRoleRepository.findByRolename(roleName);
        AppUser user = appUserRepository.findByUsername(userName);
        user.getRoles().add(role);
        log.info("Association d'un rôle à un utilisateur");
        // puisque la méthode est transactionnel, dès qu'il y a un commit, il y a ajout en base : rôle + user + table d'association
    }

    @Override
    public AppUser findUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public ResponseEntity<List<AppUser>> listUsers() {   // ResponseEntity permet d'ajouter au corps des entetes et un état
        return ResponseEntity.ok().body(appUserRepository.findAll());
    }

@Bean    // sera executé par Spring au boot de l'appli delors on pourra l'injecter ailleurs (SecurityConfig par ex)
    public BCryptPasswordEncoder getbCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
