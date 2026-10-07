package live.switchly.api.repository;

import live.switchly.api.model.Flag;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class InMemoryFlagRepository implements FlagRepository {

    private final Map<UUID, Flag> flags = new HashMap<>();

    @Override
    public Flag save(Flag flag) {
        flags.put(flag.getId(), flag);
        return flag;
    }

    @Override
    public Optional<Flag> findById(UUID id) {
        return Optional.ofNullable(flags.get(id));
    }

    @Override
    public List<Flag> findByProjectId(UUID projectId) {
        return flags.values()
                .stream()
                .filter(flag -> flag.getProjectId().equals(projectId))
                .toList();
    }

    @Override
    public boolean existsByProjectIdAndKey(UUID projectId, String key) {
        return flags.values()
                .stream()
                .anyMatch(flag ->
                        flag.getProjectId().equals(projectId)
                                && flag.getKey().equals(key)
                );
    }
}