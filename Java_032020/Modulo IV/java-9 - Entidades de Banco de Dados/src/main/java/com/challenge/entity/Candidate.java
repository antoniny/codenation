package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class Candidate {

    @EmbeddedId
    private CandidateIdentity candidateIdentity;

    @NotNull
    private int status;

    @NotNull
    @CreatedDate
    private Timestamp createdAt;

    public CandidateIdentity getCandidateIdentity() {
        return candidateIdentity;
    }

    public void setCandidateIdentity(CandidateIdentity candidateIdentity) {
        this.candidateIdentity = candidateIdentity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getCreated_at() {
        return createdAt;
    }

    public void setCreated_at(Timestamp created_at) {
        this.createdAt = created_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Candidate candidate = (Candidate) o;

        if (status != candidate.status) return false;
        if (candidateIdentity != null ? !candidateIdentity.equals(candidate.candidateIdentity) : candidate.candidateIdentity != null)
            return false;
        return createdAt != null ? createdAt.equals(candidate.createdAt) : candidate.createdAt == null;
    }

    @Override
    public int hashCode() {
        int result = candidateIdentity != null ? candidateIdentity.hashCode() : 0;
        result = 31 * result + status;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        return result;
    }
}
