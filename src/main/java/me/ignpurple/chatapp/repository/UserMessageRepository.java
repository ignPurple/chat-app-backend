package me.ignpurple.chatapp.repository;

import me.ignpurple.chatapp.model.UserMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface UserMessageRepository extends ReactiveMongoRepository<UserMessage, String> {
    Flux<UserMessage> findAllBy(Pageable pageable);
}
