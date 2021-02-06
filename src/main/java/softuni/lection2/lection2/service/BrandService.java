package softuni.lection2.lection2.service;

import org.springframework.beans.factory.annotation.Autowired;
import softuni.lection2.lection2.models.dtos.BrandDto;

import java.util.List;

public interface BrandService {
    List<BrandDto> getAllBrands();
}
