package pl.jakub.moskal.plants.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.jakub.moskal.plants.security.PassGen;
import pl.jakub.moskal.plants.db.users.model.User;
import pl.jakub.moskal.plants.db.users.model.UserRole;
import pl.jakub.moskal.plants.db.users.repository.UserRepository;

@Service
public class UserService {
    private static final String DEFAULT_ROLE = "ROLE_USER";
    private static final String ADMIN_ROLE = "ROLE_ADMIN";
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void addWithDefaultRole(User user) {
        addWithRole(user, DEFAULT_ROLE);
    }

    public void addWithAdminRole(User user) {
        addWithRole(user, ADMIN_ROLE);
    }

    private void addWithRole(User user, String role) {
        UserRole userRole = new UserRole(role);
        user.getUserRoles().add(userRole);
        String passwordHash = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordHash);
        user.setSpassword(passwordHash);
        userRepository.save(user);
    }

    public String resetPassword(User user) {
        PassGen psgn = new PassGen();
        String pass = psgn.getPass();
        String passwordHash = passwordEncoder.encode(pass);
        user.setPassword(passwordHash);
        user.setSpassword(passwordHash);
        userRepository.save(user);

        return pass;
    }

    public void changePassowrd(User user, String pass) {
        String passwordHash = passwordEncoder.encode(pass);
        user.setPassword(passwordHash);
        user.setSpassword(passwordHash);
        userRepository.save(user);
    }
}
