package fakhredinne.king_chapati.services;

import fakhredinne.king_chapati.models.Conversation;
import fakhredinne.king_chapati.models.Message;
import fakhredinne.king_chapati.repository.ConversationRepository;
import fakhredinne.king_chapati.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ConversationService {
    @Autowired
    private ConversationRepository conversationRepository;
    @Autowired
    private MessageRepository messageRepository;
    public List<Conversation> findAll() {
        return conversationRepository.findAll();
    }
    public Message sendMessage(Message msg){
        Message ms = messageRepository.save(msg);
        return ms;
    }

}
