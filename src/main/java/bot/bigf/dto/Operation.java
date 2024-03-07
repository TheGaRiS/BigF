package bot.bigf.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

@Data
@RequiredArgsConstructor
public class Operation {

    @JsonProperty("id")
    private final int id;

    @JsonProperty("amount")
    private final double amount;

    @JsonProperty("createTime")
    private final Timestamp createTime;

    @JsonProperty("topicId")
    private final int topicId;

}
