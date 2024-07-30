package tn.association.management.persistence.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String year;

    private boolean active;

    @ManyToOne
    @JoinColumn(name = "student_info_id")
    private StudentInfo studentInfo;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class aClass;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student", orphanRemoval = true)
    private Set<StudentAttendance> studentAttendances = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student", orphanRemoval = true)
    private Set<StudentScore> studentScores = new HashSet<>();

    public Student() {
        this.active = true;
    }

    public Student(Long id, String year) {
        this.id = id;
        this.year = year;
        this.active = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return active == student.active && Objects.equals(id, student.id) && Objects.equals(year, student.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, year, active);
    }
}
