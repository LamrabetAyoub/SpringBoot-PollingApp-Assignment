package lamrabet_ayoub.polling_app.repository;

import lamrabet_ayoub.polling_app.model.Option;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OptionRepository extends JpaRepository<Option, Long> {
    List<Option> findByPollId(Long pollId);
}