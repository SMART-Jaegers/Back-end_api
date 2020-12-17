package com.sensycry.sensycry_api.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Apartment {
    private Integer familyId;
    private String address;
    private Set<Device> devices;
    private District district;
    private Set<Incedent> incedents;
    private Set<Person> people;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "family_id")
    public Integer getFamilyId() {
        return familyId;
    }
    
    public void setFamilyId(Integer familyId) {
        this.familyId = familyId;
    }
    
    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        Apartment apartment = (Apartment) o;
        
        if (familyId != null ? !familyId.equals(apartment.familyId) : apartment.familyId != null) {
            return false;
        }
        if (address != null ? !address.equals(apartment.address) : apartment.address != null) {
            return false;
        }
        
        return true;
    }
    
    @Override
    public int hashCode() {
        int result = familyId != null ? familyId.hashCode() : 0;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
    
    @OneToMany(mappedBy = "apartment")
    public Set<Device> getDevices() {
        return devices;
    }
    
    public void setDevices(Set<Device> devices) {
        this.devices = devices;
    }
    
    @ManyToOne
    @JoinColumn(name = "district_id", referencedColumnName = "id",
        nullable = false)
    public District getDistrict() {
        return district;
    }
    
    public void setDistrict(District districtByDistrictId) {
        this.district = districtByDistrictId;
    }
    
    @OneToMany(mappedBy = "apartmentByFamilyId")
    public Set<Incedent> getIncedents() {
        return incedents;
    }
    
    public void setIncedents(
        Set<Incedent> incedentsByFamilyId) {
        this.incedents = incedentsByFamilyId;
    }
    
    @OneToMany(mappedBy = "apartmentByFamilyId")
    public Set<Person> getPeople() {
        return people;
    }
    
    public void setPeople(Set<Person> peopleByFamilyId) {
        this.people = peopleByFamilyId;
    }
}
