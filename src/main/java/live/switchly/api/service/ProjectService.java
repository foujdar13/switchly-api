package live.switchly.api.service;
import live.switchly.api.exception.ProjectNotFoundException;
import live.switchly.api.model.Project;
import live.switchly.api.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProjectService {

    private final ProjectRepository repository;

    public ProjectService(ProjectRepository repository) {
        this.repository = repository;
    }

    public Project create(String name, UUID organizationId) {
        Project project = new Project(name, organizationId);
        return repository.save(project);
    }

    public List<Project> getAll() {
        return repository.findAll();
    }

    public Project getById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ProjectNotFoundException(
                                "Project not found with id: " + id
                        ));
    }

    public Project update(UUID id, String name, UUID organizationId) {

        Project project = repository.findById(id)
                .orElseThrow(() ->
                        new ProjectNotFoundException(
                                "Project not found with id: " + id
                        ));

        project.setName(name);
        project.setOrganizationId(organizationId);

        return repository.save(project);
    }

    public void delete(UUID id) {

        if (!repository.existsById(id)) {
            throw new ProjectNotFoundException(
                    "Project not found with id: " + id
            );
        }

        repository.deleteById(id);
    }
}
