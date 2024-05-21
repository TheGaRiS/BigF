package the.garis.bigf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import the.garis.bigf.entity.Operation;
import the.garis.bigf.entity.Topic;
import the.garis.bigf.entity.TopicType;
import the.garis.bigf.entity.User;
import the.garis.bigf.repo.OperationRepository;
import the.garis.bigf.repo.TopicRepository;
import the.garis.bigf.repo.TopicTypeRepository;
import the.garis.bigf.repo.UserRepository;

import java.util.List;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {

    private final UserRepository userRepository;
    private final TopicRepository topicRepository;
    private final OperationRepository operationRepository;
    private final TopicTypeRepository topicTypeRepository;

    public AppStartupEvent(UserRepository userRepository, TopicRepository topicRepository,
                           OperationRepository operationRepository, TopicTypeRepository topicTypeRepository) {
        this.userRepository = userRepository;
        this.topicRepository = topicRepository;
        this.operationRepository = operationRepository;
        this.topicTypeRepository = topicTypeRepository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        List<User> users= userRepository.findAll();
        List<Topic> topics = topicRepository.findAll();
        List<TopicType> topicTypes = topicTypeRepository.findAll();
        List<Operation> operations = operationRepository.findAll();
        users.forEach(System.out::println);
        topics.forEach(System.out::println);
        topicTypes.forEach(System.out::println);
        operations.forEach(System.out::println);
    }
}
