package tests;

import com.codeborne.selenide.Condition;
import dataProviders.TestCaseDataProvider;
import models.TestCase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.NewTestCasePage;
import pages.ProjectPage;
import pages.ProjectsPage;

public class TestCaseTests extends BaseTest {
    private ProjectsPage projectsPage;
    private ProjectPage projectPage;
    private NewTestCasePage createTestCasePage;

    @BeforeClass
    public void initialise() {
        projectsPage = new ProjectsPage();
        projectPage = new ProjectPage();
        createTestCasePage = new NewTestCasePage();
    }

    @Test(dataProvider = "testCaseDataProvider",
            dataProviderClass = TestCaseDataProvider.class,
            description = "Add a test case. Verify that alert about " +
                    "successful test case creation is shown")
    public void addTestCase(TestCase inputTestCase) {
        loginPage.login(DEFAULT_EMAIL, DEFAULT_PASSWORD);
        projectsPage.waitForPageLoaded();
        projectsPage.openProject("Test");
        projectPage.waitForPageLoaded();
        projectPage.clickCreateTestCaseButton();
        createTestCasePage.waitForPageLoaded();
        createTestCasePage.fillForm(inputTestCase);
        createTestCasePage.clickSave();
        projectPage.getAlert().should(
                Condition.matchText("Test case was created successfully!"));
    }
}
