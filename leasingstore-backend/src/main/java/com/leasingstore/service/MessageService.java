package com.leasingstore.service;

import com.leasingstore.entity.Message;
import com.leasingstore.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing messages between users and providers
 */
@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getMessagesBetweenUsers(Long userId1, Long userId2) {
        return messageRepository.findBySenderIdOrReceiverIdOrderBySentAtAsc(userId1, userId2);
    }

    public Message sendMessage(Message message) {
        return messageRepository.save(message);
    }
}
