package org.hbrs.se2.project.npng.dto.impl;

import org.hbrs.se2.project.npng.dto.StudentDTO;

import java.time.LocalDate;

public class StudentDTOImpl implements StudentDTO {

    private String firstName;
    private String lastName;
    private String highestDiploma;
    private String education;
    private LocalDate birthday;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getHighestDiploma() {
        return highestDiploma;
    }

    public String getEducation() {
        return education;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setHighestDiploma(String highestDiploma) {
        this.highestDiploma = highestDiploma;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }


}
