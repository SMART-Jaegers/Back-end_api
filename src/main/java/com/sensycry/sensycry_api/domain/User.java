package com.sensycry.sensycry_api.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Set;

@Entity
public class User {
  private Integer id;
  private String username;
  private String email;
  private Password passwordByPasswordId;
  private Set<District> districts;

  @Id
  @Column(name = "id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Basic
  @Column(name = "username")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @Basic
  @Column(name = "email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    User user = (User) o;

    if (id != null ? !id.equals(user.id) : user.id != null) {
      return false;
    }
    if (username != null ? !username.equals(user.username) : user.username != null) {
      return false;
    }
    return email != null ? email.equals(user.email) : user.email == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (username != null ? username.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    return result;
  }

  @ManyToOne
  @JoinColumn(name = "password_id", referencedColumnName = "id", nullable = false)
  public Password getPasswordByPasswordId() {
    return passwordByPasswordId;
  }

  public void setPasswordByPasswordId(Password passwordByPasswordId) {
    this.passwordByPasswordId = passwordByPasswordId;
  }

  @ManyToMany
  @JoinTable(
      name = "access_level",
      catalog = "",
      schema = "sensycry_db",
      joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false),
      inverseJoinColumns =
          @JoinColumn(name = "district_id", referencedColumnName = "id", nullable = false))
  public Set<District> getDistricts() {
    return districts;
  }

  public void setDistricts(Set<District> districts) {
    this.districts = districts;
  }
}
