package org.hbrs.se2.project.npng.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.router.PageTitle;
import org.hbrs.se2.project.npng.view.layoutview.StartSeiteLayout;


@Route(value = "Startseite", layout = StartSeiteLayout.class)
@RouteAlias(value ="", layout = StartSeiteLayout.class)
@PageTitle("No-Pain_No-Gain")
@CssImport("./themes/nopainnogain/components/Startseite.css")



public class StartseiteView extends VerticalLayout{

    private Button unternehmerRegistrieren;
    private Button studentRgistrieren;
    private Button login;
    private H1 h1;

    public StartseiteView() {

        setMargin(true);
        //paragraph1 erstellen:

        Paragraph paragraph1 = new Paragraph();
        paragraph1.setText("Ihre Webseite, damit Sie schnell einen Job finden :)");
        //image erstellen:
        Paragraph paragraph2 = new Paragraph();
        paragraph2.setText(" Sind Sie Student, oder Unternehmer, dann registrieren Sie sich und starten " +
                "Sie mit No-Pain_No-Gain." +
                " Als Student könnten Sie für Sie passende Anzeigen finden und mit einfachen" +
                "Schritten Ihre Bewerbung schicken. " +
                "Als Unternehmer können Sie Anzeigen mit einfachen Schritten online erstellen " +
                "und Bewerbungen von Studenten unserer Hochschule Bonn-Rhein-Sieg erhalten. " +
                "Darüberhinaus bieten wir noch viele weitere Funktionen." +
                "Nutzen Sie die Chance und entdecken Sie No-Pain_No-Gain.");

        paragraph1.setId("paragraph");

        // Image erstellen:
        Image image = new Image();
        image.setSrc("images/NpNg.png");
        image.setAlt("Logo");
        image.setId("image");
        //Layout für paragraph & ImageUndTitle erstellen:

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.add(paragraph2, image);
        add(paragraph1, horizontalLayout);
        // Button's erstellen:
        // Für Unternehmer:
        unternehmerRegistrieren = new Button("Unternehmer registrieren");
        unternehmerRegistrieren.addClickListener(e -> {
            navigateToRegisterUnternehmerView();
                });
        unternehmerRegistrieren.setClassName("Button");
        // Für Student:
        studentRgistrieren = new Button("Student registrieren");
        studentRgistrieren.addClickListener(e -> {
            navigateToRegisterStudentView();
        });
        studentRgistrieren.setClassName("Button");
        // Für Login:
        login = new Button("Login");
        login.addClickListener(e -> {
            navigateToLogin();
        });
        login.setClassName("Button");

        add(unternehmerRegistrieren, studentRgistrieren, login);
    }


    private void navigateToRegisterUnternehmerView(){
        UI.getCurrent().navigate(RegisterUnternehmerView.class);
    }
    private void navigateToRegisterStudentView(){
        UI.getCurrent().navigate(RegisterStudentView.class);
    }
    private void navigateToLogin(){
        UI.getCurrent().navigate(LoginView.class);
    }
}