package fakhredinne.king_chapati.repository;

import fakhredinne.king_chapati.models.Conversation;
import fakhredinne.king_chapati.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{
    public List<Message> findAll();
}
