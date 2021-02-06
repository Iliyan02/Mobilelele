package softuni.lection2.lection2.service;

public interface UserService {

    boolean authenticate(String username, String password);
    void loginUser(String username);

    void logoutCurrentUser();
}
