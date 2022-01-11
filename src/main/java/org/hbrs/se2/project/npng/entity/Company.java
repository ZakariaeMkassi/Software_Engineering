package org.hbrs.se2.project.npng.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company", schema = "coll", catalog = "zmkass2s")
public class Company {
    private int id;
    private String name;
    private String sector;
    private String headOffice;
    private Integer numberOfEmployee;
    private String foundingYear;
    private Integer numberOfLocations;
    private User user;
    private List<JobAdvertisement> jobAdvertisements;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "sector")
    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    @Basic
    @Column(name = "head_office")
    public String getHeadOffice() {
        return headOffice;
    }

    public void setHeadOffice(String headOffice) {
        this.headOffice = headOffice;
    }

    @Basic
    @Column(name = "number_of_employee")
    public Integer getNumberOfEmployee() {
        return numberOfEmployee;
    }

    public void setNumberOfEmployee(Integer numberOfEmployee) {
        this.numberOfEmployee = numberOfEmployee;
    }

    @Basic
    @Column(name = "founding_year")
    public String getFoundingYear() {
        return foundingYear;
    }

    public void setFoundingYear(String foundingYear) {
        this.foundingYear = foundingYear;
    }

    @Basic
    @Column(name = "number_of_locations")
    public Integer getNumberOfLocations() {
        return numberOfLocations;
    }

    public void setNumberOfLocations(Integer numberOfLocations) {
        this.numberOfLocations = numberOfLocations;
    }

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToMany(mappedBy = "company")
    public List<JobAdvertisement> getJobAdvertisements() {
        return this.jobAdvertisements;
    }

    public void setJobAdvertisements(List<JobAdvertisement> JobAdvertisements) {
        this.jobAdvertisements= JobAdvertisements;
    }
    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (id != company.id) return false;
        if (name != null ? !name.equals(company.name) : company.name != null) return false;
        if (sector != null ? !sector.equals(company.sector) : company.sector != null) return false;
        if (headOffice != null ? !headOffice.equals(company.headOffice) : company.headOffice != null) return false;
        if (numberOfEmployee != null ? !numberOfEmployee.equals(company.numberOfEmployee) : company.numberOfEmployee != null)
            return false;
        if (foundingYear != null ? !foundingYear.equals(company.foundingYear) : company.foundingYear != null)
            return false;
        if (numberOfLocations != null ? !numberOfLocations.equals(company.numberOfLocations) : company.numberOfLocations != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sector != null ? sector.hashCode() : 0);
        result = 31 * result + (headOffice != null ? headOffice.hashCode() : 0);
        result = 31 * result + (numberOfEmployee != null ? numberOfEmployee.hashCode() : 0);
        result = 31 * result + (foundingYear != null ? foundingYear.hashCode() : 0);
        result = 31 * result + (numberOfLocations != null ? numberOfLocations.hashCode() : 0);
        return result;
    }

     */
}
