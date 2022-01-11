package org.hbrs.se2.project.npng.view.layoutview;


import com.vaadin.flow.component.*;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.ThemeList;
import com.vaadin.flow.theme.lumo.Lumo;

@CssImport("./themes/nopainnogain/components/LayoutView.css")
public class RegisterLayoutView extends AppLayout {

    public RegisterLayoutView(){
        addToNavbar(createHeaderContent());
        addToNavbar(createHeaderContent_Icon());
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
    private Component createHeaderContent_Icon(){
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
        VerticalLayout v_layout_1 = new VerticalLayout();
        v_layout_1.add(theme);
        v_layout_1.setHorizontalComponentAlignment(FlexComponent.Alignment.END, theme);
        return v_layout_1;
    }
}