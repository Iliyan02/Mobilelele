package softuni.lection2.lection2.models.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BrandDto {
    private String name;

    private List<ModelDto> models = new ArrayList<>();

    public BrandDto addModel(ModelDto modelDto) {
        this.models.add(modelDto);
        return this;
    }

    @Override
    public String toString() {
        return "BrandDto{" +
                "name='" + name + '\'' +
                ", models=" + models +
                '}';
    }
}
