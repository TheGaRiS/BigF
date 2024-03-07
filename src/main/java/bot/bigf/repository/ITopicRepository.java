package bot.bigf.repository;

import bot.bigf.dto.Topic;

import java.util.List;

public interface ITopicRepository {

    List<Topic> getTopicList();

    int insert(Topic entity);

    void delete(Topic entity);

}
