package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.LoginPage;

public class BaseTest {
    protected final String DEFAULT_EMAIL = "naum1979alex@gmail.com";
    protected final String DEFAULT_PASSWORD = "Password1*";
    protected LoginPage loginPage;
    protected HomePage homePage;

    @BeforeClass
    public void setup() {
        loginPage = new LoginPage();
        homePage = new HomePage();
    }

    @BeforeMethod(alwaysRun = true)
    public void navigate() {
        loginPage.open();
    }
}
