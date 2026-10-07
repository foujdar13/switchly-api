package live.switchly.api.controller;

import live.switchly.api.model.Project;
import live.switchly.api.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }

    @PostMapping
    public Project create(
            @RequestParam String name,
            @RequestParam UUID organizationId) {

        return service.create(name, organizationId);
    }

    @GetMapping
    public List<Project> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Project getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Project update(
            @PathVariable UUID id,
            @RequestParam String name,
            @RequestParam UUID organizationId) {

        return service.update(id, name, organizationId);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable UUID id) {
        service.delete(id);
        return "Project deleted successfully";
    }
}