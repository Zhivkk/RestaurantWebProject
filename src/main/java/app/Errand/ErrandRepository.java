package app.Errand;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ErrandRepository extends JpaRepository<Errand, UUID> {
}
