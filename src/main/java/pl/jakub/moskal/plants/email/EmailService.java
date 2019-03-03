package pl.jakub.moskal.plants.email;

public interface EmailService {
    void email(String to, String userName, String subject);
    void emailSimple(String to, String userName, String subject);
}
