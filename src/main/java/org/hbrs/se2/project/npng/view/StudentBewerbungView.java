package org.hbrs.se2.project.npng.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
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
import org.hbrs.se2.project.npng.repository.JobAdvertisementRepository;
import org.hbrs.se2.project.npng.util.Globals;
import org.hbrs.se2.project.npng.view.layoutview.StudentLayoutview;

import java.util.List;

@Route(value = "StudentBewerbungView",layout = StudentLayoutview.class)
@PageTitle("No-Pain_No-Gain")
@CssImport("./themes/nopainnogain/components/ProfilBearbeiten.css")

public class StudentBewerbungView extends VerticalLayout {
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
    private TextArea textArea1 = new TextArea();
    private Dialog dialog5 = new Dialog();
    private Dialog dialog4 = new Dialog();

    private JobAdvertisementRepository jobAdvertisementRepository;
    private ApplicationletterRepository applicationletterRepository;

    private Company company = new Company();
    private User user1 = new User();
    private JobAdvertisement jobAdvertisement = new JobAdvertisement();

    private User user = (User) UI.getCurrent().getSession().getAttribute(Globals.CURRENT_USER);
    private Student student = user.getStudent();

    public StudentBewerbungView(JobAdvertisementRepository jobAdvertisementRepository, ApplicationletterRepository applicationletterRepository){

        this.jobAdvertisementRepository = jobAdvertisementRepository;
        this.applicationletterRepository = applicationletterRepository;

        List<ApplicationLetter> liste = applicationletterRepository.findAllByStudent(student);

        ListDataProvider<ApplicationLetter> dataProvider = new ListDataProvider<>(liste);
        Grid<ApplicationLetter> grid = new Grid<>(ApplicationLetter.class, false);
        grid.addColumn(ApplicationLetter::getText).setHeader("Mein Schreiben").setSortable(true);
        grid.setDataProvider(dataProvider);

        grid.addItemClickListener(e ->{
            jobAdvertisement = e.getItem().getJobAdvertisement();
            company = jobAdvertisement.getCompany();
            user1 = company.getUser();
            unternehmername.setValue(company.getName());
            unternehmername.setReadOnly(true);
            email.setValue(user1.getMail());
            email.setReadOnly(true);
            phone.setValue(user1.getPhone());
            phone.setReadOnly(true);
            adresse.setValue(user1.getStreet());
            adresse.setReadOnly(true);
            postleitzahl.setValue(user1.getPlz());
            postleitzahl.setReadOnly(true);
            ort.setValue(user1.getCity());
            ort.setReadOnly(true);
            title.setValue(jobAdvertisement.getTitle());
            title.setReadOnly(true);
            art.setValue(jobAdvertisement.getTypeOfJobHiring());
            art.setReadOnly(true);
            sector.setValue(jobAdvertisement.getSector());
            sector.setReadOnly(true);
            datum.setValue(jobAdvertisement.getStartDate());
            datum.setReadOnly(true);
            textArea.setValue(jobAdvertisement.getDescription());
            textArea.setReadOnly(true);
            textArea1.setValue(e.getItem().getText());
            textArea1.setReadOnly(true);
            dialog4.open();
        });

        FormLayout layout_1 = new FormLayout();
        VerticalLayout vl1 = new VerticalLayout();
        layout_1.getStyle().set("margin-left", "20vw");
        layout_1.getStyle().set("margin-right", "20vw");
        H2 h4anzeige = new H2("Anzeige Details");
        vl1.add(h4anzeige);
        vl1.setHorizontalComponentAlignment(Alignment.CENTER, h4anzeige);
        layout_1.add(unternehmername,email,phone,adresse,postleitzahl,ort);
        layout_1.add(title, sector);
        layout_1.add(art, datum);
        layout_1.add(textArea, 2);
        HorizontalLayout ll1 = new HorizontalLayout();
        Button zuruck1 = new Button("Zurück");
        zuruck1.setId("cancel_save");
        zuruck1.addClickListener(e -> {
            dialog5.close();
            dialog4.open();
        });
        Button weiter1 = new Button("OK");
        weiter1.setId("cancel_save");
        weiter1.addClickListener(e -> dialog5.close());
        ll1.add(zuruck1, weiter1);
        vl1.add(layout_1);
        layout_1.add(ll1);
        dialog5.add(vl1);

        VerticalLayout layout1 = new VerticalLayout();
        H2 h3 = new H2("Mein Schreiben");
        layout1.add(h3);
        layout1.setHorizontalComponentAlignment(Alignment.CENTER, h3);
        textArea1.getStyle().set("minHeight", "350px");
        textArea1.getStyle().set("minWidth", "90vw");
        layout1.add(textArea1);
        Button zuruck = new Button("Zurück");
        zuruck.setId("cancel_save");
        zuruck.addClickListener(e -> dialog4.close());
        Button weiter = new Button("Anzeige anschauen");
        weiter.setId("cancel_save");
        weiter.addClickListener(e -> {
            dialog4.close();
            dialog5.open();
        });
        HorizontalLayout ll2 = new HorizontalLayout();
        ll2.add(zuruck, weiter);
        layout1.add(ll2);
        dialog4.add(layout1);

        H1 h4_1 = new H1("Meine Bewerbungen");
        h4_1.setId("h4_1");
        setHorizontalComponentAlignment(Alignment.CENTER, h4_1);
        add(h4_1, grid);
    }

}
