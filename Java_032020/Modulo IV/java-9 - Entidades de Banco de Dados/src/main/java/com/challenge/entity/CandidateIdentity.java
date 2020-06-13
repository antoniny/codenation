package com.challenge.entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class CandidateIdentity implements Serializable {

    @ManyToOne
    @NotNull
    private User user;

    @ManyToOne
    @NotNull
    private Acceleration acceleration;

    @ManyToOne
    @NotNull
    private Company company;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CandidateIdentity that = (CandidateIdentity) o;

        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (acceleration != null ? !acceleration.equals(that.acceleration) : that.acceleration != null) return false;
        return company != null ? company.equals(that.company) : that.company == null;
    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (acceleration != null ? acceleration.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        return result;
    }
}
