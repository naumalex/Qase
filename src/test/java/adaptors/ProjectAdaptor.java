package adaptors;

public class ProjectAdaptor extends BaseAdaptor {
    private static String ENDPOINT = "projects";

    public String getAllProjects(int statusCode) {
        return get(ENDPOINT, statusCode);
    }

    public String createProject(int statusCode, String requestBody) {
        return post(ENDPOINT, statusCode, requestBody);
    }

    public String getProjectByCode(int statusCode, String) {

    }

    public String deleteProjectByCode() {
       // return null;
    }

}
