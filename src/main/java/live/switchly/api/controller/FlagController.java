package live.switchly.api.controller;
import org.springframework.http.HttpStatus;
import live.switchly.api.model.Flag;
import live.switchly.api.service.FlagService;
import org.springframework.web.bind.annotation.*;
import live.switchly.api.dto.UpdateFlagStateRequest;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping({"/api/flags", "/api/v1/flags"})
public class FlagController {

    private final FlagService service;

    public FlagController(FlagService service) {
        this.service = service;
    }

    @PostMapping
    public Flag create(
            @RequestParam UUID organizationId,
            @RequestParam UUID projectId,
            @RequestParam String key,
            @RequestParam String name,
            @RequestParam boolean enabled,
            @RequestParam(required = false) String description
    ) {
        return service.create(
                organizationId,
                projectId,
                key,
                name,
                enabled,
                description
        );
    }

    @GetMapping("/project/{projectId}")
    public List<Flag> getByProjectId(
            @PathVariable UUID projectId
    ) {
        return service.getByProjectId(projectId);
    }

    @GetMapping("/{id}")
    public Flag getById(
            @PathVariable UUID id
    ) {
        return service.getById(id);
    }
    @PutMapping("/{flagId}/state")
    public Flag setState(
            @PathVariable UUID flagId,
            @Valid @RequestBody UpdateFlagStateRequest request) {

        return service.setEnabled(flagId, request.enabled());
    }
    @DeleteMapping("/{flagId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFlag(@PathVariable UUID flagId) {
        service.deleteById(flagId);
    }
}