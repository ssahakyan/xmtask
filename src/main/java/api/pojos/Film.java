package api.pojos;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Film {

    @SerializedName("title")
    private String title;
    @SerializedName("episode_id")
    private Integer episodeId;
    @SerializedName("opening_crawl")
    private String openingCrawl;
    @SerializedName("director")
    private String director;
    @SerializedName("producer")
    private String producer;
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("characters")
    private List<String> characters;
    @SerializedName("planets")
    private List<String> planets;
    @SerializedName("starships")
    private List<String> starships;
    @SerializedName("vehicles")
    private List<String> vehicles;
    @SerializedName("species")
    private List<String> species;
    @SerializedName("created")
    private String created;
    @SerializedName("edited")
    private String edited;
    @SerializedName("url")
    private String url;
}