package org.hbrs.se2.project.npng.dto.impl;

import org.hbrs.se2.project.npng.dto.ApplicationLetterDTO;

public class ApplicationLetterDTOImpl implements ApplicationLetterDTO {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
