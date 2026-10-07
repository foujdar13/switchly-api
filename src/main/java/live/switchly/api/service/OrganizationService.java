package live.switchly.api.service;
import live.switchly.api.exception.OrganizationNotFoundException;
import live.switchly.api.model.Organization;
import live.switchly.api.repository.OrganizationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrganizationService {

    private final OrganizationRepository repository;

    public OrganizationService(OrganizationRepository repository) {
        this.repository = repository;
    }

    public Organization create(String name) {

        Organization organization =
                new Organization(UUID.randomUUID(), name);

        return repository.save(organization);
    }

    public List<Organization> getAll() {

        return repository.findAll();
    }

    public void delete(UUID id) {

        repository.deleteById(id);
    }
    public Organization getById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new OrganizationNotFoundException(
                                "Organization not found with id: " + id
                        ));
    }
    public Organization update(UUID id, String name) {

        Organization organization = repository.findById(id)
                .orElseThrow(() ->
                        new OrganizationNotFoundException(
                                "Organization not found with id: " + id
                        ));

        organization.setName(name);

        return repository.save(organization);
    }
}