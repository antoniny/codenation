package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String name;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String slug;

    @OneToMany
    private List<Acceleration> accelerations;

    @OneToMany
    private List<Submission> submissions;

    @NotNull
    @CreatedDate
    private Timestamp createdAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Challenge challenge = (Challenge) o;

        if (id != challenge.id) return false;
        if (name != null ? !name.equals(challenge.name) : challenge.name != null) return false;
        if (slug != null ? !slug.equals(challenge.slug) : challenge.slug != null) return false;
        return createdAt != null ? createdAt.equals(challenge.createdAt) : challenge.createdAt == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (slug != null ? slug.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        return result;
    }
}
