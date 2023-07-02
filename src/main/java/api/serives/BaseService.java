package api.serives;

import io.restassured.RestAssured;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.SneakyThrows;

import static functional.setup.ConfigurationProperties.API_URL;
import static io.restassured.RestAssured.given;

public abstract class BaseService {

    protected static Response get(RequestSpecification requestSpecification) {
        return requestSpecification.get();
    }

    protected static Response post(RequestSpecification requestSpecification) {
        return requestSpecification.post();
    }

    protected static Response put(RequestSpecification requestSpecification) {
        return requestSpecification.put();
    }

    protected static Response patch(RequestSpecification requestSpecification) {
        return requestSpecification.patch();
    }

    protected static Response delete(RequestSpecification requestSpecification) {
        return requestSpecification.delete();
    }

    @SneakyThrows
    protected static RequestSpecification configRequestAPI() {
        return given()
                .config(RestAssured.config().objectMapperConfig(new ObjectMapperConfig(ObjectMapperType.GSON)))
                .urlEncodingEnabled(false)
                .contentType(ContentType.JSON)
                .baseUri(API_URL)
                .relaxedHTTPSValidation()
                .log()
                .all();
    }
}
