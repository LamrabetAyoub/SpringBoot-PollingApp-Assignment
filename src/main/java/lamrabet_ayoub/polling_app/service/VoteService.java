package lamrabet_ayoub.polling_app.service;

import lamrabet_ayoub.polling_app.model.Vote;
import lamrabet_ayoub.polling_app.repository.VoteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VoteService {
    private final VoteRepository voteRepository;

    public VoteService(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    public Vote createVote(Vote vote) {
        return voteRepository.save(vote);
    }

    public Optional<Vote> getVoteById(Long id) {
        return voteRepository.findById(id);
    }

    public void deleteVote(Long id) {
        voteRepository.deleteById(id);
    }
}