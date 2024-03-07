package bot.bigf.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@RequiredArgsConstructor
public class User {

    @JsonProperty("id")
    private final int id;

    @JsonProperty("name")
    private final String name;

    @JsonProperty("description")
    private final String description;

    private String startWord = "";

    public String toString() { return startWord + description;}
}
