package com.ollama.cv.insight.controller;

import com.ollama.cv.insight.service.ChatService;
import com.ollama.cv.insight.service.PdfReaderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService chatService;
    private final PdfReaderService pdfReaderService;

    public ChatController(ChatService chatService, PdfReaderService pdfReaderService) {
        this.chatService = chatService;
        this.pdfReaderService = pdfReaderService;
    }

    @Operation(
            summary = "Analyze PDF CV",
            description = "Reads the uploaded PDF format resume and analyzes strengths, weaknesses, and suitable positions using the TinyLLaMA model."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful analysis result"),
            @ApiResponse(responseCode = "400", description = "Invalid file or reading error", content = @Content),
            @ApiResponse(responseCode = "500", description = "Server error", content = @Content)
    })
    @PostMapping(value = "/analyze", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String analyzeCv(
            @Parameter(description = "PDF file to be analyzed", required = true)
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        String cvText = pdfReaderService.extractTextFromPdf(file);
        String prompt = chatService.buildPrompt(cvText);
        return chatService.generation(prompt);
    }
}
