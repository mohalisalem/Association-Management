package tn.association.management.persistence.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    private List<Student> studentHistory = new ArrayList<>();


    public StudentInfo(String lastName, String name, String phoneNumber) {
        this.lastName = lastName;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }


}
