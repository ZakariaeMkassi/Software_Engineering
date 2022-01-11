package org.hbrs.se2.project.npng.dto.impl;

import org.hbrs.se2.project.npng.dto.CompanyDTO;

public class CompanyDTOImpl implements CompanyDTO{

    private String name;
    private String sector;
    private String headOffice;
    private String numberOfEmployee;
    private String foundingYear;
    private int numberOfLocations;

    public String getName() {
        return name;
    }

    public String getSector() {
        return sector;
    }

    public String getHeadOffice() {
        return headOffice;
    }

    public String getNumberOfEmployee() {
        return numberOfEmployee;
    }

    public String getFoundingYear() {
        return foundingYear;
    }

    public int getNumberOfLocations() {
        return numberOfLocations;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public void setHeadOffice(String headOffice) {
        this.headOffice = headOffice;
    }

    public void setNumberOfEmployee(String numberOfEmployee) {
        this.numberOfEmployee = numberOfEmployee;
    }

    public void setFoundingYear(String foundingYear) {
        this.foundingYear = foundingYear;
    }

    public void setNumberOfLocations(int numberOfLocations) {
        this.numberOfLocations = numberOfLocations;
    }
}
