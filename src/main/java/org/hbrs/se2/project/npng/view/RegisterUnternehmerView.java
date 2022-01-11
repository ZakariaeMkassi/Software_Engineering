package org.hbrs.se2.project.npng.view;



import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.hbrs.se2.project.npng.controller.RegisterControl;
import org.hbrs.se2.project.npng.controller.exception.DatabaseLayerException;
import org.hbrs.se2.project.npng.entity.Company;
import org.hbrs.se2.project.npng.entity.User;
import org.hbrs.se2.project.npng.repository.CompanyRepository;
import org.hbrs.se2.project.npng.repository.UserRepository;
import org.hbrs.se2.project.npng.view.component.EmailTextField;
import org.hbrs.se2.project.npng.view.component.PasswordTextField;
import org.hbrs.se2.project.npng.view.component.RegistrationTextField;
import org.hbrs.se2.project.npng.view.layoutview.RegisterLayoutView;


@Route(value = "RegisterUnternehmer", layout = RegisterLayoutView.class)
@PageTitle("No-Pain_No-Gain")
@CssImport("./themes/nopainnogain/components/Register.css")

public class RegisterUnternehmerView extends VerticalLayout {

    private UserRepository userRepository;
    private CompanyRepository companyRepository;

    public RegisterUnternehmerView(UserRepository userRepository, CompanyRepository companyRepository){

        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
        RegisterControl registrationControl = new RegisterControl(userRepository);

        setMargin(true);
        setDefaultHorizontalComponentAlignment(Alignment.START);
        HorizontalLayout layout = new HorizontalLayout();
        VerticalLayout v_layout = new VerticalLayout();

        // Überschriften:
        H4 h4_1 = new H4("Herzlich Willkommen bei\n No-Pain_No-Gain :)");
        H4 h4_2 = new H4("Registrieren Sie sich jetzt:");
        h4_1.setId("h4_1");
        h4_2.setId("h4_2");

        // TextFelder:
        RegistrationTextField firmaname = new RegistrationTextField("Firmaname");
        EmailTextField email = new EmailTextField("E-Mail");
        PasswordTextField password = new PasswordTextField("Password");
        PasswordTextField password_Wiederholen = new PasswordTextField("Password (Wiederholen)");

        //image erstellen:
        Image image = new Image();
        image.setSrc("images/Unternehmer.png");
        image.setAlt("Logo");
        image.setId("image_Unternehmer");
        add(h4_1,h4_2);
        v_layout.add(firmaname,email, password, password_Wiederholen);
        layout.add(v_layout,image);
        add(layout);

        Dialog dialog = new Dialog();
        Paragraph text1 = new Paragraph("Registrierung fehlgeschlagen: Ein Nutzer mit dieser E-Mail existiert bereits.");
        text1.getStyle().set("color","red");
        Button closeButton = new Button("Zurück");
        closeButton.addClickListener(e -> dialog.close());
        VerticalLayout layout_dialog = new VerticalLayout();
        layout_dialog.add(text1, closeButton);
        dialog.add(layout_dialog);

        Dialog dialog2 = new Dialog();
        Paragraph text2 = new Paragraph("Registrierung fehlgeschlagen: Die Passworte stimmen nicht überein.");
        text2.getStyle().set("color","red");
        Button closeButton2 = new Button("Zurück");
        closeButton2.addClickListener(e -> dialog2.close());
        VerticalLayout layout_dialog2 = new VerticalLayout();
        layout_dialog2.add(text2, closeButton2);
        dialog2.add(layout_dialog2);

        Dialog dialog3 = new Dialog();
        Paragraph text3 = new Paragraph("Registrierung fehlgeschlagen: Das eingegebene Passwort ist kurz.");
        text3.getStyle().set("color","red");
        Button closeButton3 = new Button("Zurück");
        closeButton3.addClickListener(e -> dialog3.close());
        VerticalLayout layout_dialog3 = new VerticalLayout();
        layout_dialog3.add(text3, closeButton3);
        dialog3.add(layout_dialog3);

        Dialog dialog4 = new Dialog();
        Paragraph text4 = new Paragraph("Registrierung fehlgeschlagen: Die eingegebene E-Mail ist falsch.");
        text4.getStyle().set("color","red");
        Button closeButton4 = new Button("Zurück");
        closeButton4.addClickListener(e -> dialog4.close());
        VerticalLayout layout_dialog4 = new VerticalLayout();
        layout_dialog4.add(text4, closeButton4);
        dialog4.add(layout_dialog4);

        Dialog dialog5 = new Dialog();
        Paragraph text5 = new Paragraph("Herzlich willkommen bei No-Pain_No-Gain: Sie habe sich erfolgreich registriert :)");
        Button closeButton5_1 = new Button("Zurück");
        Button loginButton5_2 = new Button("zu Login");
        closeButton5_1.addClickListener(e -> dialog5.close());
        loginButton5_2.addClickListener(e -> UI.getCurrent().navigate(LoginView.class));
        HorizontalLayout layout_h_dialog5 = new HorizontalLayout();
        layout_h_dialog5.add(closeButton5_1,loginButton5_2);
        VerticalLayout layout_dialog5 = new VerticalLayout();
        layout_dialog5.add(text5, layout_h_dialog5);
        dialog5.add(layout_dialog5);

        // Butten erstellen:
        Button registrieren = new Button("registrieren");
        Button zurueck = new Button("Zurück");
        registrieren.setId("Unternehmer_Buttons");
        zurueck.setId("Unternehmer_Buttons");
        zurueck.addClickListener(e -> navigateToRegisterStartseiteView());

        registrieren.addClickListener(ee->{
            try {
                if(registrationControl.checkExistingEmail(email.getValue())){
                    dialog.open();
                }
                else if(email.getValue().length() < 5 || !(email.getValue().contains("@")) || !(email.getValue().contains("."))){
                    dialog4.open();
                }
                else if((!(password.getValue().equals(password_Wiederholen.getValue())))){
                    dialog2.open();
                }
                else if((password.getValue().length() < 6)){
                    dialog3.open();
                }
                else{
                    User user = new User();
                    user.setPassword(password.getValue());
                    user.setMail(email.getValue());
                    user.setContactMail("");
                    user.setCity("");
                    user.setHouseNumber("");
                    user.setPhone("");
                    user.setPlz("");
                    user.setStreet("");
                    user.setRole(User.COMPANY);
                    user = userRepository.save(user);
                    //TODO validation
                    Company company = new Company();
                    company.setName(firmaname.getValue());
                    company.setSector("");
                    company.setHeadOffice("");
                    company.setNumberOfEmployee(0);
                    company.setFoundingYear("");
                    company.setUser(user);
                    companyRepository.save(company);
                    dialog5.open();
                }
            } catch (DatabaseLayerException e) {
                e.printStackTrace();
            }
        });

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.add(zurueck, registrieren);
        add(horizontalLayout);
    }

    private void navigateToRegisterStartseiteView(){
        UI.getCurrent().navigate(StartseiteView.class);
    }
}