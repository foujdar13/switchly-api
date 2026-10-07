package live.switchly.api.repository;

import live.switchly.api.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrganizationRepository
        extends JpaRepository<Organization, UUID> {
}