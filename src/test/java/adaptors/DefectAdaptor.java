package adaptors;

import com.google.gson.reflect.TypeToken;
import models.AllEntitiesResult;
import models.Response;
import models.defect.Defect;

public class DefectAdaptor extends BaseAdaptor {
    private final static String ENDPOINT = "defect";

    public Response<AllEntitiesResult<Defect>> getAllDefects(String projectCode,
                                                             int limit, int statusCode) {
        return gson.fromJson(
            get(ENDPOINT + "/" + projectCode + "?limit=" + limit,
                statusCode),
                new TypeToken<Response<AllEntitiesResult<Defect>>>(){}.getType());
    }

    public Response<Defect> createDefect(String projectCode, String requestBody, int statusCode) {
        return gson.fromJson(post(ENDPOINT + "/" + projectCode, statusCode, requestBody),
            new TypeToken<Response<Defect>>(){}.getType());
    }
    public Response<Defect> getDefectByProjectCodeAndDefectId(String projectCode,
                                                  int defectId, int statusCode) {
        return gson.fromJson(
                get(ENDPOINT + "/" + projectCode + "/" + defectId, statusCode),
                new TypeToken<Response<Defect>>(){}.getType());
    }
    public Response<Defect> deleteDefectByProjectCodeAndDefectId(String projectCode, int defectId,
                                                                 int statusCode) {
        return gson.fromJson(
            delete(ENDPOINT + "/" + projectCode + "/" + defectId, statusCode),
            new TypeToken<Response<Defect>>(){}.getType());
    }

    public Response<Defect> updateDefectByProjectCodeAndDefectId(String projectCode, int defectId,
                                                                 String requestBody, int statusCode) {
        return gson.fromJson(
            patch(ENDPOINT + "/" + projectCode + "/" + defectId, requestBody, statusCode),
            new TypeToken<Response<Defect>>(){}.getType());
    }
}
