package org.hbrs.se2.project.npng.view;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.apache.commons.lang3.StringUtils;
import org.hbrs.se2.project.npng.entity.*;
import org.hbrs.se2.project.npng.repository.ApplicationletterRepository;
import org.hbrs.se2.project.npng.repository.JobAdvertisementRepository;
import org.hbrs.se2.project.npng.util.Globals;
import org.hbrs.se2.project.npng.view.layoutview.StudentLayoutview;

import java.util.List;

@Route(value = "StudentView",layout = StudentLayoutview.class)
@PageTitle("No-Pain_No-Gain")
@CssImport("./themes/nopainnogain/components/ProfilBearbeiten.css")

public class StudentView extends VerticalLayout{

    private TextField vorname = new TextField("Vorname");
    private TextField nachname = new TextField("Nachname");
    private TextField geschlicht = new TextField("Geschlecht");
    private DatePicker geburtsdatum = new DatePicker("Geburtsdatum");
    private EmailField email1 = new EmailField("E-Mail Adresse");
    private TextField phone1 = new TextField("Mobile-Nummer");
    private TextField studium = new TextField("Studium");
    private TextField hoechster_abschluss = new TextField("Höchster Abschluss");
    private TextField adresse1 = new TextField("Straße und Hausnummer");
    private TextField postleitzahl1 = new TextField("Postleitzahl");
    private TextField ort1 = new TextField("Ort");
    private Button cancel = new Button("Zurück");
    private Button save = new Button("Speichern");

    private TextField unternehmername = new TextField("Unternehmensname");
    private EmailField email = new EmailField("E-Mail Adresse");
    private TextField phone = new TextField("Telefonnummer");
    private TextField adresse = new TextField("Straße und Hausnummer");
    private TextField postleitzahl = new TextField("Postleitzahl");
    private TextField ort = new TextField("Ort");
    private TextField title = new TextField("Titel");
    private TextField sector = new TextField("Branche");
    private TextField art = new TextField("Art der Anzeige");
    private DatePicker datum = new DatePicker("Startdatum");
    private TextArea textArea = new TextArea("Beschreibeung");
    private JobAdvertisementRepository jobAdvertisementRepository;
    private ApplicationletterRepository applicationletterRepository;
    private Company company = new Company();
    private User user = new User();
    private JobAdvertisement jobAdvertisement = new JobAdvertisement();
    private User user1 = (User) UI.getCurrent().getSession().getAttribute(Globals.CURRENT_USER);
    private Student student = user1.getStudent();

    private Dialog dialog4 = new Dialog();
    private Dialog dialog5 = new Dialog();
    private Dialog dialog6 = new Dialog();
    private Dialog dialog7 = new Dialog();

    public StudentView(JobAdvertisementRepository jobAdvertisementRepository, ApplicationletterRepository applicationletterRepository){

        this.jobAdvertisementRepository = jobAdvertisementRepository;
        this.applicationletterRepository = applicationletterRepository;

        HorizontalLayout h_layout = new HorizontalLayout();
        VerticalLayout v_layout = new VerticalLayout();

        List<JobAdvertisement> liste = jobAdvertisementRepository.findAll();
        ListDataProvider<JobAdvertisement> dataProvider = new ListDataProvider<>(liste);

        // Überschriften:
        H1 h4_1 = new H1("Finden Sie Ihren Traumjob ! ");
        h4_1.setId("h4_1");
        setHorizontalComponentAlignment(Alignment.CENTER, h4_1);
        //Titel
        TextField comboNachWas = new TextField();
        comboNachWas.setPlaceholder("Titel");
        TextField comboNachWas2 = new TextField();
        comboNachWas2.setPlaceholder("Art der Suche");
        TextField comboNachWas3 = new TextField();
        comboNachWas3.setPlaceholder("Branche");

        Grid<JobAdvertisement> grid = new Grid<>(JobAdvertisement.class, false);
        grid.addColumn(JobAdvertisement::getTitle).setHeader("Titel").setSortable(true);
        grid.addColumn(JobAdvertisement::getTypeOfJobHiring).setHeader("Art dre Anzeige").setSortable(true);
        grid.addColumn(JobAdvertisement::getSector).setHeader("Branche").setSortable(true);
        grid.addColumn(JobAdvertisement::getStartDate).setHeader("Anfangsdatum").setSortable(true);
        grid.addColumn(JobAdvertisement::getDescription).setHeader("Beschreibung").setSortable(true);
        grid.setDataProvider(dataProvider);

        comboNachWas.addValueChangeListener(event -> dataProvider.addFilter(
                c -> StringUtils.containsIgnoreCase(c.getTitle(), comboNachWas.getValue())));
        comboNachWas.setValueChangeMode(ValueChangeMode.EAGER);
        comboNachWas.setSizeFull();

        comboNachWas2.addValueChangeListener(event -> dataProvider.addFilter(
                c -> StringUtils.containsIgnoreCase(c.getTypeOfJobHiring(), comboNachWas2.getValue())));
        comboNachWas2.setValueChangeMode(ValueChangeMode.EAGER);
        comboNachWas2.setSizeFull();

        comboNachWas3.addValueChangeListener(event -> dataProvider.addFilter(
                c -> StringUtils.containsIgnoreCase(c.getSector(), comboNachWas3.getValue())));
        comboNachWas3.setValueChangeMode(ValueChangeMode.EAGER);
        comboNachWas3.setSizeFull();
        add(h4_1);
        h_layout.add(comboNachWas ,comboNachWas2 ,comboNachWas3);
        setHorizontalComponentAlignment(Alignment.CENTER, h_layout);

        Button closeButton5_1 = new Button("Zurück");
        Button loginButton5_2 = new Button("bewerben");
        closeButton5_1.addClickListener(e -> dialog5.close());

        grid.addItemClickListener(e ->{
            company = e.getItem().getCompany();
            jobAdvertisement = e.getItem();
            user = company.getUser();
            unternehmername.setValue(company.getName());
            email.setValue(user.getMail());
            phone.setValue(user.getPhone());
            adresse.setValue(user.getStreet());
            postleitzahl.setValue(user.getPlz());
            ort.setValue(user.getCity());
            title.setValue(e.getItem().getTitle());
            art.setValue(e.getItem().getTypeOfJobHiring());
            sector.setValue(e.getItem().getSector());
            datum.setValue(e.getItem().getStartDate());
            textArea.setValue(e.getItem().getDescription());
            dialog5.open();
        });

        vorname.setValue(student.getFirstName());
        vorname.setReadOnly(true);
        nachname.setValue(student.getLastName());
        nachname.setReadOnly(true);
        geschlicht.setValue(user1.getGeschlecht());
        geschlicht.setReadOnly(true);
        geburtsdatum.setValue(student.getBirthday());
        geburtsdatum.setReadOnly(true);
        email1.setValue(user1.getMail());
        email1.setReadOnly(true);
        phone1.setValue(user1.getPhone());
        phone1.setReadOnly(true);
        adresse1.setValue(user1.getStreet());
        adresse1.setReadOnly(true);
        postleitzahl1.setValue(user1.getPlz());
        postleitzahl1.setReadOnly(true);
        ort1.setValue(user1.getCity());
        ort1.setReadOnly(true);
        studium.setValue(student.getStudyCourse());
        studium.setReadOnly(true);
        hoechster_abschluss.setValue(student.getHighestDiploma());
        hoechster_abschluss.setReadOnly(true);


        FormLayout layout_11 = new FormLayout();
        H2 mph2 = new H2("Mein Profil");
        VerticalLayout mplayout = new VerticalLayout();
        mplayout.add(mph2);
        mplayout.setHorizontalComponentAlignment(Alignment.CENTER, mph2);
        layout_11.getStyle().set("margin-left", "20vw");
        layout_11.getStyle().set("margin-right", "20vw");

        // Persönlische Angaben:
        layout_11.add(vorname, nachname, geschlicht, geburtsdatum);
        layout_11.add(email1, 2);
        layout_11.add(phone1,2);
        layout_11.add(adresse1, 2);
        layout_11.add(postleitzahl1, ort1);
        layout_11.add(studium,2);
        layout_11.add(hoechster_abschluss,2);
        layout_11.setResponsiveSteps(
                new FormLayout.ResponsiveStep("1px", 1),
                new FormLayout.ResponsiveStep("1px", 2));

        mplayout.add(layout_11);
        dialog4.add(mplayout);



        H2 hh1 = new H2("Herzlich Glückwunsch, Ihre Bewerbung ist erfolgreich eingegangen :)");
        Button bb1 = new Button("OK");
        bb1.addClickListener(e -> dialog7.close());
        bb1.setId("cancel_save");
        VerticalLayout vlo = new VerticalLayout();
        vlo.add(hh1,bb1);
        dialog7.add(vlo);

        VerticalLayout layout1 = new VerticalLayout();
        H2 h3 = new H2("Schreiben Sie hier Ihre Bewerbung");
        layout1.add(h3);
        layout1.setHorizontalComponentAlignment(Alignment.CENTER, h3);
        TextArea textArea2 = new TextArea();
        textArea2.getStyle().set("minHeight", "350px");
        textArea2.getStyle().set("minWidth", "90vw");
        layout1.add(textArea2);
        Button zuruck = new Button("Zurück");
        zuruck.addClickListener(e -> {
            dialog6.close();
            dialog4.open();
        });
        Button schicken = new Button("Schicken");
        schicken.addClickListener( e -> {
            jobAdvertisement.setAnzahl_bewerbungen(jobAdvertisement.getAnzahl_bewerbungen() + 1);//-------------------
            ApplicationLetter applicationLetter = new ApplicationLetter();
            applicationLetter.setStudent(student);
            applicationLetter.setJobAdvertisement(jobAdvertisement);
            applicationLetter.setText(textArea2.getValue());
            jobAdvertisement = jobAdvertisementRepository.save(jobAdvertisement);
            applicationLetter = applicationletterRepository.save(applicationLetter);

            dialog6.close();
            dialog7.open();
        });

        zuruck.setId("cancel_save");
        schicken.setId("cancel_save");
        HorizontalLayout layout = new HorizontalLayout();
        layout.add(zuruck, schicken);
        layout1.add(layout);
        dialog6.add(layout1);

        HorizontalLayout layoutb = new HorizontalLayout();
        Button zuruckb = new Button("Zurück");
        zuruckb.addClickListener(e -> {
            dialog4.close();
            dialog5.open();
        });
        Button profilb = new Button("Profilbearbeiten");
        profilb.addClickListener(e -> {
            dialog4.close();
            UI.getCurrent().navigate(StudentProfilBearbeitenView.class);
        });
        Button weiteb = new Button("Weiter");
        weiteb.addClickListener(e -> {
            dialog4.close();
            dialog6.open();
        });
        zuruckb.setId("cancel_save");
        profilb.setId("cancel_save");
        weiteb.setId("cancel_save");
        layoutb.add(zuruckb,profilb,weiteb);
        layout_11.add(layoutb);


        FormLayout layout_1 = new FormLayout();
        VerticalLayout vl1 = new VerticalLayout();
        layout_1.getStyle().set("margin-left", "20vw");
        layout_1.getStyle().set("margin-right", "20vw");
        //textArea.getStyle().set("minHeight", "70px");
        H2 h4anzeige = new H2("Anzeige Details");
        vl1.add(h4anzeige);
        vl1.setHorizontalComponentAlignment(Alignment.CENTER, h4anzeige);
        layout_1.add(unternehmername,email,phone,adresse,postleitzahl,ort);
        layout_1.add(title, sector);
        layout_1.add(art, datum);
        layout_1.add(textArea, 2);

        loginButton5_2.addClickListener(e -> {
            dialog5.close();
            //UI.getCurrent().navigate(Bewerben.class);
            dialog4.open();
        });
        closeButton5_1.setId("cancel_save");
        loginButton5_2.setId("cancel_save");
        HorizontalLayout buttonLayout = new HorizontalLayout(closeButton5_1, loginButton5_2);

        layout_1.add(buttonLayout);
        vl1.add(layout_1);
        dialog5.add(vl1);

        unternehmername.setReadOnly(true);
        email.setReadOnly(true);
        phone.setReadOnly(true);
        adresse.setReadOnly(true);
        postleitzahl.setReadOnly(true);
        ort.setReadOnly(true);
        title.setReadOnly(true);
        sector.setReadOnly(true);
        art.setReadOnly(true);
        datum.setReadOnly(true);
        textArea.setReadOnly(true);
        add(h_layout);
        add(grid);

    }
}