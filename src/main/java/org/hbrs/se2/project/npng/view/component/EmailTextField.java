package org.hbrs.se2.project.npng.view.component;

import com.vaadin.flow.component.textfield.EmailField;

public class EmailTextField extends EmailField {
    public EmailTextField(String untertitel){
        this.setHeight("56px");
        this.setWidth("30vw");
        this.setPlaceholder(untertitel);
    }
}