package adaptors;

import com.google.gson.reflect.TypeToken;
import models.AllEntitiesResult;
import models.Response;
import models.project.Project;

public class ProjectAdaptor extends BaseAdaptor {
    private final static String ENDPOINT = "project";

    public Response<AllEntitiesResult<Project>> getAllProjects(int statusCode, int limit) {
        return gson.fromJson(get(ENDPOINT + "?limit=" + limit, statusCode),
                new TypeToken<Response<AllEntitiesResult<Project>>>(){}.getType());
    }

    public Response<Project> createProject(int statusCode, String requestBody) {
        return gson.fromJson(post(ENDPOINT, statusCode, requestBody),
            new TypeToken<Response<Project>>(){}.getType());
    }
    public Response<Project> getProjectByCode(int statusCode, String projectCode) {
        return gson.fromJson(
                get(ENDPOINT + "/" + projectCode, statusCode),
                new TypeToken<Response<Project>>(){}.getType());
    }
    public Response<Project> deleteProjectByCode(int statusCode, String projectCode) {
        return gson.fromJson(delete(ENDPOINT + "/" + projectCode, statusCode),
            new TypeToken<Response<Project>>(){}.getType());
    }

}
