package com.sensycry.sensycry_api.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Person {
  private Integer id;
  private String firstName;
  private String surname;
  private String lastName;
  private String phoneNumber;
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
  @Column(name = "first_name")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @Basic
  @Column(name = "surname")
  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  @Basic
  @Column(name = "last_name")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Basic
  @Column(name = "phone_number")
  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Person person = (Person) o;

    if (id != null ? !id.equals(person.id) : person.id != null) {
      return false;
    }
    if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null) {
      return false;
    }
    if (surname != null ? !surname.equals(person.surname) : person.surname != null) {
      return false;
    }
    if (lastName != null ? !lastName.equals(person.lastName) : person.lastName != null) {
      return false;
    }
    return phoneNumber != null ? phoneNumber.equals(person.phoneNumber) :
        person.phoneNumber == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + (surname != null ? surname.hashCode() : 0);
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
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
