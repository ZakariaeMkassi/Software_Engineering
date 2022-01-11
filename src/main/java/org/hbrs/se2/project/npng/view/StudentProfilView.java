package org.hbrs.se2.project.npng.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.hbrs.se2.project.npng.view.component.StudentProfil;
import org.hbrs.se2.project.npng.view.layoutview.StudentLayoutview;


@Route(value = "StudentProfil", layout = StudentLayoutview.class)
@PageTitle("No-Pain_No-Gain")


public class StudentProfilView extends StudentProfil {

    public StudentProfilView(){

        getVorname().setValue(getStudent().getFirstName());
        getNachname().setValue(getStudent().getLastName());
        getGeschlicht().setValue(getUser().getGeschlecht());
        getGeburtsdatum().setValue(getStudent().getBirthday());
        getEmail().setValue(getUser().getMail());
        getPhone().setValue(getUser().getPhone());
        getAdresse().setValue(getUser().getStreet());
        getPostleitzahl().setValue(getUser().getPlz());
        getOrt().setValue(getUser().getCity());
        getStudium().setValue(getStudent().getStudyCourse());
        getHoechster_abschluss().setValue(getStudent().getHighestDiploma());

        getVorname().setReadOnly(true);
        getNachname().setReadOnly(true);
        getGeschlicht().setReadOnly(true);
        getGeburtsdatum().setReadOnly(true);
        getEmail().setReadOnly(true);
        getPhone().setReadOnly(true);
        getMobile().setReadOnly(true);
        getAdresse().setReadOnly(true);
        getPostleitzahl().setReadOnly(true);
        getOrt().setReadOnly(true);
        getStudium().setReadOnly(true);
        getHoechster_abschluss().setReadOnly(true);
        getSave().setText("Profil bearbeiten");
        getCancel().addClickListener(e -> UI.getCurrent().navigate(StudentView.class));
        getSave().addClickListener(e -> navigateToStudentProfilBearbeitenView());

    }

    private void navigateToStudentProfilBearbeitenView(){
        UI.getCurrent().navigate(StudentProfilBearbeitenView.class);
    }
}