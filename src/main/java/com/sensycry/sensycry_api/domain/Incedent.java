package com.sensycry.sensycry_api.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
public class Incedent {
  private Integer id;
  private Timestamp date;
  private Time duringTime;
  private Byte aggresionHappend;
  private BigDecimal accuracy;
  private String nameRecord;
  private String pathRecord;
  private String size;
  private Apartment apartmentByFamilyId;

  @Id
  @Column(name = "id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Basic
  @Column(name = "date")
  public Timestamp getDate() {
    return date;
  }

  public void setDate(Timestamp date) {
    this.date = date;
  }

  @Basic
  @Column(name = "during_time")
  public Time getDuringTime() {
    return duringTime;
  }

  public void setDuringTime(Time duringTime) {
    this.duringTime = duringTime;
  }

  @Basic
  @Column(name = "aggresion_happend")
  public Byte getAggresionHappend() {
    return aggresionHappend;
  }

  public void setAggresionHappend(Byte aggresionHappend) {
    this.aggresionHappend = aggresionHappend;
  }

  @Basic
  @Column(name = "accuracy")
  public BigDecimal getAccuracy() {
    return accuracy;
  }

  public void setAccuracy(BigDecimal accuracy) {
    this.accuracy = accuracy;
  }

  @Basic
  @Column(name = "name_record")
  public String getNameRecord() {
    return nameRecord;
  }

  public void setNameRecord(String nameRecord) {
    this.nameRecord = nameRecord;
  }

  @Basic
  @Column(name = "path_record")
  public String getPathRecord() {
    return pathRecord;
  }

  public void setPathRecord(String pathRecord) {
    this.pathRecord = pathRecord;
  }

  @Basic
  @Column(name = "size")
  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Incedent incedent = (Incedent) o;

    if (id != null ? !id.equals(incedent.id) : incedent.id != null) {
      return false;
    }
    if (date != null ? !date.equals(incedent.date) : incedent.date != null) {
      return false;
    }
    if (duringTime != null
        ? !duringTime.equals(incedent.duringTime)
        : incedent.duringTime != null) {
      return false;
    }
    if (aggresionHappend != null
        ? !aggresionHappend.equals(incedent.aggresionHappend)
        : incedent.aggresionHappend != null) {
      return false;
    }
    if (accuracy != null ? !accuracy.equals(incedent.accuracy) : incedent.accuracy != null) {
      return false;
    }
    if (nameRecord != null
        ? !nameRecord.equals(incedent.nameRecord)
        : incedent.nameRecord != null) {
      return false;
    }
    if (pathRecord != null
        ? !pathRecord.equals(incedent.pathRecord)
        : incedent.pathRecord != null) {
      return false;
    }
      return size != null ? size.equals(incedent.size) : incedent.size == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (date != null ? date.hashCode() : 0);
    result = 31 * result + (duringTime != null ? duringTime.hashCode() : 0);
    result = 31 * result + (aggresionHappend != null ? aggresionHappend.hashCode() : 0);
    result = 31 * result + (accuracy != null ? accuracy.hashCode() : 0);
    result = 31 * result + (nameRecord != null ? nameRecord.hashCode() : 0);
    result = 31 * result + (pathRecord != null ? pathRecord.hashCode() : 0);
    result = 31 * result + (size != null ? size.hashCode() : 0);
    return result;
  }

  @ManyToOne
  @JoinColumn(name = "family_id", referencedColumnName = "family_id", nullable = false)
  public Apartment getApartmentByFamilyId() {
    return apartmentByFamilyId;
  }

  public void setApartmentByFamilyId(Apartment apartmentByFamilyId) {
    this.apartmentByFamilyId = apartmentByFamilyId;
  }
}
