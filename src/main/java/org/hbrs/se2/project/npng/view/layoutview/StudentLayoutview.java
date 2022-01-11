package org.hbrs.se2.project.npng.view.layoutview;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.ThemeList;
import com.vaadin.flow.theme.lumo.Lumo;
import org.hbrs.se2.project.npng.entity.Student;
import org.hbrs.se2.project.npng.entity.User;
import org.hbrs.se2.project.npng.repository.UserRepository;
import org.hbrs.se2.project.npng.util.Globals;
import org.hbrs.se2.project.npng.view.*;

public class StudentLayoutview extends AppLayout  {
    MenuBar menuBar = new MenuBar();
    private User user = (User) UI.getCurrent().getSession().getAttribute(Globals.CURRENT_USER);
    private Student student = user.getStudent();
    private Dialog dialog = new Dialog();
    private UserRepository userRepository;


    public StudentLayoutview(UserRepository userRepository){
        this.userRepository = userRepository;
        addToNavbar(createHeaderContent(),createHeaderContent_1());
    }

    private Component createHeaderContent(){
        //Image erstellen:
        HorizontalLayout layout = new HorizontalLayout();
        Image img = new Image();
        img.setSrc("images/NpNg.png");
        img.setId("imgNpNg_Layout");
        img.setHeight("60px");
        layout.add(img);

        return layout;
    }

    private Component createHeaderContent_1(){

        //MenuBar erstellen:
        MenuBar menuBar = new MenuBar();
        MenuItem project = menuBar.addItem(new Icon(VaadinIcon.LINES));
        SubMenu projectSubMenu = project.getSubMenu();
        MenuItem home = projectSubMenu.addItem(new Button("Home",new Icon(VaadinIcon.HOME)));
        home.addClickListener(e -> navigateToStudentView());
        MenuItem bewerbungen = projectSubMenu.addItem(new Button("Meine Bewerbungen",new Icon(VaadinIcon.ENVELOPES)));
        bewerbungen.addClickListener(e -> UI.getCurrent().navigate(StudentBewerbungView.class));
        MenuItem mienprofiel = projectSubMenu.addItem(new Button("mein Profil",new Icon(VaadinIcon.USER)));
        mienprofiel.addClickListener(e -> UI.getCurrent().navigate(StudentProfilView.class));
        MenuItem einstellungen = projectSubMenu.addItem(new Button("Einstellung",new Icon(VaadinIcon.COG)));
        SubMenu kontoloschen =  einstellungen.getSubMenu();

        Button loschen = new Button("Konto löschen");
        Paragraph text4 = new Paragraph("möchten Sie Ihr Konto wirklich löschen?");
        Button closeButton5_1 = new Button("nein");
        closeButton5_1.addClickListener(e -> dialog.close());
        Button loginButton5_2 = new Button("ja");
        HorizontalLayout layout_h_dialog5 = new HorizontalLayout();
        layout_h_dialog5.add(closeButton5_1, loginButton5_2);
        VerticalLayout layout_dialog5 = new VerticalLayout();
        layout_dialog5.add(text4, layout_h_dialog5);
        dialog.add(layout_dialog5);
        loginButton5_2.addClickListener( e -> {
            userRepository.delete(user);
            dialog.close();
            UI.getCurrent().navigate(StartseiteView.class);
        });
        loschen.addClickListener( e -> dialog.open());
        kontoloschen.add(loschen);

        MenuItem logout = projectSubMenu.addItem(new Button("Logout",new Icon(VaadinIcon.SIGN_OUT)),e -> logoutUser());

        // Icon erstellen:
        Icon theme = new Icon(VaadinIcon.ADJUST);
        theme.addClickListener(iconClickEvent -> {
            ThemeList themeList = UI.getCurrent().getElement().getThemeList();
            if (themeList.contains(Lumo.DARK)) {
                themeList.remove(Lumo.DARK);
            } else {
                themeList.add(Lumo.DARK);
            }
        });
        // Layout:
        HorizontalLayout layout = new HorizontalLayout();
        Text text = new Text("Hallo " + student.getFirstName());
        layout.add(text, theme, menuBar);
        layout.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.add(layout);
        verticalLayout.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.END);
        return verticalLayout;
    }
    private void logoutUser() {
        UI ui = this.getUI().get();
        ui.getSession().close();
        ui.getPage().setLocation("/Login");
    }

    private void navigateToStudentProfilView(){
        UI.getCurrent().navigate(StudentProfilView.class);
    }
    private void navigateToStudentView(){
        UI.getCurrent().navigate(StudentView.class);
    }
}