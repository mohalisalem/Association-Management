package tn.association.management.persistence.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class ExamInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime date;

    // use hours as unit
    private Integer duration;

    @Column(columnDefinition = "TEXT")
    private String includedLessons;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

}
