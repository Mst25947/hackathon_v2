package org.example.smartcity4.presentation;

import org.example.smartcity4.application.IncidentService;
import org.example.smartcity4.domain.Incident;
import org.example.smartcity4.domain.IncidentStatus;
import org.example.smartcity4.presentation.dto.IncidentRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incidents")
@RequiredArgsConstructor
public class IncidentController {

    private final IncidentService service;

    @GetMapping
    public ResponseEntity<List<Incident>> getAll() {
        return ResponseEntity.ok(service.getAllIncidents());
    }

    @PostMapping
    public ResponseEntity<Incident> create(@RequestBody IncidentRequestDTO dto) {
        Incident incident = Incident.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .type(dto.getType())
                .build();

        return ResponseEntity.ok(service.createIncident(incident));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Incident> updateStatus(@PathVariable Long id, @RequestParam IncidentStatus status) {
        return ResponseEntity.ok(service.updateStatus(id, status));
    }

    @PutMapping("/{id}/resolve")
    public ResponseEntity<Incident> resolveIncident(
            @PathVariable Long id,
            @RequestBody ResolveRequest request) {

        return ResponseEntity.ok(service.resolveIncident(id, request.getNote()));
    }
}