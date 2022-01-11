package org.hbrs.se2.project.npng.dto.impl;

import org.hbrs.se2.project.npng.dto.SkillsDTO;

public class SkillsDTOImpl implements SkillsDTO{


    private String name;
    private int grade;


    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

}
