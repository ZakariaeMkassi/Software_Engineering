package org.hbrs.se2.project.npng.dto.impl;

import org.hbrs.se2.project.npng.dto.JobAdvertismentDTO;

import java.time.LocalDate;

public class JobAdvertismentDTOImpl implements JobAdvertismentDTO {

    private String title;
    private String sector;
    private String type_of_job_hiring;
    private LocalDate date;
    private String description;


    public String getTitle() {
        return title;
    }

    public String getSector() {
        return sector;
    }

    public String getTypOfJobHiring() {
        return type_of_job_hiring;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public void setType_of_job_hiring(String type_of_job_hiring) {
        this.type_of_job_hiring = type_of_job_hiring;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
