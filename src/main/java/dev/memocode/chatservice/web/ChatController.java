package dev.memocode.chatservice.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    @GetMapping("/chats")
    public String showChats() {
        return "chats";
    }
}
