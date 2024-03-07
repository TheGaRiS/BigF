package bot.bigf.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TopicType {

    @JsonProperty("id")
    private final int id;

    @JsonProperty("name")
    private final String name;

}
