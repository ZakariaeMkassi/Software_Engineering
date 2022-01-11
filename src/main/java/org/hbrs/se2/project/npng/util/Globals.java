package org.hbrs.se2.project.npng.util;

public class Globals {

    public static String CURRENT_USER = "User";
    public static String CURRENT_STUDENT = "Student";
    public static String CURRENT_UNTERNEHMEN = "current_Unternehmen";
    public static String CURRENT_ANZEIGE = "current_Anzeige";

    public static class Pages {
        public static final String EINSTELLUNG = "Einstellung";
        public static final String STUDENTPROFIL_BEARBEITEN = "StudentProfilBearbeiten";
        public static final String STUDENTVIEW = "startseite";
        public static final String REGISTRIERUNG = "registrierung";
        public static final String UNTERNEHMENSANZEIGE = "unternehmensanzeige";
        public static final String STELLENANZEIGENUNTERNEHMEN = "eigene_stellenanzeigen_anzeigen";
        public static final String STELLENANZEIGEERSTELLEN = "stellenanzeige_erstellen";
        public static final String STELLENANZEIGENSTUDENT = "alle_stellenanzeigen_anzeigen";
        public static final String BEWERBUNGERSTELLEN = "bewerbung_erstellen";
        public static final String BEWERBUNGENUNTERNEHMEN = "bewerbungen_einsehen";

        public static final String LOGIN_VIEW = "login";
        public static final String MAIN_VIEW = "";
        public static final String UNTERNEHMEN_PROFIL_VIEW = "unternehmen_profil";
        public static final String STUDENT_PROFIL_VIEW = "student_profil";
    }
    public static class Roles {
        public static final String STUDENT = "student";
        public static final String UNTERNEHMEN = "unternehmen";

    }

    public static class Errors {
        public static final String NOUSERFOUND = "nouser";
        public static final String SQLERROR = "sql";
        public static final String DATABASE = "database";
    }


}
