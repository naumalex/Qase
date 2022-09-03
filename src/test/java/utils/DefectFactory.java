package utils;

import enums.common.Severity;
import models.Defect;

public class DefectFactory {
    private static final String TEST_TAG = "Test";
    private static final String TEST_MILESTONE = "Test Milestone";
    private static final String TEST_ASSIGNEE = "Alexander Naumovets";

    public static Defect getFullInfoTestCase() {
        return Defect.builder()
                .defectTitle("Authorization fails for valid credentials")
                .actualResult("Registered users cannot log in to the application " +
                        "using email and password.")
                .milestone(TEST_MILESTONE)
                .severity(Severity.MINOR)
                .assignee(TEST_ASSIGNEE)
                .tags(TEST_TAG)
                .build();
    }
}
