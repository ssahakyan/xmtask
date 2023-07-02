package com.xm.api;

import api.helpers.FilmHelper;
import api.helpers.PeopleHelper;
import api.helpers.StarshipHelper;
import api.pojos.Film;
import api.pojos.People;
import api.pojos.Starship;
import api.serives.FilmService;
import api.serives.PeopleService;
import api.serives.StarshipService;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.asynchttpclient.util.HttpConstants;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class ApiTest {

    @Test
    public void functionalTest() {
        Film film = FilmHelper.getFilmByName("A New Hope");
        assertNotNull(film, "'A New Hope' film is not found");

        People personByName = PeopleHelper.getPeopleFromUrlsByName(film.getCharacters(), "Biggs Darklighter");
        assertNotNull(personByName, "Person with 'Biggs Darklighter' is not in the film characters list");

        Starship starshipByFilter = StarshipHelper.findStarshipFromUrlsByStarshipClass(personByName.getStarships(), "Starfighter");
        assertNotNull(starshipByFilter, "Person haven't flight on Starfighter starship");

        People personFlightedNoStarship = PeopleHelper.getPeopleFromUrlsByName(starshipByFilter.getPilots(), "Luke Skywalker");
        assertNotNull(personFlightedNoStarship, "'Luke Skywalker' haven't flight on Starfighter");
    }


    @Test
    public void starshipSchemeValidation() {
        String starship = StarshipService.getAllStarships()
                .then()
                .statusCode(HttpConstants.ResponseStatusCodes.OK_200)
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/starships.json"))
                .extract()
                .path("results[0].url");

        StarshipService
                .getStarshipByUrl(starship)
                .then()
                .statusCode(HttpConstants.ResponseStatusCodes.OK_200)
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/starship.json"));
    }

    @Test
    public void peopleSchemeValidation() {
        String starship = PeopleService.getAllPeoples()
                .then()
                .statusCode(HttpConstants.ResponseStatusCodes.OK_200)
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/people.json"))
                .extract()
                .path("results[0].url");

        StarshipService
                .getStarshipByUrl(starship)
                .then()
                .statusCode(HttpConstants.ResponseStatusCodes.OK_200)
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/person.json"));
    }

    @Test
    public void filmSchemeValidation() {
        String starship = FilmService.getAllFilms(1)
                .then()
                .statusCode(HttpConstants.ResponseStatusCodes.OK_200)
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/films.json"))
                .extract()
                .path("results[0].url");

        StarshipService
                .getStarshipByUrl(starship)
                .then()
                .statusCode(HttpConstants.ResponseStatusCodes.OK_200)
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/film.json"));
    }
}
