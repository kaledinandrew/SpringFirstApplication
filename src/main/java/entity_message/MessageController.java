package entity_message;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @Autowired
    private MessagesRepository repository;

    @GetMapping("/messages")
    public Iterable<Message> getAll() {
        // Fill db with examples
        Message message1 = new Message("some testing text", "tag1");
        Message message2 = new Message("some other testing text", "tag2");
        repository.save(message1);
        repository.save(message2);

        return repository.findAll();
    }
}
