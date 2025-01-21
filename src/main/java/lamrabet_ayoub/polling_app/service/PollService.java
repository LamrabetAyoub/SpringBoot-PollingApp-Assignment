package lamrabet_ayoub.polling_app.service;

import jakarta.transaction.Transactional;
import lamrabet_ayoub.polling_app.model.Poll;
import lamrabet_ayoub.polling_app.model.User;
import lamrabet_ayoub.polling_app.repository.PollRepository;
import lamrabet_ayoub.polling_app.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PollService {
    private final PollRepository pollRepository;
    private final UserRepository userRepository;

    public PollService(PollRepository pollRepository , UserRepository userRepository) {
        this.pollRepository = pollRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public Poll createPoll(Poll poll, Long userId) {
        // Fetch the User entity by ID
        Optional<User> user = userRepository.findById(userId);



        // Save the poll
        return pollRepository.save(poll);
    }
    public Optional<Poll> getPollById(Long id) {
        return pollRepository.findById(id);
    }

    public List<Poll> getAllPolls() {
        return pollRepository.findAll();
    }

    public Optional<Poll> updatePoll(Long id, Poll poll) {
        return pollRepository.findById(id).map(existingPoll -> {
            existingPoll.setQuestion(poll.getQuestion());

            existingPoll.setOptions(poll.getOptions());
            return pollRepository.save(existingPoll);
        });
    }

    public void deletePoll(Long id) {
        pollRepository.deleteById(id);
    }
}