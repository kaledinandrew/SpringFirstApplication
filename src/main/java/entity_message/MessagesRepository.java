package entity_message;

import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;
public interface MessagesRepository extends CrudRepository<Message, Long> {
    List<Message> findByTag(String tag);
}
