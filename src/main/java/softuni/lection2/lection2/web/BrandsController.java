package softuni.lection2.lection2.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import softuni.lection2.lection2.service.BrandService;

@Controller
@RequestMapping("/brands")
public class BrandsController {
    private final BrandService brandService;

    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/all")
    public String allBrands(Model model) {
        model.addAttribute("brands", brandService.getAllBrands());
        return "brands";
    }
}