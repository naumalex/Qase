package models;

import enums.common.Severity;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Defect {
    private String defectTitle;
    private String actualResult;
    private String milestone;
    private Severity severity;
    private String assignee;
    private String tags;
}
