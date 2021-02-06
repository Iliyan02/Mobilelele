package softuni.lection2.lection2.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import softuni.lection2.lection2.models.entities.Role;
import softuni.lection2.lection2.models.entities.User;
import softuni.lection2.lection2.models.entities.UserRole;
import softuni.lection2.lection2.repositories.UserRepository;
import softuni.lection2.lection2.security.CurrentUser;
import softuni.lection2.lection2.service.UserService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, CurrentUser currentUser) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    @Override
    public boolean authenticate(String username, String password) {
        Optional<User> byUsername = userRepository.findByUsername(username);

        if (byUsername.isEmpty()){
            return false;
        }
        return passwordEncoder.matches(password, byUsername.get().getPassword());
    }

    @Override
    public void loginUser(String username) {

        User user = userRepository.findByUsername(username).orElseThrow();

        List<Role> userRoles = user
                .getUserRoles()
                .stream()
                .map(UserRole::getRole)
                .collect(Collectors.toList());

        currentUser.setAnonymous(false);
        currentUser.setName(user.getUsername());
        currentUser.setUserRoles(userRoles);
    }

    @Override
    public void logoutCurrentUser() {
        currentUser.setAnonymous(true);
    }
}
