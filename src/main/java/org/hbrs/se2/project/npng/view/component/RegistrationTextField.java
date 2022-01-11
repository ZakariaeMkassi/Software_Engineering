package org.hbrs.se2.project.npng.view.component;

import com.vaadin.flow.component.textfield.TextField;

public class RegistrationTextField extends TextField {

    public RegistrationTextField(String untertitel){

        this.setHeight("56px");
        this.setWidth("30vw");
        this.setPlaceholder(untertitel);
    }
}