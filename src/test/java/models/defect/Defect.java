package models.defect;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Defect {
    private Integer id;
    private String title;
    private String actual_result;
    private String status;
    private Integer milestone_id;
    private Integer project_id;
    private String severity;
    private Integer member_id;
    private List<Attachment> attachments;
    private List<Object> custom_fields;
    private String external_data;
    private String resolved_at;
    private String created;
    private String updated;
    private String created_at;
    private String updated_at;
    private List<Tag> tags;
}
