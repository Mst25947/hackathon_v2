package org.example.smartcity4.application;

import org.example.smartcity4.data.IncidentRepository;
import org.example.smartcity4.domain.Incident;
import org.example.smartcity4.domain.IncidentStatus;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IncidentService {

    private final IncidentRepository repository;

    public List<Incident> getAllIncidents() {
        return repository.findAll();
    }

    public Incident getIncidentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Incident niet gevonden met id: " + id));
    }

    public Incident createIncident(Incident incident) {
        incident.setStatus(IncidentStatus.OPEN);
        incident.setCreatedAt(LocalDateTime.now());
        return repository.save(incident);
    }

    public Incident updateStatus(Long id, IncidentStatus newStatus) {
        Incident incident = getIncidentById(id);
        incident.setStatus(newStatus);
        return repository.save(incident);
    }

    public Incident resolveIncident(Long id, String note) {
        Incident incident = getIncidentById(id);

        // Business Logic: Je kunt alleen open incidenten oplossen
        if (incident.getStatus() == IncidentStatus.CLOSED) {
            throw new RuntimeException("Kan een gesloten incident niet meer wijzigen.");
        }

        incident.setStatus(IncidentStatus.RESOLVED);
        incident.setResolutionNote(note);

        return repository.save(incident);
    }
}