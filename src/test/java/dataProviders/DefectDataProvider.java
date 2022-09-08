package dataProviders;

import org.testng.annotations.DataProvider;
import utils.DefectFactory;

public class DefectDataProvider {
    @DataProvider(name = "defectDataProvider")
    public static Object[][] testData() {
        return new Object[][]{{DefectFactory.getFullInfoTestCase()}};
    }
}


