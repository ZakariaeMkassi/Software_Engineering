package org.hbrs.se2.project.npng.CollabTests;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;

/*
public class SeleniumTest {

    private static WebDriver driver = null;


    public SeleniumTest() {

    }

    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\erdal\\Documents\\geckodriver-v0.30.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @AfterClass
    public static void tearDownClass() {
        driver.quit();
    }

    @Test
    public void loginNegativTest() {
        //go to NPNG
        driver.get("http://localhost:8080/");

        //go to Login Button
        driver.findElement(By.xpath("/html/body/vaadin-app-layout/vaadin-vertical-layout[3]/vaadin-button[3]")).click();

        //Enter Username
        driver.findElement(By.xpath("/html/body/vaadin-login-overlay-wrapper/vaadin-login-form/vaadin-login-form-wrapper/form/vaadin-text-field/input")).sendKeys("Login");

        //Press Login Button to Log in
        driver.findElement(By.xpath("/html/body/vaadin-login-overlay-wrapper/vaadin-login-form/vaadin-login-form-wrapper/form/vaadin-button")).click();

    }

    @Test
    public void loginPositivTest() {
        //go to NPNG
        driver.get("http://localhost:8080/");

        //go to Login Button
        driver.findElement(By.xpath("/html/body/vaadin-app-layout/vaadin-vertical-layout[3]/vaadin-button[3]")).click();

        //Enter Username
        driver.findElement(By.xpath("/html/body/vaadin-login-overlay-wrapper/vaadin-login-form/vaadin-login-form-wrapper/form/vaadin-text-field/input")).sendKeys("Login");

        //Enter Password
        driver.findElement(By.xpath("/html/body/vaadin-login-overlay-wrapper/vaadin-login-form/vaadin-login-form-wrapper/form/vaadin-password-field/input")).sendKeys("Groß,Klein,Ziffer,Sonderzeichen");
        //Press Login Button to Log in
        driver.findElement(By.xpath("/html/body/vaadin-login-overlay-wrapper/vaadin-login-form/vaadin-login-form-wrapper/form/vaadin-button")).click();
    }

    @Test
    public void registrierungNegativTest() {
        //go to NPNG
        driver.get("http://localhost:8080/");

        //go to Student registrieren
        driver.findElement(By.xpath("/html/body/vaadin-app-layout/vaadin-vertical-layout[3]/vaadin-button[2]")).click();

        //Enter Data
        driver.findElement(By.xpath("/html/body/vaadin-app-layout/vaadin-vertical-layout[2]/vaadin-horizontal-layout[1]/vaadin-vertical-layout/vaadin-text-field[1]")).sendKeys("Vorname");
        driver.findElement(By.xpath("/html/body/vaadin-app-layout/vaadin-vertical-layout[2]/vaadin-horizontal-layout[1]/vaadin-vertical-layout/vaadin-text-field[2]")).sendKeys("Nachname");
        driver.findElement(By.xpath("/html/body/vaadin-app-layout/vaadin-vertical-layout[2]/vaadin-horizontal-layout[1]/vaadin-vertical-layout/vaadin-email-field")).sendKeys("email@hbrs.de");
        driver.findElement(By.xpath("/html/body/vaadin-app-layout/vaadin-vertical-layout[2]/vaadin-horizontal-layout[1]/vaadin-vertical-layout/vaadin-password-field[1]")).sendKeys("abc");
        driver.findElement(By.xpath("/html/body/vaadin-app-layout/vaadin-vertical-layout[2]/vaadin-horizontal-layout[1]/vaadin-vertical-layout/vaadin-password-field[2]")).sendKeys("abc");

        //Press Registrieren
        driver.findElement(By.xpath("//*[@id=\"Student_Buttons\"]")).click();
    }
}
 */

