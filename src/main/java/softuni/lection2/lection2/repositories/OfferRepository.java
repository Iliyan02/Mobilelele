package softuni.lection2.lection2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.lection2.lection2.models.entities.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Integer> {
}
