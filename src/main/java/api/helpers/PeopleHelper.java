package api.helpers;

import api.pojos.People;
import api.serives.PeopleService;
import com.google.gson.reflect.TypeToken;
import org.asynchttpclient.util.HttpConstants;

import java.util.List;

public class PeopleHelper {

    //To not allow to create instance as all functions are static
    private PeopleHelper() {
    }

    public static People getPeopleFromUrlsByName(List<String> urls, String name) {
        for (String url : urls) {
            String personName = PeopleService.getPeopleByUrl(url)
                    .then()
                    .statusCode(HttpConstants.ResponseStatusCodes.OK_200)
                    .extract()
                    .path("name");
            if (personName.equals(name)) {
                return PeopleService.getPeopleByUrl(url).andReturn().as(new TypeToken<People>() {
                }.getType());
            }
        }
        return null;
    }
}
