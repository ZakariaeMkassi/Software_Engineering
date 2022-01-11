package org.hbrs.se2.project.npng.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.hbrs.se2.project.npng.repository.CompanyRepository;
import org.hbrs.se2.project.npng.repository.UserRepository;
import org.hbrs.se2.project.npng.view.component.UnternehmerProfil;
import org.hbrs.se2.project.npng.view.layoutview.CompanyLayoutView;


@Route(value = "UnternehmerProfilBearbeitenView",layout = CompanyLayoutView.class)
@CssImport("./themes/nopainnogain/components/ProfilBearbeiten.css")
@PageTitle("No-Pain_No-Gain")
public class UnternehmerProfilBearbeitenView extends UnternehmerProfil {

    private UserRepository userRepository;
    private CompanyRepository companyRepository;
    private Dialog dialog5 = new Dialog();
    private Dialog dialog4 = new Dialog();


    public UnternehmerProfilBearbeitenView(UserRepository userRepository, CompanyRepository companyRepository) {

        this.userRepository = userRepository;
        this.companyRepository = companyRepository;

        getUnternehmername().setValue(getCompany().getName());
        getEmail().setValue(getUser().getMail());
        getEmail().setReadOnly(true);
        getPhone().setValue(getUser().getPhone());
        getAdresse().setValue(getUser().getStreet());
        getPostleitzahl().setValue(getUser().getPlz());
        getOrt().setValue(getUser().getCity());
        getHauptsitz().setValue(getCompany().getFoundingYear());
        getAnzahl_Angestellten().setValue(String.valueOf(getCompany().getNumberOfEmployee()));
        getGruendungsjahr().setValue(getCompany().getFoundingYear());
        getBranche().setValue(getCompany().getSector());
        getCancel().addClickListener(e -> UI.getCurrent().navigate(UnternehmerProfilView.class));
        getSave().addClickListener(e -> dialog5.open());

        Paragraph text4 = new Paragraph("Ihre Änderung wurde gepeichert :)");
        Button closeButton4 = new Button("OK");
        closeButton4.addClickListener(e -> do_dialog4());
        VerticalLayout layout_dialog4 = new VerticalLayout();
        layout_dialog4.add(text4, closeButton4);
        dialog4.add(layout_dialog4);

        Paragraph text5 = new Paragraph("Möchten Sie Ihre Änderung speichern?");
        Button closeButton5_1 = new Button("nein");
        Button loginButton5_2 = new Button("ja");
        closeButton5_1.addClickListener(e -> dialog5.close());
        loginButton5_2.addClickListener(e -> dialogs());
        HorizontalLayout layout_h_dialog5 = new HorizontalLayout();
        layout_h_dialog5.add(closeButton5_1, loginButton5_2);
        VerticalLayout layout_dialog5 = new VerticalLayout();
        layout_dialog5.add(text5, layout_h_dialog5);
        dialog5.add(layout_dialog5);
        getSave().addClickListener(e -> dialog5.open());
    }

    private void speichern() {
        getCompany().setName(getUnternehmername().getValue());
        getCompany().setFoundingYear(getGruendungsjahr().getValue());
        getCompany().setSector(getBranche().getValue());
        getUser().setPhone(String.valueOf(getPhone().getValue()));
        getUser().setStreet(getAdresse().getValue());
        getUser().setCity(getOrt().getValue());
        getUser().setPlz(String.valueOf(getPostleitzahl().getValue()));
        getCompany().setNumberOfEmployee(Integer.valueOf(getAnzahl_Angestellten().getValue()));
        getCompany().setHeadOffice(getHauptsitz().getValue());

        userRepository.save(getUser());
        companyRepository.save(getCompany());
    }

    public void dialogs() {
        dialog5.close();
        speichern();
        dialog4.open();
    }

    public void do_dialog4() {
        dialog4.close();
        UI.getCurrent().navigate(UnternehmerProfilView.class);

    }

}