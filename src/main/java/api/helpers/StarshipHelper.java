package api.helpers;

import api.serives.BaseService;
import api.pojos.Starship;
import api.serives.StarshipService;
import com.google.gson.reflect.TypeToken;
import org.asynchttpclient.util.HttpConstants;

import java.util.List;

public class StarshipHelper extends BaseService {

    //To not allow to create instance as all functions are static
    private StarshipHelper() {
    }

    public static Starship findStarshipFromUrlsByStarshipClass(List<String> urls, String name) {
        for (String url : urls) {
            String starshipName = StarshipService.getStarshipByUrl(url)
                    .then()
                    .statusCode(HttpConstants.ResponseStatusCodes.OK_200)
                    .extract()
                    .path("starship_class");
            if (starshipName.equals(name)) {
                return StarshipService.getStarshipByUrl(url).andReturn().as(new TypeToken<Starship>() {
                }.getType());
            }
        }
        return null;
    }
}
