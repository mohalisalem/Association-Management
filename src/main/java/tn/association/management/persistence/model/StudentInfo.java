package tn.association.management.persistence.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class StudentInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastName;

    private LocalDate birthDate;

    @Column(nullable = false)
    private String phoneNumber;

    private String educationLevel;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "studentInfo")
    private Set<Student> studentHistory = new HashSet<>();


    public StudentInfo(String lastName, String name, String phoneNumber) {
        this.lastName = lastName;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentInfo that = (StudentInfo) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(lastName, that.lastName) && Objects.equals(birthDate, that.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, birthDate);
    }
}
