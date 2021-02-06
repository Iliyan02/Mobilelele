package softuni.lection2.lection2.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import softuni.lection2.lection2.models.entities.Role;
import softuni.lection2.lection2.models.entities.UserRole;

import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CurrentUser {
    private static final String ANONYMOUS = "anonymous";

    private String name = ANONYMOUS;
    private boolean isAnonymous = true;
    private List<Role> userRoles = new ArrayList<>();

    public boolean isAnonymous(){return isAnonymous;}
    public boolean isLoggedIn(){return !isAnonymous();}

    public boolean isAdmin(){
        return userRoles.contains(Role.Admin);
    }

    public CurrentUser setAnonymous(boolean anonymous) {
        if (anonymous){
            this.name = ANONYMOUS;
            this.userRoles.clear();
        }
        isAnonymous = anonymous;
        return this;
    }

    public CurrentUser setUserRoles(List<Role> newUserRoles) {
        userRoles.clear();
        userRoles.addAll(newUserRoles);
        return this;
    }
}
