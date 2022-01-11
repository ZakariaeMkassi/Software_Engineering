package org.hbrs.se2.project.npng.view;


import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.hbrs.se2.project.npng.entity.*;
import org.hbrs.se2.project.npng.repository.ApplicationletterRepository;
import org.hbrs.se2.project.npng.repository.CompanyRepository;
import org.hbrs.se2.project.npng.repository.JobAdvertisementRepository;
import org.hbrs.se2.project.npng.util.Globals;
import org.hbrs.se2.project.npng.view.layoutview.CompanyLayoutView;

import java.util.ArrayList;
import java.util.List;


@Route(value = "UnternehmerView",layout = CompanyLayoutView.class)
@PageTitle("No-Pain_No-Gain")
@CssImport("./themes/nopainnogain/components/ProfilBearbeiten.css")

public class CompanyView extends VerticalLayout {

    private TextField title = new TextField("Titel");
    private TextField sector = new TextField("Branche");
    private TextField art = new TextField("Art der Anzeige");
    DatePicker datum = new DatePicker("Anfangsdatum");
    TextArea textArea = new TextArea("Beschreibeung");
    private Button cancel = new Button("Zurück");
    private Button save = new Button("Online erstellen");

    private Dialog dialog1 = new Dialog();
    private Dialog dialog2 = new Dialog();
    private Dialog dialog3 = new Dialog();
    private Dialog dialog4 = new Dialog();

    private Dialog dialogloschen1 = new Dialog();
    private Dialog dialogloschen12 = new Dialog();

    private Dialog dialoganza1 = new Dialog();
    private Dialog dialoganza2 = new Dialog();
    private Dialog dialoganza3 = new Dialog();

    private Dialog dialogan = new Dialog();

    private Dialog dialogbewerbung = new Dialog();
    private Dialog dialogbewerbung2 = new Dialog();


    private TextField title1 = new TextField("Titel");
    private TextField sector1 = new TextField("Branche");
    private TextField art1 = new TextField("Art der Anzeige");
    DatePicker datum1 = new DatePicker("Anfangsdatum");
    TextArea textArea1 = new TextArea("Beschreibeung");
    private Button loschen = new Button("löschen");
    private Button anzeigeandern = new Button("Anzeige bearbeiten");
    private Button bewerbungrnanschauen = new Button("Bewerbungen anschauen");
    Paragraph info = new Paragraph();

    private TextField title2 = new TextField("Titel");
    private TextField sector2 = new TextField("Branche");
    private TextField art2 = new TextField("Art der Anzeige");
    DatePicker datum2 = new DatePicker("Anfangsdatum");
    TextArea textArea2 = new TextArea("Beschreibeung");

    private TextArea textArea3 = new TextArea();

    private TextField vorname = new TextField("Vorname");
    private TextField nachname = new TextField("Nachname");
    private TextField geschlicht = new TextField("Geschlecht");
    private DatePicker geburtsdatum = new DatePicker("Geburtsdatum");
    private EmailField email = new EmailField("E-Mail Adresse");
    private TextField phone = new TextField("Mobile-Nummer");
    private TextField mobile = new TextField("Mobilenummer");
    private TextField studium = new TextField("Studium");
    private TextField hoechster_abschluss = new TextField("Höchster Abschluss");
    private TextField adresse = new TextField("Straße und Hausnummer");
    private TextField postleitzahl = new TextField("Postleitzahl");
    private TextField ort = new TextField("Ort");


    private User user = (User) UI.getCurrent().getSession().getAttribute(Globals.CURRENT_USER);
    private Company company = user.getCompany();
    private Student student = new Student();
    private User userstudent = new User();
    private JobAdvertisement jobAdvertisement = new JobAdvertisement();
    private JobAdvertisementRepository jobAdvertisementRepository;
    private ApplicationletterRepository applicationletterRepository;
    private CompanyRepository companyRepository;


    public CompanyView(JobAdvertisementRepository jobAdvertisementRepository, CompanyRepository companyRepository, ApplicationletterRepository applicationletterRepository){

        this.jobAdvertisementRepository = jobAdvertisementRepository;
        this.applicationletterRepository = applicationletterRepository;
        this.companyRepository = companyRepository;
        //----------Anzeige erstellen:
        Button stellenAnz = new Button("Stellenanzeige erstellen",new Icon(VaadinIcon.CLIPBOARD_TEXT));
        stellenAnz.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        stellenAnz.getStyle().set("width","300px");
        stellenAnz.getStyle().set("height","50px");
        setHorizontalComponentAlignment(Alignment.CENTER, stellenAnz);

        Paragraph text2 = new Paragraph("Geben Sie bitte alle Angaben Ihrer Anzeige an.");
        Button closeButton2 = new Button("OK");
        closeButton2.getStyle().set("background-color","dodgerblue");
        closeButton2.getStyle().set("color","white");
        closeButton2.addClickListener(e -> dialog2.close());
        VerticalLayout layout_dialog2 = new VerticalLayout();
        layout_dialog2.add(text2, closeButton2);
        dialog2.add(layout_dialog2);

        Paragraph text21 = new Paragraph("Geben Sie bitte ein gültiges Anfangsdatum an.");
        Button closeButton21 = new Button("OK");
        closeButton21.getStyle().set("background-color","dodgerblue");
        closeButton21.getStyle().set("color","white");
        closeButton21.addClickListener(e -> dialog4.close());
        VerticalLayout layout_dialog21 = new VerticalLayout();
        layout_dialog21.add(text21, closeButton21);
        dialog4.add(layout_dialog21);

        H2 text5 = new H2("Glückwunsch, Ihre Anzeige ist jetzt online :)");
        Button closeButton5_1 = new Button("OK");
        closeButton5_1.getStyle().set("background-color","dodgerblue");
        closeButton5_1.getStyle().set("color","white");
        closeButton5_1.addClickListener(e -> {
            dialog3.close();
            UI.getCurrent().getPage().reload();
        });
        VerticalLayout layout_dialog5 = new VerticalLayout();
        layout_dialog5.add(text5, closeButton5_1);
        dialog3.add(layout_dialog5);

        FormLayout layout_1 = new FormLayout();
        layout_1.getStyle().set("margin-left", "25vw");
        layout_1.getStyle().set("margin-right", "25vw");
        textArea.getStyle().set("minHeight", "200px");
        layout_1.add(title, sector);
        layout_1.add(art, 2);
        layout_1.add(datum, 2);
        layout_1.add(textArea, 4);
        cancel.addClickListener(e -> dialog1.close());
        save.addClickListener(e -> {
            if(title.getValue() == "" || sector.getValue() == "" || art.getValue() == "" || textArea.getValue() == ""){
                dialog2.open();
            }
            else if(datum.getValue() == null){
                dialog4.open();
            }
            else{
                speichern();
                dialog1.close();
                dialog3.open();
            }
        });

        HorizontalLayout buttonLayout = new HorizontalLayout(cancel,save);
        layout_1.add(buttonLayout);
        cancel.setId("cancel_save");
        save.setId("cancel_save");
        stellenAnz.addClickListener(e -> dialog1.open());
        H2 h2 = new H2("Ihre Anzeige");
        VerticalLayout layout11 = new VerticalLayout();
        layout11.add(h2);
        layout11.setHorizontalComponentAlignment(Alignment.CENTER, h2);
        layout11.add(layout_1);
        dialog1.add(layout11);
        add(stellenAnz);
        //----------Ende von Anzeige erstellen.



        //----------grid:

        Grid<JobAdvertisement> grid = new Grid<>();
        grid.addColumn(JobAdvertisement::getTitle).setHeader("Titel").setSortable(true);
        grid.addColumn(JobAdvertisement::getTypeOfJobHiring).setHeader("Art dre Anzeige").setSortable(true);
        grid.addColumn(JobAdvertisement::getSector).setHeader("Branche").setSortable(true);
        grid.addColumn(JobAdvertisement::getStartDate).setHeader("Anfangsdatum").setSortable(true);
        grid.addColumn(JobAdvertisement::getDescription).setHeader("Beschreibung").setSortable(true);
        grid.addColumn(JobAdvertisement::getAnzahl_bewerbungen).setHeader("Bewerbungen").setSortable(true);
        List<JobAdvertisement> liste = jobAdvertisementRepository.findAllByCompany_id(company.getId());
        ListDataProvider<JobAdvertisement> dataProvider = new ListDataProvider<>(liste);
        grid.setDataProvider(dataProvider);
        grid.addItemClickListener(e ->{
            title1.setValue(e.getItem().getTitle());
            art1.setValue(e.getItem().getTypeOfJobHiring());
            sector1.setValue(e.getItem().getSector());
            datum1.setValue(e.getItem().getStartDate());
            textArea1.setValue(e.getItem().getDescription());

            title2.setValue(e.getItem().getTitle());
            art2.setValue(e.getItem().getTypeOfJobHiring());
            sector2.setValue(e.getItem().getSector());
            datum2.setValue(e.getItem().getStartDate());
            textArea2.setValue(e.getItem().getDescription());

            jobAdvertisement = e.getItem();
        });
        title1.setReadOnly(true);
        art1.setReadOnly(true);
        sector1.setReadOnly(true);
        datum1.setReadOnly(true);
        textArea1.setReadOnly(true);
        FormLayout layout_11 = new FormLayout();
        textArea1.getStyle().set("minHeight", "200px");
        layout_11.add(title1, sector1);
        layout_11.add(art1, datum1);
        layout_11.add(textArea1, 4);
        loschen.setId("cancel_save");
        anzeigeandern.setId("cancel_save");
        bewerbungrnanschauen.setId("cancel_save");
        HorizontalLayout buttonLayout11 = new HorizontalLayout(loschen, anzeigeandern, bewerbungrnanschauen);
        layout_11.add(buttonLayout11);
        add(grid);
        add(layout_11);

        //---- loschen von Anzeigen:
        Paragraph text51 = new Paragraph("Möchten Sie wirklich die Anzeige löschen?");
        Button closeButton5_11 = new Button("nein");
        closeButton5_11.getStyle().set("background-color","dodgerblue");
        closeButton5_11.getStyle().set("color","white");
        closeButton5_11.addClickListener(e -> dialogloschen1.close());
        Button loginButton5_22 = new Button("ja");
        loginButton5_22.getStyle().set("background-color","dodgerblue");
        loginButton5_22.getStyle().set("color","white");
        loginButton5_22.addClickListener(e ->{
            jobAdvertisementRepository.delete(jobAdvertisement);
            dataProvider.refreshAll();
            dialogloschen1.close();
            dialogloschen12.open();
        });
        VerticalLayout loschenvla = new VerticalLayout();
        loschenvla.add(text51);
        HorizontalLayout loschenhla = new HorizontalLayout();
        loschenhla.add(closeButton5_11, loginButton5_22);
        loschenvla.add(loschenhla);
        dialogloschen1.add(loschenvla);
        Paragraph text4 = new Paragraph("Ihre Anzeige wurde gelöscht.");
        Button closeButton4 = new Button("OK");
        closeButton4.addClickListener(e -> UI.getCurrent().getPage().reload());
        closeButton4.getStyle().set("background-color","dodgerblue");
        closeButton4.getStyle().set("color","white");
        closeButton4.addClickListener(e -> {
            dialogloschen12.close();
            dataProvider.refreshAll();
        });
        VerticalLayout layout_dialog4 = new VerticalLayout();
        layout_dialog4.add(text4, closeButton4);
        dialogloschen12.add(layout_dialog4);
        loschen.addClickListener(e -> {
            if(jobAdvertisement.getTitle() == null){
                dialogan.open();
            }
            else{
                dialogloschen1.open();
            }
        });
        //------löschen end.

        // ------Anzeige ändern:

        Paragraph text33 = new Paragraph("Wählen Sie eine Stellenanzeige aus.");
        Button cl33 = new Button("OK");
        cl33.addClickListener(e -> dialogan.close());
        cl33.getStyle().set("background-color","dodgerblue");
        cl33.getStyle().set("color","white");
        VerticalLayout vla33 = new VerticalLayout(text33, cl33);
        dialogan.add(vla33);

        FormLayout layout_111 = new FormLayout();
        textArea2.getStyle().set("minHeight", "200px");
        layout_111.add(title2, sector2);
        layout_111.add(art2, datum2);
        layout_111.add(textArea2, 4);
        Button zuruck1 = new Button("Zurück");
        zuruck1.setId("cancel_save");
        zuruck1.addClickListener(e -> dialoganza1.close());
        Button speichern1 = new Button("speichern");
        speichern1.setId("cancel_save");
        speichern1.addClickListener(e -> {
            if(title2.getValue() == "" || sector2.getValue() == "" || art2.getValue() == "" || textArea2.getValue() == ""){
                dialog2.open();
            }
            else if(datum2.getValue() == null){
                dialog4.open();
            }
            else{
                dialoganza2.open();
            }
        });

        Paragraph text22 = new Paragraph("Möchten Sie Ihre Änderung speichern?");
        Button cl22 = new Button("nein");
        cl22.getStyle().set("background-color","dodgerblue");
        cl22.getStyle().set("color","white");
        Button lo22 = new Button("ja");
        lo22.getStyle().set("background-color","dodgerblue");
        lo22.getStyle().set("color","white");
        cl22.addClickListener(e -> dialoganza2.close());
        lo22.addClickListener(e -> {
            jobAdvertisement.setTitle(title2.getValue());
            jobAdvertisement.setStartDate(datum2.getValue());
            jobAdvertisement.setDescription(textArea2.getValue());
            jobAdvertisement.setTypeOfJobHiring(art2.getValue());
            jobAdvertisement.setSector(sector2.getValue());
            jobAdvertisement = jobAdvertisementRepository.save(jobAdvertisement);
            dialoganza2.close();
            dialoganza3.open();
        });

        VerticalLayout vla12 = new VerticalLayout();
        vla12.add(text22);
        HorizontalLayout oo2 = new HorizontalLayout(cl22, lo22);
        vla12.add(oo2);
        dialoganza2.add(vla12);

        Paragraph text3 = new Paragraph("Ihre Änderung wurde erfolgreich gespeichert.");
        Button closeButton3 = new Button("OK");
        closeButton3.getStyle().set("background-color","dodgerblue");
        closeButton3.getStyle().set("color","white");
        closeButton3.addClickListener(e -> {
            UI.getCurrent().getPage().reload();
        });

        VerticalLayout vla11 = new VerticalLayout();
        vla11.add(text3);
        HorizontalLayout oo1 = new HorizontalLayout(closeButton3);
        vla11.add(oo1);
        dialoganza3.add(vla11);
        dialoganza3.setCloseOnOutsideClick(false);

        VerticalLayout ll1 = new VerticalLayout();
        H2 h22 = new H2("Ihre Anzeige");
        ll1.add(h22);
        ll1.setHorizontalComponentAlignment(Alignment.CENTER, h22);
        ll1.add(layout_111);
        HorizontalLayout hl11 = new HorizontalLayout(zuruck1, speichern1);
        ll1.add(hl11);
        dialoganza1.add(ll1);
        anzeigeandern.addClickListener(e -> {
            if(jobAdvertisement.getTitle() == null){
                dialogan.open();
            }
            else{
                dialoganza1.open();
            }
        });
        //-----------------

        dialogbewerbung.setWidth("75%");
        Grid<ApplicationLetter> grid1 = new Grid<>(ApplicationLetter.class, false);
        grid1.setHeight("300px");
        textArea3.getStyle().set("minHeight", "200px");
        textArea3.getStyle().set("minWidth", "100%");
        textArea3.setReadOnly(true);
        Button z1 = new Button("Zurück");
        z1.setId("cancel_save");
        z1.addClickListener(e -> UI.getCurrent().getPage().reload());
        Button studentanschauen = new Button("Student anschauen");
        studentanschauen.addClickListener(e -> dialogbewerbung2.open());
        FormLayout layout6 = new FormLayout();

        // Student Angaben:
        layout6.add(vorname, nachname, geschlicht, geburtsdatum);
        layout6.add(email, 2);
        layout6.add(phone,2);
        layout6.add(adresse, 2);
        layout6.add(postleitzahl, ort);
        layout6.add(studium,2);
        layout6.add(hoechster_abschluss,2);
        layout6.setResponsiveSteps(
                new FormLayout.ResponsiveStep("20px", 1),
                new FormLayout.ResponsiveStep("20px", 2));

        vorname.setReadOnly(true);
        nachname.setReadOnly(true);
        geschlicht.setReadOnly(true);
        geburtsdatum.setReadOnly(true);
        email.setReadOnly(true);
        phone.setReadOnly(true);
        adresse.setReadOnly(true);
        postleitzahl.setReadOnly(true);
        studium.setReadOnly(true);
        ort.setReadOnly(true);
        hoechster_abschluss.setReadOnly(true);

        studentanschauen.setId("cancel_save");
        grid1.addItemClickListener(e ->{
            student = e.getItem().getStudent();
            userstudent = student.getUser();
            textArea3.setValue(e.getItem().getText());
            vorname.setValue(student.getFirstName());
            nachname.setValue(student.getLastName());
            geschlicht.setValue(userstudent.getGeschlecht());
            geburtsdatum.setValue(student.getBirthday());
            adresse.setValue(userstudent.getStreet());
            postleitzahl.setValue(userstudent.getPlz());
            ort.setValue(userstudent.getCity());
            phone.setValue(userstudent.getPhone());
            studium.setValue(student.getStudyCourse());
            hoechster_abschluss.setValue(student.getHighestDiploma());
        });
        VerticalLayout hh1 = new VerticalLayout();
        Button b1 = new Button("Zurück");
        b1.setId("cancel_save");
        b1.addClickListener(e -> dialogbewerbung2.close());
        Button b2 = new Button("fertig");
        b2.setId("cancel_save");
        b2.addClickListener(e -> UI.getCurrent().getPage().reload());
        HorizontalLayout lo = new HorizontalLayout(b1, b2);
        layout6.add(lo);
        hh1.add(layout6);;
        dialogbewerbung2.add(hh1);
        dialogbewerbung2.setCloseOnOutsideClick(false);
        dialogloschen12.setCloseOnOutsideClick(false);
        dialogbewerbung.setCloseOnOutsideClick(false);
        dialogbewerbung2.setWidth("75%");
        VerticalLayout bewlay = new VerticalLayout(grid1, textArea3);
        HorizontalLayout hzbew = new HorizontalLayout(z1, studentanschauen);
        bewlay.add(hzbew);
        bewerbungrnanschauen.addClickListener(e -> {
            if(jobAdvertisement.getTitle() == null){
                dialogan.open();
            }
            else{
                List<ApplicationLetter> liste1 = applicationletterRepository.findAllByJobAdvertisement(jobAdvertisement);
                ListDataProvider<ApplicationLetter> dataProvider1 = new ListDataProvider<>(liste1);
                grid1.addColumn(ApplicationLetter::getText).setHeader("Bewerbung").setSortable(true);
                grid1.setDataProvider(dataProvider1);
                dialogbewerbung.add(bewlay);
                dialogbewerbung.open();
            }
        });

















    }

    private void speichern() {
        List<JobAdvertisement> list = new ArrayList<>();
        jobAdvertisement.setTitle(title.getValue());
        jobAdvertisement.setSector(sector.getValue());
        jobAdvertisement.setStartDate(datum.getValue());
        jobAdvertisement.setTypeOfJobHiring(art.getValue());
        jobAdvertisement.setDescription(textArea.getValue());
        jobAdvertisement.setCompany(company);
        list.add(jobAdvertisement);
        company.setJobAdvertisements(list);
        jobAdvertisementRepository.save(jobAdvertisement);
        companyRepository.save(company);
    }

    private JobAdvertisement getCurrentAnzeige() {
        UI.getCurrent().getSession().setAttribute(Globals.CURRENT_ANZEIGE, jobAdvertisement);
        return (JobAdvertisement) UI.getCurrent().getSession().getAttribute(Globals.CURRENT_ANZEIGE);
    }
}