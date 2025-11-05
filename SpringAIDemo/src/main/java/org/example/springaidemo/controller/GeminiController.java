package org.example.springaidemo.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.google.genai.GoogleGenAiChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class GeminiController {
    private ChatClient chatClient;
    ChatMemory chatMemory = MessageWindowChatMemory.builder().build();

//    public GeminiController(GoogleGenAiChatModel chatModel) {
//        this.chatClient = ChatClient.create(chatModel);
//    }

    // Automatically builds the Chat client based on the api key you set in application.properties
    public GeminiController(ChatClient.Builder builder) {
        this.chatClient = builder
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build())
                .build();
    }

    @GetMapping("/api/gemini/ask")
    public ResponseEntity<String> greet(@RequestParam String q) {
        ChatResponse chatResponse = chatClient
                .prompt("Answer the following question in one precise line.. Do not add anything else in the response. " + q)
                .call()
                .chatResponse();
        String response = chatResponse.getResult().getOutput().getText();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/api/gemini")
    public ResponseEntity<String> ask(@RequestParam String q) {
        ChatResponse chatResponse = chatClient
                .prompt(q)
                .call()
                .chatResponse();
        String response = chatResponse.getResult().getOutput().getText();
        return ResponseEntity.ok(response);
    }
}
