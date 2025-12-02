package org.example.smartcity4.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    private double latitude;
    private double longitude;

    @Enumerated(EnumType.STRING)
    private IncidentType type;

    @Enumerated(EnumType.STRING)
    private IncidentStatus status;

    private LocalDateTime createdAt;

    private String resolutionNote;

    private String assignedUnit;
}