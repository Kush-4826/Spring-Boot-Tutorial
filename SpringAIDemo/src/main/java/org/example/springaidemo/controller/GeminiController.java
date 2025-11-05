package org.example.springaidemo.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.google.genai.GoogleGenAiChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeminiController {
    private ChatClient chatClient;

//    public GeminiController(GoogleGenAiChatModel chatModel) {
//        this.chatClient = ChatClient.create(chatModel);
//    }

    // Automatically builds the Chat client based on the api key you set in application.properties
    public GeminiController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
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
}
