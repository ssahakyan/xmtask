package api.pojos;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GenericItemResponse<T> {
    @SerializedName("count")
    private Integer count;
    @SerializedName("next")
    private Object next;
    @SerializedName("previous")
    private Object previous;
    @SerializedName("results")
    private List<T> results;
}