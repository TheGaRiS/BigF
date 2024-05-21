package the.garis.bigf.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import the.garis.bigf.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
