package models;

import com.github.javafaker.Address;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectResponse {

    @Builder.Default
    public boolean status = true;
    Result result;
}
