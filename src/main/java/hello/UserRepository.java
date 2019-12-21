package hello;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author vtarasov
 * @since 22.12.2019
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> getByLoginAndPassword(String login, String password);
}
