package api.pojos;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.List;

@Getter
public class People {

    @SerializedName("name")
    private String name;
    @SerializedName("height")
    private String height;
    @SerializedName("mass")
    private String mass;
    @SerializedName("hair_color")
    private String hairColor;
    @SerializedName("skin_color")
    private String skinColor;
    @SerializedName("eye_color")
    private String eyeColor;
    @SerializedName("birth_year")
    private String birthYear;
    @SerializedName("gender")
    private String gender;
    @SerializedName("homeworld")
    private String homeworld;
    @SerializedName("films")
    private List<String> films;
    @SerializedName("species")
    private List<Object> species;
    @SerializedName("vehicles")
    private List<String> vehicles;
    @SerializedName("starships")
    private List<String> starships;
    @SerializedName("created")
    private String created;
    @SerializedName("edited")
    private String edited;
    @SerializedName("url")
    private String url;
}