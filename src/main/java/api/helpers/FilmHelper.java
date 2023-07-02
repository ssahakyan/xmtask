package api.helpers;

import api.pojos.Film;
import api.pojos.GenericItemResponse;
import api.serives.FilmService;
import com.google.gson.reflect.TypeToken;
import io.restassured.response.Response;
import org.asynchttpclient.util.HttpConstants;

import java.util.ArrayList;
import java.util.List;

public class FilmHelper {

    //To not allow to create instance as all functions are static
    private FilmHelper() {
    }

    public static List<Film> getAllFilms() {
        int currentPageNumber = 1;
        boolean hasNextPage = true;
        List<Film> films = new ArrayList<>();

        //in case there are more than one page
        while (hasNextPage) {
            Response response = FilmService.getAllFilms(currentPageNumber)
                    .then()
                    .assertThat()
                    .statusCode(HttpConstants.ResponseStatusCodes.OK_200)
                    .extract()
                    .response();

            GenericItemResponse<Film> film = response.andReturn().as(new TypeToken<GenericItemResponse<Film>>() {
            }.getType());
            films.addAll(film.getResults());
            currentPageNumber++;
            hasNextPage = film.getNext() != null;
        }
        return films;
    }

    public static Film getFilmByName(String name) {
        return getAllFilms().stream()
                .filter(streamFilm -> streamFilm.getTitle().equalsIgnoreCase(name))
                .findAny()
                .orElse(null);
    }
}
