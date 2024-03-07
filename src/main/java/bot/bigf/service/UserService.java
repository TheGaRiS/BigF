package bot.bigf.service;

import bot.bigf.dto.User;
import bot.bigf.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jvnet.hk2.annotations.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService extends BaseService{

    protected final IUserRepository repo;

    public List<User> getUserList() {
        log.trace("#### getUserList() - working");
        return wrapResults(repo.getUserList());
    }

    public User getById(int id) {
        log.trace("#### getById() [id={}]", id);
        return wrapResult(repo.getById(id));
    }

    public void insert(User user) {
        log.trace("#### insert() [entity={}]", user);
        repo.insert(user);
    }

    public void delete(User user) {
        log.trace("#### delete() [entity={}]", user);
        repo.delete(user);
    }
}
