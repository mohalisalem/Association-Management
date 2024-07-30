package tn.association.management.persistence.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Entity
@Getter
@Setter
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String year;

    private boolean active;

    @ManyToOne
    @JoinColumn(name = "teacher_info_id")
    private TeacherInfo teacherInfo;


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "teacher")
    private Set<Availability> teacherAvailabilities = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "teacher")
    private Set<ClassSubject> subjectsToTeachByClass = new HashSet<>();

    public Teacher() {
        this.active = true;
    }

    public Teacher(String year) {
        this.year = year;
        this.active = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(id, teacher.id) && Objects.equals(year, teacher.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, year);
    }
}
