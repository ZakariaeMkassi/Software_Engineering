package org.hbrs.se2.project.npng.entity;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "job_advertisement", schema = "coll", catalog = "zmkass2s")
public class JobAdvertisement {
    private int id;
    private String title;
    private String sector;
    private String typeOfJobHiring;
    private LocalDate startDate;
    private String description;
    private int company_id;
    private List<ApplicationLetter> applicationLetters;
    private List<Skills> skills;
    private Company company;
    private int anzahl_bewerbungen;

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
    @Column(name = "anzahl_bewerbungen")
    public int getAnzahl_bewerbungen(){
        return anzahl_bewerbungen;
    }
    public void setAnzahl_bewerbungen(int i){
        anzahl_bewerbungen = i;
    }


    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
    @Column(name = "type_of_job_hiring")
    public String getTypeOfJobHiring() {
        return typeOfJobHiring;
    }

    public void setTypeOfJobHiring(String typeOfJobHiring) {
        this.typeOfJobHiring = typeOfJobHiring;
    }

    @Basic
    @Column(name = "start_date")
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }





    @OneToMany(mappedBy = "jobAdvertisement")
    public List<ApplicationLetter> getApplicationLetters() {
        return applicationLetters;
    }

    public void setApplicationLetters(List<ApplicationLetter> applicationLetters) {
        this.applicationLetters = applicationLetters;
    }

    @OneToMany(mappedBy = "jobAdvertisement")
    public List<Skills> getSkills() {
        return skills;
    }

    public void setSkills (List<Skills> skills) {
        this.skills = skills;
    }

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id", nullable = false)
    public Company getCompany(){ return this.company; };

    public void setCompany(Company company){ this.company = company; };


}
