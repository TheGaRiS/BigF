package bot.bigf.dto;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
public class OperationMapper implements RowMapper<Operation> {

    @Override
    public Operation mapRow(ResultSet rs, int rowNum) throws SQLException {

        var entity = new Operation(
                rs.getInt("id"),
                rs.getDouble("amount"),
                rs.getTimestamp("create_time"),
                rs.getInt("topic_id")
        );

        return entity;

    }

}
