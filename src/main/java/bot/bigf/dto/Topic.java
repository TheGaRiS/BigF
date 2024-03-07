package bot.bigf.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Topic {

    @JsonProperty("id")
    private final int id;

    @JsonProperty("name")
    private final String name;

    @JsonProperty("user_id")
    private final int user_id;

    @JsonProperty("topic_type_id")
    private final int topic_type_id;
}
