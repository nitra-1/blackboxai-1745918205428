package com.leasingstore.controller;

import com.leasingstore.entity.Message;
import com.leasingstore.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for managing messages between users and providers
 */
@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/between/{userId1}/{userId2}")
    public List<Message> getMessagesBetweenUsers(@PathVariable Long userId1, @PathVariable Long userId2) {
        return messageService.getMessagesBetweenUsers(userId1, userId2);
    }

    @PostMapping
    public Message sendMessage(@RequestBody Message message) {
        return messageService.sendMessage(message);
    }
}
