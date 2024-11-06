package me.ignpurple.chatapp.message;

import me.ignpurple.chatapp.model.UserMessage;
import me.ignpurple.chatapp.repository.UserMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class MessagesController {
    @Autowired
    private UserMessageRepository messageRepository;

    @GetMapping("/loadall")
    public Flux<UserMessage> loadAll() {
        Pageable pageable = PageRequest.of(0, 25, Sort.Direction.DESC, "id");
        return this.messageRepository.findAllBy(pageable);
    }
}
