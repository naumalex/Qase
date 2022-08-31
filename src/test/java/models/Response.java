package models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class Response<T> {
    @Builder.Default
    private boolean status = true;
    private T result;
    private String errorMessage;
    private List<ErrorField> errorFields;
}
