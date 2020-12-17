package com.sensycry.sensycry_api.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Set;

@Entity
public class District {
    private Integer id;
    private String state;
    private String city;
    private String district;
    private String country;
    private Set<Apartment> apartmentsById;
    private Set<User> users;
    
    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Basic
    @Column(name = "state")
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    @Basic
    @Column(name = "district")
    public String getDistrict() {
        return district;
    }
    
    public void setDistrict(String district) {
        this.district = district;
    }
    
    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        District district1 = (District) o;
        
        if (id != null ? !id.equals(district1.id) : district1.id != null) {
            return false;
        }
        if (state != null ? !state.equals(district1.state) : district1.state != null) {
            return false;
        }
        if (city != null ? !city.equals(district1.city) : district1.city != null) {
            return false;
        }
        if (district != null ? !district.equals(district1.district) : district1.district != null) {
            return false;
        }
        if (country != null ? !country.equals(district1.country) : district1.country != null) {
            return false;
        }
        
        return true;
    }
    
    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (district != null ? district.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }
    
    @OneToMany(mappedBy = "district")
    public Set<Apartment> getApartmentsById() {
        return apartmentsById;
    }
    
    public void setApartmentsById(Set<Apartment> apartmentsById) {
        this.apartmentsById = apartmentsById;
    }
    
    @ManyToMany(mappedBy = "districts")
    public Set<User> getUsers() {
        return users;
    }
    
    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
