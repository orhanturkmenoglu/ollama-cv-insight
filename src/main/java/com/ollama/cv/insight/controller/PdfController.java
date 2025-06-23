package com.ollama.cv.insight.controller;

import com.ollama.cv.insight.service.PdfReaderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/pdf")
public class PdfController {


    private PdfReaderService pdfReaderService;

    public PdfController(PdfReaderService pdfReaderService) {
        this.pdfReaderService = pdfReaderService;
    }

    @Operation(
            summary = "Extract text from PDF file",
            description = "Reads the uploaded PDF file and returns the text contained within."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Text extracted successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid file or read error"),
            @ApiResponse(responseCode = "500", description = "Server error")
    })
    @PostMapping("/read")
    public ResponseEntity<String> readPdf(
            @Parameter(description = "PDF file to extract text from", required = true)
            @RequestParam("file") MultipartFile file) {
        try {
            String text = pdfReaderService.extractTextFromPdf(file);
            return ResponseEntity.ok(text);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}