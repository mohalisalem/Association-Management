package tn.association.management.persistence.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Getter
@NoArgsConstructor
@Setter
@Entity
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Integer year;

    @ManyToOne
    @JoinColumn(name = "level_id")
    private Level level;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "aClass")
    private Set<Student> classStudents = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "aClass")
    private Set<ClassSubject> classSubjects = new HashSet<>();


    public Class(String name, Integer year) {
        this.name = name;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Class aClass = (Class) o;
        return Objects.equals(id, aClass.id) && Objects.equals(name, aClass.name) && Objects.equals(year, aClass.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, year);
    }
}
