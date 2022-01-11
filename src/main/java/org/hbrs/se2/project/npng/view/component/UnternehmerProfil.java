package org.hbrs.se2.project.npng.view.component;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import org.hbrs.se2.project.npng.entity.Company;
import org.hbrs.se2.project.npng.entity.User;
import org.hbrs.se2.project.npng.util.Globals;

@CssImport("./themes/nopainnogain/components/ProfilBearbeiten.css")

public class UnternehmerProfil extends VerticalLayout {

    private TextField unternehmername = new TextField("Unternehmensname");
    private EmailField email = new EmailField("E-Mail Adresse");
    private TextField phone = new TextField("Telefonnummer");
    private TextField adresse = new TextField("Straße und Hausnummer");
    private TextField postleitzahl = new TextField("Postleitzahl");
    private TextField ort = new TextField("Ort");
    private TextField branche = new TextField("Branche");
    private TextField Hauptsitz = new TextField("Hauptsitz");
    private TextField anzahl_Angestellten = new TextField("Anzahl der Angestellten");
    private TextField gruendungsjahr = new TextField("Gründungsjahr");
    private Button cancel = new Button("Zurück");
    private Button save = new Button("Speichern");

    private User user = (User) UI.getCurrent().getSession().getAttribute(Globals.CURRENT_USER);
    private Company company = user.getCompany();


    public UnternehmerProfil(){
        FormLayout layout_1 = new FormLayout();
        layout_1.getStyle().set("margin-left", "25vw");
        layout_1.getStyle().set("margin-right", "25vw");
        layout_1.add(unternehmername, email);
        layout_1.add(phone, 2);
        layout_1.add(adresse, 2);
        layout_1.add(postleitzahl, ort);
        layout_1.add(Hauptsitz, anzahl_Angestellten,gruendungsjahr,branche);
        getCancel().setId("cancel_save");
        getSave().setId("cancel_save");
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.add(getCancel(),getSave());
        layout_1.add(horizontalLayout);
        add(layout_1);
    }

    // Getter & Setter:
    public TextField getHauptsitz() {
        return Hauptsitz;
    }

    public void setHauptsitz(TextField hauptsitz) {
        Hauptsitz = hauptsitz;
    }

    public TextField getAnzahl_Angestellten() {
        return anzahl_Angestellten;
    }

    public void setAnzahl_Angestellten(TextField anzahl_Angestellten) {
        this.anzahl_Angestellten = anzahl_Angestellten;
    }

    public TextField getGruendungsjahr() {
        return gruendungsjahr;
    }

    public void setGruendungsjahr(TextField gruendungsjahr) {
        this.gruendungsjahr = gruendungsjahr;
    }
    public TextField getUnternehmername() {
        return unternehmername;
    }

    public User getUser() {
        return user;
    }

    public Company getCompany() {
        return company;
    }

    public void setUnternehmername(TextField unternehmername) {
        this.unternehmername = unternehmername;
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

    public TextField getBranche() {
        return branche;
    }

    public void setBranche(TextField branche) {
        this.branche = branche;
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
