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
public class Submission {

    @EmbeddedId
    private SubmissionIdentity submissionIdentity;

    @NotNull
    private Float score;

    @NotNull
    @CreatedDate
    private Timestamp createdAt;

    public SubmissionIdentity getSubmissionIdentity() {
        return submissionIdentity;
    }

    public void setSubmissionIdentity(SubmissionIdentity submissionIdentity) {
        this.submissionIdentity = submissionIdentity;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Timestamp getCreated_ad() {
        return createdAt;
    }

    public void setCreated_ad(Timestamp created_ad) {
        this.createdAt = created_ad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Submission that = (Submission) o;

        if (submissionIdentity != null ? !submissionIdentity.equals(that.submissionIdentity) : that.submissionIdentity != null)
            return false;
        if (score != null ? !score.equals(that.score) : that.score != null) return false;
        return createdAt != null ? createdAt.equals(that.createdAt) : that.createdAt == null;
    }

    @Override
    public int hashCode() {
        int result = submissionIdentity != null ? submissionIdentity.hashCode() : 0;
        result = 31 * result + (score != null ? score.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        return result;
    }
}
