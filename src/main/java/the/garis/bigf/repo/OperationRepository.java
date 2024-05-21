package the.garis.bigf.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import the.garis.bigf.entity.Operation;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {
}
