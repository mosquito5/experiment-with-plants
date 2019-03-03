package pl.jakub.moskal.plants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.jakub.moskal.plants.db.users.model.User;
import pl.jakub.moskal.plants.db.users.repository.UserRepository;
import pl.jakub.moskal.plants.db.users.repository.UserRoleRepository;
import pl.jakub.moskal.plants.security.PassGen;
import pl.jakub.moskal.plants.service.UserService;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class ExperienceWithPlantsApplication {

    @Autowired
    private  UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void init() {
        if(userRepository.findByUsername("Admin1").isEmpty()) {
            System.out.println("ADMIN NOT FOUND, CREATING...");
            String pass = new PassGen().getPass();
                System.out.println("Admin password: " + pass);
                String name = "admin";
                User user = new User("Admin1", pass, "admin1234@admin.com");
                userService.addWithAdminRole(user);
            System.out.println("DONE");
        }
    }

    public static void main(String[] args) {

        SpringApplication.run(ExperienceWithPlantsApplication.class, args);

    }
}
