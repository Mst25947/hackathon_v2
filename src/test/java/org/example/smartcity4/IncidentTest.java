package org.example.smartcity4;

import org.example.smartcity4.domain.Incident;
import org.example.smartcity4.domain.IncidentStatus;
import org.example.smartcity4.domain.IncidentType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IncidentTest {

    @Test
    void builder_ShouldCreateIncidentCorrectly() {
        Incident incident = Incident.builder()
                .title("Test Brand")
                .description("Rook uit dak")
                .latitude(52.5)
                .longitude(4.9)
                .type(IncidentType.FIRE)
                .status(IncidentStatus.OPEN)
                .build();

        assertNotNull(incident);
        assertEquals("Test Brand", incident.getTitle());
        assertEquals(IncidentType.FIRE, incident.getType());
        assertEquals(52.5, incident.getLatitude());
    }

    @Test
    void equals_ShouldReturnTrueForSameValues() {
        Incident incident1 = Incident.builder()
                .id(1L)
                .title("Identiek")
                .build();

        Incident incident2 = Incident.builder()
                .id(1L)
                .title("Identiek")
                .build();

        assertEquals(incident1, incident2);
    }

    @Test
    void noArgsConstructor_ShouldCreateEmptyObject() {
        Incident incident = new Incident();
        assertNull(incident.getTitle());
        assertNull(incident.getStatus());
    }
}
