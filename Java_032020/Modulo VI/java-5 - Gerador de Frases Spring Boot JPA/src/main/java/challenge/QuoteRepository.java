package challenge;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuoteRepository extends JpaRepository<Quote , Long> {

  Optional<List<Quote>> findAllByTypeIgnoreCase(String type);

  Optional<List<Quote>> findByActorIgnoreCaseAndTypeIgnoreCase(String actor, String type);

}
