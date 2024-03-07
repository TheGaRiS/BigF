package bot.bigf.repository;

import bot.bigf.dto.User;

import java.util.List;

public interface IUserRepository {

    User getById(int id);

    List<User> getUserList();

    int insert(User entity);

    void delete(User entity);
}
