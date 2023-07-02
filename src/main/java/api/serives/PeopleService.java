package api.serives;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PeopleService extends BaseService {
    private static final String URL = "/people";

    //To not allow to create instance as all functions are static
    private PeopleService() {
    }

    public static Response getAllPeoples() {
        RequestSpecification request = configRequestAPI();
        request.basePath(URL);
        return get(request);
    }

    public static Response getPeople(int id) {
        RequestSpecification request = configRequestAPI();
        request.basePath(URL + "/" + id);
        return get(request);
    }

    public static Response getPeopleByUrl(String url) {
        RequestSpecification request = configRequestAPI();
        request.baseUri(url);
        return get(request);
    }
}
