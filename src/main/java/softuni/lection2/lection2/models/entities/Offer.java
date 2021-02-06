package softuni.lection2.lection2.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "offers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Offer extends BaseEntity {
    private String description;
    @Enumerated
    private Engine engine;
    @Column(name = "image_url")
    private String imageUrl;
    private int mileage;
    private BigDecimal price;
    private Transmission transmission;
    private int year;
    private Instant created;
    private Instant modified;
    @ManyToOne
    private Model model;
    @ManyToOne
    private User seller;

}
