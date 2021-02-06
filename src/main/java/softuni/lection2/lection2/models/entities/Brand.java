package softuni.lection2.lection2.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.dom4j.rule.Mode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.Instant;
import java.util.Set;

@Entity
@Table(name = "brands")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Brand extends BaseEntity {
    private String name;
    private Instant created;
    private Instant modified;
    @OneToMany(mappedBy = "brand", fetch = FetchType.EAGER)
    private Set<Model> models;
}
