package api.serives;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StarshipService extends BaseService {
    private static final String URL = "/starships";

    //To not allow to create instance as all functions are static
    private StarshipService() {
    }

    public static Response getAllStarships() {
        RequestSpecification request = configRequestAPI();
        request.basePath(URL);
        return get(request);
    }

    public static Response getStarshipById(int id) {
        RequestSpecification request = configRequestAPI();
        request.basePath(URL + "/" + id);
        return get(request);
    }

    public static Response getStarshipByUrl(String url) {
        RequestSpecification request = configRequestAPI();
        request.baseUri(url);
        return get(request);
    }
}
