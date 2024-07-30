package tn.association.management.persistence.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String category;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "level")
    private Set<Class> relatedClasses = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "level")
    private Set<SubjectInfo> subjectInfos = new HashSet<>();

    public Level(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Level level = (Level) o;
        return Objects.equals(id, level.id) && Objects.equals(name, level.name) && Objects.equals(category, level.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
