package live.switchly.api.service;

import live.switchly.api.model.Flag;
import live.switchly.api.repository.FlagRepository;
import org.springframework.stereotype.Service;
import live.switchly.api.exception.FlagNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class FlagService {

    private final FlagRepository repository;

    public FlagService(FlagRepository repository) {
        this.repository = repository;
    }

    public Flag create(
            UUID organizationId,
            UUID projectId,
            String key,
            String name,
            boolean enabled,
            String description
    ) {

        if (repository.existsByProjectIdAndKey(projectId, key)) {
            throw new RuntimeException("Flag with this key already exists");
        }

        Flag flag = new Flag(
                UUID.randomUUID(),
                organizationId,
                projectId,
                key,
                name,
                enabled,
                description
        );

        return repository.save(flag);
    }

    public List<Flag> getByProjectId(UUID projectId) {
        return repository.findByProjectId(projectId);
    }


    public Flag getById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new FlagNotFoundException("Flag not found: " + id)
                );
    }

    public Flag setEnabled(UUID flagId, boolean enabled) {
        Flag flag = getById(flagId);

        Flag updatedFlag = new Flag(
                flag.getId(),
                flag.getOrganizationId(),
                flag.getProjectId(),
                flag.getKey(),
                flag.getName(),
                enabled,
                flag.getDescription()
        );

        return repository.save(updatedFlag);
    }


    public void deleteById(UUID id) {
        boolean deleted = repository.deleteById(id);

        if (!deleted) {
            throw new FlagNotFoundException("Flag not found: " + id);
        }
    }


}