package org.hbrs.se2.project.npng.view;


import com.vaadin.flow.component.UI;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.hbrs.se2.project.npng.entity.User;
import org.hbrs.se2.project.npng.util.Globals;
import org.hbrs.se2.project.npng.view.component.UnternehmerProfil;
import org.hbrs.se2.project.npng.view.layoutview.CompanyLayoutView;

@Route(value = "UnternehmerProfilView",layout = CompanyLayoutView.class)
@PageTitle("No-Pain_No-Gain")

public class UnternehmerProfilView extends UnternehmerProfil {

    private User user = (User) UI.getCurrent().getSession().getAttribute(Globals.CURRENT_USER);

    public UnternehmerProfilView(){

        getUnternehmername().setValue(getCompany().getName());
        getGruendungsjahr().setValue(getCompany().getFoundingYear());
        getHauptsitz().setValue(getCompany().getHeadOffice());
        getEmail().setValue(getUser().getMail());
        getPhone().setValue(getUser().getPhone());
        getAdresse().setValue(getUser().getStreet());
        getPostleitzahl().setValue(getUser().getPlz());
        getOrt().setValue(getUser().getCity());
        getAnzahl_Angestellten().setValue(String.valueOf(getCompany().getNumberOfEmployee()));
        getBranche().setValue(getCompany().getSector());

        getUnternehmername().setReadOnly(true);
        getEmail().setReadOnly(true);
        getPhone().setReadOnly(true);
        getAdresse().setReadOnly(true);
        getPostleitzahl().setReadOnly(true);
        getOrt().setReadOnly(true);
        getBranche().setReadOnly(true);
        getAnzahl_Angestellten().setReadOnly(true);
        getHauptsitz().setReadOnly(true);
        getGruendungsjahr().setReadOnly(true);
        getCancel().setText("Zurück");
        getSave().setText("Profil bearbeiten");

        getCancel().addClickListener(e -> UI.getCurrent().navigate(CompanyView.class));
        getSave().addClickListener(e -> navigateToUnternehmerProfilBearbeitenView());

    }
    private void navigateToUnternehmerProfilBearbeitenView(){
        UI.getCurrent().navigate(UnternehmerProfilBearbeitenView.class);
    }
}
