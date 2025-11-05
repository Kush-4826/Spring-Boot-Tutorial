package org.example.springaidemo.controller;

import org.springframework.ai.google.genai.GoogleGenAiChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeminiController {
    private GoogleGenAiChatModel chatModel;

    public GeminiController(GoogleGenAiChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @GetMapping("/api/gemini/ask")
    public String greet(@RequestParam String q) {
        String response = chatModel.call("Answer the following question in one precise line.. Do not add anything else in the response. " + q);
        return response;
    }
}
