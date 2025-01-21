package lamrabet_ayoub.polling_app.repository;

import lamrabet_ayoub.polling_app.model.Poll;
import lamrabet_ayoub.polling_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PollRepository extends JpaRepository<Poll, Long> {
    // Correct method name to match the property in the Poll entity
    List<Poll> findByCreatedBy(User createdBy);
}