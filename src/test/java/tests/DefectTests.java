package tests;

import com.codeborne.selenide.Condition;
import dataProviders.DefectDataProvider;
import models.Defect;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DefectsPage;
import pages.NewDefectPage;
import pages.ProjectPage;
import pages.ProjectsPage;

public class DefectTests extends BaseTest {
    private ProjectsPage projectsPage;
    private ProjectPage projectPage;
    private DefectsPage defectsPage;
    private NewDefectPage newDefectPage;

    @BeforeClass
    public void initialise() {
        projectsPage = new ProjectsPage();
        projectPage = new ProjectPage();
        defectsPage = new DefectsPage();
        newDefectPage = new NewDefectPage();
    }

    @Test(dataProvider = "defectDataProvider",
            dataProviderClass = DefectDataProvider.class,
            description = "Add a defect. Verify that alert about successful defect" +
                    "creation is shown")
    public void addDefect(Defect inputDefect) {
        loginPage.login(DEFAULT_EMAIL, DEFAULT_PASSWORD);
        projectsPage.waitForPageLoaded();
        projectsPage.openProject("Test");
        projectPage.waitForPageLoaded();
        projectPage.clickDefects();
        defectsPage.waitForPageLoaded();
        defectsPage.clickCreateNewDefect();
        newDefectPage.waitForPageLoaded();
        newDefectPage.fillForm(inputDefect);
        newDefectPage.clickCreateDefect();
        projectPage.getAlert().should(
                Condition.matchText("Defect was created successfully!"));
    }
}
