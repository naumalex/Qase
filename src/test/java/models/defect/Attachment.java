package models.defect;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Attachment {
    private String hash;
}
