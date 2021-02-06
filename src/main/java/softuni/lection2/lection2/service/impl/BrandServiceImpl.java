package softuni.lection2.lection2.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.lection2.lection2.models.dtos.BrandDto;
import softuni.lection2.lection2.models.dtos.ModelDto;
import softuni.lection2.lection2.models.entities.Brand;
import softuni.lection2.lection2.models.entities.Model;
import softuni.lection2.lection2.repositories.ModelRepository;
import softuni.lection2.lection2.service.BrandService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {
    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;

    public BrandServiceImpl(ModelRepository modelRepository1, ModelMapper modelMapper) {
        this.modelRepository = modelRepository1;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BrandDto> getAllBrands() {
        List<BrandDto> result = new ArrayList<>();
        List<Model> allModels = modelRepository.findAll();
        ModelMapper modelMapper = new ModelMapper();

        allModels.forEach(m -> {
            Brand brand = m.getBrand();
            Optional<BrandDto> brandDtoOpt = findByName(result, brand.getName());

            if (brandDtoOpt.isEmpty()) {
                BrandDto brandDto = new BrandDto();
                modelMapper.map(brand, brandDto);
                result.add(brandDto);
            }

            ModelDto modelDto = new ModelDto();
            modelMapper.map(m, modelDto);

        });

        return result;
    }

    private static Optional<BrandDto> findByName(List<BrandDto> allModels, String name) {
        return allModels.stream().filter(m -> m.getName().equals(name)).findAny();
    }
}
