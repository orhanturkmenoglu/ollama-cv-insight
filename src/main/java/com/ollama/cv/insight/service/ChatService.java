package com.ollama.cv.insight.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final ChatClient chatClient;

    public ChatService(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }

    public String generation(String userInput) {
        return this.chatClient.prompt()
                .user(userInput)
                .call()
                .content();
    }

    public String buildPrompt(String cvText) {
        return """
                Aşağıdaki özgeçmişi detaylı şekilde analiz et.
                 Güçlü yönlerini,
                 eksik becerilerini
                 ve hangi pozisyonlara uygun olduğunu belirt ve 100 üzerinden puanla:
            
                
                Özgeçmiş:
                %s
                
                Cevabını detaylı ve madde madde yaz.
                """.formatted(cvText);
    }
}
