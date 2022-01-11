package org.hbrs.se2.project.npng.view.component;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import org.hbrs.se2.project.npng.entity.Student;
import org.hbrs.se2.project.npng.entity.User;
import org.hbrs.se2.project.npng.util.Globals;
import org.hbrs.se2.project.npng.view.StudentProfilView;

@CssImport("./themes/nopainnogain/components/ProfilBearbeiten.css")

public class StudentProfil extends VerticalLayout {

    private TextField vorname = new TextField("Vorname");
    private TextField nachname = new TextField("Nachname");
    private ComboBox<String> geschlicht = new ComboBox<>("Geschlecht");
    private DatePicker geburtsdatum = new DatePicker("Geburtsdatum");
    private EmailField email = new EmailField("E-Mail Adresse");
    private TextField phone = new TextField("Mobile-Nummer");
    private TextField mobile = new TextField("Mobilenummer");
    private TextField studium = new TextField("Studium");
    private TextField hoechster_abschluss = new TextField("Höchster Abschluss");
    private TextField adresse = new TextField("Straße und Hausnummer");
    private TextField postleitzahl = new TextField("Postleitzahl");
    private TextField ort = new TextField("Ort");
    private Button cancel = new Button("Zurück");
    private Button save = new Button("Speichern");
    private User user = (User) UI.getCurrent().getSession().getAttribute(Globals.CURRENT_USER);
    private Student student = user.getStudent();

    public StudentProfil(){

        FormLayout layout_1 = new FormLayout();
        layout_1.getStyle().set("margin-left", "25vw");
        layout_1.getStyle().set("margin-right", "25vw");

        // Persönlische Angaben:
        getGeschlicht().setItems("Mann","Frau");
        layout_1.add(getVorname(), getNachname(), getGeschlicht(), getGeburtsdatum());
        layout_1.add(getEmail(), 2);
        layout_1.add(getPhone(),2);
        layout_1.add(getAdresse(), 2);
        layout_1.add(getPostleitzahl(), getOrt());
        layout_1.add(getStudium(),2);
        layout_1.add(getHoechster_abschluss(),2);
        layout_1.setResponsiveSteps(
                new FormLayout.ResponsiveStep("1px", 1),
                new FormLayout.ResponsiveStep("1px", 2));

        // Button:
        HorizontalLayout layout_B = new HorizontalLayout();
        getCancel().addClickListener(e -> UI.getCurrent().navigate(StudentProfilView.class));
        getCancel().setId("cancel_save");
        getSave().setId("cancel_save");
        layout_B.add(getCancel(),getSave());
        layout_1.add(layout_B);
        add(layout_1);
    }



    public TextField getVorname() {
        return vorname;
    }
    public User getUser() {
        return user;
    }
    public Student getStudent() {
        return student;
    }
    public void setVorname(TextField vorname) {
        this.vorname = vorname;
    }

    public TextField getNachname() {
        return nachname;
    }

    public void setNachname(TextField nachname) {
        this.nachname = nachname;
    }

    public ComboBox<String> getGeschlicht() {
        return geschlicht;
    }

    public void setGeschlicht(ComboBox<String> geschlicht) {
        this.geschlicht = geschlicht;
    }

    public DatePicker getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(DatePicker geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public EmailField getEmail() {
        return email;
    }

    public void setEmail(EmailField email) {
        this.email = email;
    }

    public TextField getPhone() {
        return phone;
    }

    public void setPhone(TextField phone) {
        this.phone = phone;
    }

    public TextField getMobile() {
        return mobile;
    }

    public void setMobile(TextField mobile) {
        this.mobile = mobile;
    }

    public TextField getStudium() {
        return studium;
    }

    public void setStudium(TextField studium) {
        this.studium = studium;
    }

    public TextField getHoechster_abschluss() {
        return hoechster_abschluss;
    }

    public void setHoechster_abschluss(TextField hoechster_abschluss) {
        this.hoechster_abschluss = hoechster_abschluss;
    }

    public TextField getAdresse() {
        return adresse;
    }

    public void setAdresse(TextField adresse) {
        this.adresse = adresse;
    }

    public TextField getPostleitzahl() {
        return postleitzahl;
    }

    public void setPostleitzahl(TextField postleitzahl) {
        this.postleitzahl = postleitzahl;
    }

    public TextField getOrt() {
        return ort;
    }

    public void setOrt(TextField ort) {
        this.ort = ort;
    }

    public Button getCancel() {
        return cancel;
    }

    public void setCancel(Button cancel) {
        this.cancel = cancel;
    }

    public Button getSave() {
        return save;
    }

    public void setSave(Button save) {
        this.save = save;
    }




}
