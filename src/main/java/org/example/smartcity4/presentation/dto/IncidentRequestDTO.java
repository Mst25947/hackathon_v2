package org.example.smartcity4.presentation.dto;

import lombok.Data;
import org.example.smartcity4.domain.IncidentType;

@Data
public class IncidentRequestDTO {
    private String title;
    private String description;
    private double latitude;
    private double longitude;
    private IncidentType type;
}
