package org.hbrs.se2.project.npng.view.layoutview;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.ThemeList;
import com.vaadin.flow.theme.lumo.Lumo;

@CssImport("./themes/nopainnogain/components/Startseite.css")

public class StartSeiteLayout extends AppLayout {
    public StartSeiteLayout(){
        addToNavbar(createHeaderContent_Headline());
        addToNavbar(createHeaderContent_Icon());
    }

    private Component createHeaderContent_Headline(){
        // Header erstellen:
        H2 h1 = new H2("No-Pain_No-Gain");
        h1.setId("h1_Startseite");
        // Layout:
        VerticalLayout v_layout = new VerticalLayout();
        v_layout.add(h1);
        v_layout.setHorizontalComponentAlignment(FlexComponent.Alignment.START, h1);
        return v_layout;
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