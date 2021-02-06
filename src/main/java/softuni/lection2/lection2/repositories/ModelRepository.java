package softuni.lection2.lection2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.lection2.lection2.models.entities.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {
}
