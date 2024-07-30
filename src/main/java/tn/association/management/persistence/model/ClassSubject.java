package tn.association.management.persistence.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class ClassSubject {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DayOfWeek day;

    private LocalTime startSession;


    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class aClass;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "classSubject", orphanRemoval = true)
    private Set<TeacherAttendance> teacherAttendances = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "classSubject", orphanRemoval = true)
    private Set<StudentAttendance> studentAttendances = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "classSubject", orphanRemoval = true)
    private Set<StudentScore> studentExamScores = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassSubject that = (ClassSubject) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
