package org.hbrs.se2.project.npng.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.hbrs.se2.project.npng.controller.RegisterControl;
import org.hbrs.se2.project.npng.controller.exception.DatabaseLayerException;
import org.hbrs.se2.project.npng.entity.Student;
import org.hbrs.se2.project.npng.entity.User;
import org.hbrs.se2.project.npng.repository.StudentRepository;
import org.hbrs.se2.project.npng.repository.UserRepository;
import org.hbrs.se2.project.npng.view.component.EmailTextField;
import org.hbrs.se2.project.npng.view.component.PasswordTextField;
import org.hbrs.se2.project.npng.view.component.RegistrationTextField;
import org.hbrs.se2.project.npng.view.layoutview.RegisterLayoutView;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Route(value = "RegisterStudent", layout = RegisterLayoutView.class)
@PageTitle("No-Pain_No-Gain")
//@CssImport("./themes/nopainnogain/components/Register.css")


public class RegisterStudentView extends VerticalLayout {

    private UserRepository userRepository;
    private StudentRepository studentRepository;


    public RegisterStudentView(UserRepository userRepository, StudentRepository studentRepository){
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
        RegisterControl registrationControl = new RegisterControl(userRepository);

        setMargin(true);
        setDefaultHorizontalComponentAlignment(Alignment.START);

        // Layout:
        HorizontalLayout h_layout = new HorizontalLayout();
        VerticalLayout v_layout = new VerticalLayout();


        // Überschriften:
        H4 h4_1 = new H4("Herzlich Willkommen bei\n No-Pain_No-Gain :)");
        H4 h4_2 = new H4("Registrieren Sie sich jetzt:");
        h4_1.setId("h4_1");
        h4_2.setId("h4_2");

        // TextFelder:
        RegistrationTextField vorname = new RegistrationTextField("Vorname");
        RegistrationTextField nachname = new RegistrationTextField("Nachname");
        EmailTextField email = new EmailTextField("E-Mail");
        PasswordTextField password = new PasswordTextField("Password");
        PasswordTextField password_Wiederholen = new PasswordTextField("Password (Wiederholen)");

        // Image erstellen:
        Image image = new Image();
        image.setSrc("images/Student.png");
        image.setAlt("Logo");
        image.setId("image_student");

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
        registrieren.setId("student_registrieren");
        Button zurueck = new Button("Zurück");
        registrieren.setId("Student_Buttons");
        zurueck.setId("Student_Buttons");
        zurueck.addClickListener(e -> navigateToRegisterStartseiteView());
        HorizontalLayout horizontalLayout = new HorizontalLayout();

        registrieren.addClickListener(e->{

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
                    user.setGeschlecht("");
                    user.setRole(User.STUDENT);
                    user = userRepository.save(user);
                    //TODO validation
                    Student student = new Student();
                    student.setFirstName(vorname.getValue());
                    student.setLastName(nachname.getValue());
                    student.setHighestDiploma("");
                    student.setEducation("");
                    student.setStudyCourse("");
                    student.setUser(user);
                    studentRepository.save(student);
                    dialog5.open();
                }
            } catch (DatabaseLayerException ex) {
                ex.printStackTrace();
            }
        });




        horizontalLayout.add(zurueck, registrieren);
        // Layout:
        v_layout.add(vorname, nachname, email, password, password_Wiederholen);
        h_layout.add(v_layout, image);

        // Add:
        add(h4_1, h4_2);
        add(h_layout);
        add(horizontalLayout);

    }
    private void navigateToRegisterStartseiteView(){
        UI.getCurrent().navigate(StartseiteView.class);
    }
}