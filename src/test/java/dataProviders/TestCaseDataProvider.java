package dataProviders;

import org.testng.annotations.DataProvider;
import utils.TestCaseFactory;

public class TestCaseDataProvider {
    @DataProvider(name = "testCaseDataProvider")
    public static Object[][] testData() {
        return new Object[][]{{TestCaseFactory.getFullInfoTestCase()}};
    }
}


