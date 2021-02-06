package softuni.lection2.lection2.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User extends BaseEntity {
    private String username;
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "is_active")
    private boolean isActive;
    @Column(name = "image_url")
    private String imageUrl;
    private Instant created;
    private Instant modified;
   @OneToMany(mappedBy = "seller")
   private Set<Offer> offers;
   @ManyToMany(fetch = FetchType.EAGER)
   private List<UserRole> userRoles;

}

