package softuni.lection2.lection2.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;

@Entity
@Table(name = "models")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Model extends BaseEntity {
    private String name;
    @Enumerated
    private Category category;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "start_year")
    private int startYear;
    @Column(name = "end_year")
    private Integer endYear;
    private Instant created;
    private Instant modified;
    @ManyToOne
    private Brand brand;
    @OneToMany(mappedBy = "model")
    private Set<Offer> offers;
}
