package api.serives;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FilmService extends BaseService {
    private static final String URL = "/films";

    //To not allow to create instance as all functions are static
    private FilmService() {
    }

    public static Response getAllFilms(int page) {
        RequestSpecification request = configRequestAPI();
        request.basePath(URL).queryParam("page", page);
        return get(request);
    }
}
