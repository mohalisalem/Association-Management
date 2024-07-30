package tn.association.management.web.dto;

import java.time.LocalDate;

public record StudentInfoDTO(Long id, String name, String lastName, LocalDate birthDate, String phoneNumber,
                             String educationLevel) {
}
