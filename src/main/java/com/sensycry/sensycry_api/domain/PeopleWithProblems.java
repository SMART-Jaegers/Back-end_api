package com.sensycry.sensycry_api.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "people_with_problems", schema = "sensycry_db", catalog = "")
public class PeopleWithProblems {
    private Integer personId;
    private String conviction;
    private Date courtDate;
    private Person personByPersonId;
    
    @Id
    @Column(name = "person_id")
    public Integer getPersonId() {
        return personId;
    }
    
    public void setPersonId(Integer personId) {
        this.personId = personId;
    }
    
    @Basic
    @Column(name = "conviction")
    public String getConviction() {
        return conviction;
    }
    
    public void setConviction(String conviction) {
        this.conviction = conviction;
    }
    
    @Basic
    @Column(name = "court_date")
    public Date getCourtDate() {
        return courtDate;
    }
    
    public void setCourtDate(Date courtDate) {
        this.courtDate = courtDate;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        PeopleWithProblems that = (PeopleWithProblems) o;
        
        if (personId != null ? !personId.equals(that.personId) : that.personId != null) {
            return false;
        }
        if (conviction != null ? !conviction.equals(that.conviction) : that.conviction != null) {
            return false;
        }
        if (courtDate != null ? !courtDate.equals(that.courtDate) : that.courtDate != null) {
            return false;
        }
        
        return true;
    }
    
    @Override
    public int hashCode() {
        int result = personId != null ? personId.hashCode() : 0;
        result = 31 * result + (conviction != null ? conviction.hashCode() : 0);
        result = 31 * result + (courtDate != null ? courtDate.hashCode() : 0);
        return result;
    }
    
    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id", nullable = false)
    public Person getPersonByPersonId() {
        return personByPersonId;
    }
    
    public void setPersonByPersonId(Person personByPersonId) {
        this.personByPersonId = personByPersonId;
    }
}
