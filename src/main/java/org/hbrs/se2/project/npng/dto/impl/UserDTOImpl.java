package org.hbrs.se2.project.npng.dto.impl;

import org.hbrs.se2.project.npng.dto.UserDTO;

public class UserDTOImpl implements UserDTO {

    private String contactMail;
    private String role;

    public String getContactMail() {
        return contactMail;
    }

    public String getRole() {
        return role;
    }

    public void setContactMail(String contactMail) {
        this.contactMail = contactMail;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
