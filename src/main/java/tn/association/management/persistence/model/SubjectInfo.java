package tn.association.management.persistence.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class SubjectInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String subjectName;

    private String mainSource;

    private String sourceAuthor;

    private String subjectDuration;

    private Integer singleSessionDuration;

    @ManyToOne
    @JoinColumn(name = "level_id")
    private Level level;

    public SubjectInfo(String subjectName) {
        this.subjectName = subjectName;
    }
}

