package softuni.lection2.lection2.web;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import softuni.lection2.lection2.models.entities.*;
import softuni.lection2.lection2.repositories.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;


@Component
public class DBInit implements CommandLineRunner {

    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;
    private final OfferRepository offerRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    public DBInit(ModelRepository modelRepository,
                  BrandRepository brandRepository, OfferRepository offerRepository, PasswordEncoder passwordEncoder, UserRepository userRepository, UserRoleRepository userRoleRepository) {

        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
        this.offerRepository = offerRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Brand fordBrand = new Brand();
        fordBrand.setName("Ford");
        setCurrentTimestamps(fordBrand);

        Brand hondaBrand = new Brand();
        hondaBrand.setName("Honda");
        setCurrentTimestamps(hondaBrand);

        brandRepository.saveAll(List.of(fordBrand, hondaBrand));

        Model fiestaModel = initFiesta(fordBrand);
        initFiesta(fordBrand);
        initEscort(fordBrand);
        initNC750S(hondaBrand);
        createFiestaOffer(fiestaModel);

        initUsers();
    }



    private void initUsers(){
        UserRole adminRole = new UserRole().setRole(Role.Admin);
        UserRole userRole = new UserRole().setRole(Role.User);

        userRoleRepository.saveAll(List.of(adminRole, userRole));

        User admin = new User();
        admin.setFirstName("Kiril");
        admin.setLastName("Dimitrov");
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("topsecret"));
        admin.setUserRoles(List.of(adminRole, userRole));
        admin.setCreated(Instant.now());
        admin.setModified(Instant.now());


        User pesho = new User();
        pesho.setFirstName("Petar");
        pesho.setLastName("Dimitrov");
        pesho.setUsername("pesho");
        pesho.setPassword(passwordEncoder.encode("topsecret"));
        pesho.setUserRoles(List.of(userRole));
        pesho.setCreated(Instant.now());
        pesho.setModified(Instant.now());
        userRepository.saveAll(List.of(admin, pesho));


    }

    public Model initNC750S(Brand hondaBrand) {
        Model nc750s = new Model();

        nc750s.setName("NC750S");
        nc750s.setCategory(Category.Motorcycle);
        nc750s.setImageUrl("https://www.motorcyclespecs.co.za/Gallery%20B/Honda%20NC750S%2014%20%207.jpg");
        nc750s.setStartYear(2014);
        nc750s.setBrand(hondaBrand);

        nc750s.setModified(Instant.now());
        nc750s.setCreated(Instant.now());

        return modelRepository.save(nc750s);

    }

    public Model initEscort(Brand fordBrand) {
        Model escort = new Model();

        escort.setName("Escort");
        escort.setCategory(Category.Car);
        escort.setImageUrl("https://media.autoexpress.co.uk/image/private/s--iYtidyqo--/v1610124175/autoexpress/2021/01/Ford%20Escort%20Mk2-5.jpg");
        escort.setStartYear(1968);
        escort.setEndYear(2002);
        escort.setBrand(fordBrand);

        escort.setModified(Instant.now());
        escort.setCreated(Instant.now());

        return modelRepository.save(escort);

    }

    private void createFiestaOffer(Model model) {
        Offer fiestaOffer = new Offer();

        fiestaOffer.setEngine(Engine.GASOLINE);
        fiestaOffer.setImageUrl("https://media.autoexpress.co.uk/image/private/s--WJbM8Jn1--/v1579598631/autoexpress/2020/01/the-new-fiesta-trend.jpg");
        fiestaOffer.setMileage(30000);
        fiestaOffer.setPrice(BigDecimal.valueOf(10000));
        fiestaOffer.setYear(2019);
        fiestaOffer.setDescription("karana e ot men");
        fiestaOffer.setTransmission(Transmission.MANUAL);
        fiestaOffer.setModel(model);
        fiestaOffer.setCreated(Instant.now());

        offerRepository.save(fiestaOffer);
    }

    public Model initFiesta(Brand fordBrand) {
        Model fiesta = new Model();

        fiesta.setName("Fiesta");
        fiesta.setCategory(Category.Car);
        fiesta.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/7/7d/2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg");
        fiesta.setStartYear(1976);
        fiesta.setBrand(fordBrand);

        fiesta.setModified(Instant.now());
        fiesta.setCreated(Instant.now());

        return modelRepository.save(fiesta);

    }

    public static void setCurrentTimestamps(Brand brand) {
        brand.
                setCreated(Instant.now());
        brand.setCreated(Instant.now());
    }
}
