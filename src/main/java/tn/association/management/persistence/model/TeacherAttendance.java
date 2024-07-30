package tn.association.management.persistence.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class TeacherAttendance {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDate day;

    private boolean status;

    @ManyToOne
    @JoinColumn(name = "class_subject_id")
    private ClassSubject classSubject;
}
