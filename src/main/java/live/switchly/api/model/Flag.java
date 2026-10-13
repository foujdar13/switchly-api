package live.switchly.api.model;

import java.util.UUID;

public class Flag {

    private final UUID id;
    private final UUID organizationId;
    private final UUID projectId;
    private final String key;
    private final String name;
    private boolean enabled;
    private String description;
    public Flag(
            UUID id,
            UUID organizationId,
            UUID projectId,
            String key,
            String name,
            boolean enabled,
            String description
    ) {
        this.id = id;
        this.organizationId = organizationId;
        this.projectId = projectId;
        this.key = key;
        this.name = name;
        this.enabled = enabled;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public UUID getOrganizationId() {
        return organizationId;
    }

    public UUID getProjectId() {
        return projectId;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    public String getDescription() {
        return description;
    }
}