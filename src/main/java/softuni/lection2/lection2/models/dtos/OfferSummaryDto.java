package softuni.lection2.lection2.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.lection2.lection2.models.entities.Engine;
import softuni.lection2.lection2.models.entities.Transmission;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OfferSummaryDto {
    private Engine engine;
    private String imageUrl;
    private int mileage;
    private BigDecimal price;
    private int year;
    private Transmission transmission;

}
