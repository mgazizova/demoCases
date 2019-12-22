package hello;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author vtarasov
 * @since 22.12.2019
 */
@Repository
public interface TestCaseRepository extends JpaRepository<TestCase, Integer> {}
