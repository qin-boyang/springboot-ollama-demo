package com.example.springboot_ollama_demo;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private final ChatModel ollama;

    public ChatController(ChatModel ollama) {
        this.ollama = ollama;
    }

    @GetMapping("/chat")
    public String chat(@RequestParam String prompt) {
        System.out.println("Received prompt: " + prompt);
        String response = ollama.call(prompt);
        System.out.println("Received response: " + response);
        return response;
    }
}
