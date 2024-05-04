package fakhredinne.king_chapati.repository;

import fakhredinne.king_chapati.models.Conversation;
import fakhredinne.king_chapati.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConversationRepository extends JpaRepository<Conversation, Long> {
    public List<Conversation> findAll();


}
