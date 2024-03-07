package bot.bigf.repository;

import bot.bigf.dto.User;
import bot.bigf.dto.UserMapper;
import bot.bigf.exceptions.DbException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository
public class UserRepository implements IUserRepository{

    private static final String SQL_SELECT_BY_NAME = "SELECT * FROM big_f.user WHERE id = ?";
    private static final String SQL_SELECT_LIST = "SELECT * FROM big_f.user";
    private static final String SQL_INSERT = "INSERT INTO big_f.user (name, description) VALUES (?, ?) RETURNING id";
    private static final String SQL_DELETE = "DELETE FROM big_f.user WHERE id = ?";

    protected final static UserMapper USER_MAPPER = new UserMapper();

    protected final JdbcTemplate template;

    public UserRepository(@Qualifier("bot-db") JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public User getById(int id) throws DbException {

        try {
            return DataAccessUtils.singleResult(template.query(SQL_SELECT_BY_NAME, USER_MAPPER, id));
        } catch (DataAccessException exception) {
            throw new DbException(exception);
        }

    }

    @Override
    public List<User> getUserList() throws DbException {

        try {
            return template.query(SQL_SELECT_LIST, USER_MAPPER);
        } catch (DataAccessException exception) {
            throw new DbException(exception);
        }

    }

    @Override
    public int insert(User entity) throws DbException{

        SimpleJdbcInsert insert = new SimpleJdbcInsert(template).withSchemaName("big_f").withTableName("user").usingGeneratedKeyColumns("id");

        try {
            final Map<String, Object> params = new HashMap<>();
            params.put("name", entity.getName());
            params.put("description", entity.getDescription());
            int result = insert.executeAndReturnKey(params).intValue();
            if (result > 0) log.trace("UserRepository.update() with {} rows inserted", entity);
            log.info("insert({}) result={}", entity, result);
            return result;
        } catch (DataAccessException exception) {
            throw new DbException(exception);
        }
    }

    @Override
    public void delete(User entity) {
        try {
            var result = template.update(SQL_DELETE, entity.getId());
            if (result != 1) log.trace("UserRepository.delete() with {} rows deleted", entity);
            log.info("delete({}) result={}", entity, result);
        } catch (DataAccessException exception) {
            throw new DbException(exception);
        }

    }
}
