package models.defect;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Tag {
    private String title;
    private int internal_id;
}
