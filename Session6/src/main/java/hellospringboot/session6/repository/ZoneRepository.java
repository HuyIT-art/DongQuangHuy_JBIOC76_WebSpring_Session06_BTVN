package hellospringboot.session6.repository;

import hellospringboot.session6.entity.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZoneRepository
        extends JpaRepository<Zone, Long> {
}