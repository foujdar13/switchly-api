package live.switchly.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private UUID organizationId;

    public Project() {
    }

    public Project(String name, UUID organizationId) {
        this.name = name;
        this.organizationId = organizationId;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public UUID getOrganizationId() {
        return organizationId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrganizationId(UUID organizationId) {
        this.organizationId = organizationId;
    }
}