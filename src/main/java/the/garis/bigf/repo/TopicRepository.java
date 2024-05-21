package the.garis.bigf.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import the.garis.bigf.entity.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
}
