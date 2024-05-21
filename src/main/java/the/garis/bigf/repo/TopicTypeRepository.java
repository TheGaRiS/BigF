package the.garis.bigf.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import the.garis.bigf.entity.TopicType;

@Repository
public interface TopicTypeRepository extends JpaRepository<TopicType, Long> {
}
