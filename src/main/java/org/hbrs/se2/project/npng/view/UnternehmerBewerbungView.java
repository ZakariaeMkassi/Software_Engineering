package org.hbrs.se2.project.npng.view;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.hbrs.se2.project.npng.view.layoutview.StudentLayoutview;

@Route(value = "UnternehmerBewerbungView",layout = StudentLayoutview.class)
@PageTitle("No-Pain_No-Gain")
@CssImport("./themes/nopainnogain/components/ProfilBearbeiten.css")

public class UnternehmerBewerbungView extends VerticalLayout {

    private TextField vorname = new TextField("Vorname");
    private TextField nachname = new TextField("Nachname");
    private TextField geschlicht = new TextField("Geschlecht");
    private DatePicker geburtsdatum = new DatePicker("Geburtsdatum");
    private EmailField email = new EmailField("E-Mail Adresse");
    private TextField phone = new TextField("Mobile-Nummer");
    private TextField studium = new TextField("Studium");
    private TextField hoechster_abschluss = new TextField("Höchster Abschluss");
    private TextField adresse = new TextField("Straße und Hausnummer");
    private TextField postleitzahl = new TextField("Postleitzahl");
    private TextField ort = new TextField("Ort");


}
