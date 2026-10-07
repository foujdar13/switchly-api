package live.switchly.api.controller;

import live.switchly.api.model.Organization;
import live.switchly.api.service.OrganizationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {

    private final OrganizationService service;

    public OrganizationController(OrganizationService service) {
        this.service = service;
    }

    @PostMapping
    public Organization create(@RequestParam String name) {

        return service.create(name);
    }

    @GetMapping
    public List<Organization> getAll() {

        return service.getAll();
    }

    @GetMapping("/{id}")
    public Organization getById(@PathVariable UUID id) {

        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable UUID id) {

        service.delete(id);

        return "Organization deleted successfully";
    }
    @PutMapping("/{id}")
    public Organization update(
            @PathVariable UUID id,
            @RequestParam String name) {

        return service.update(id, name);
    }
}