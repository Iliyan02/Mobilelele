package softuni.lection2.lection2.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.lection2.lection2.models.entities.Category;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ModelDto {
    private String name;
    private Category category;
    private String imageUrl;
    private int startYear;
    private int endYear;

    @Override
    public String toString() {
        return "ModelDto{" +
                "name='" + name + '\'' +
                ", category=" + category +
                ", imageUrl='" + imageUrl + '\'' +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                '}';
    }
}
