package lamrabet_ayoub.polling_app.repository;

import lamrabet_ayoub.polling_app.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {
    long countByPollIdAndOptionId(Long pollId, Long optionId);
}